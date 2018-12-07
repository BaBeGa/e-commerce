package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductVariationEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ShopEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read.TrackingReadResponseParam;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;

import java.sql.Timestamp;
import java.util.*;

public class BuyerServiceImpl implements BuyerService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductVariationRepository productVariationRepository;
    private final ProductRepository productRepository;
    private final ShipOfShopRepository shipOfShopRepository;
    private final OrderPaymentRepository orderPaymentRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final TypeShippingRepository typeShippingRepository;
    private final ConfigRepository configRepository;
    private final ShopHasProductRepository shopHasProductRepository;
    private final ShopRepository shopRepository;
    private final ProductPicRepository productPicRepository;

    public BuyerServiceImpl(OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, ProductVariationRepository productVariationRepository, ProductRepository productRepository, ShipOfShopRepository shipOfShopRepository, OrderPaymentRepository orderPaymentRepository, DeliveryAddressRepository deliveryAddressRepository, TypeShippingRepository typeShippingRepository, ConfigRepository configRepository, ShopHasProductRepository shopHasProductRepository, ShopRepository shopRepository, ProductPicRepository productPicRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.productVariationRepository = productVariationRepository;
        this.productRepository = productRepository;
        this.shipOfShopRepository = shipOfShopRepository;
        this.orderPaymentRepository = orderPaymentRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.typeShippingRepository = typeShippingRepository;
        this.configRepository = configRepository;
        this.shopHasProductRepository = shopHasProductRepository;
        this.shopRepository = shopRepository;
        this.productPicRepository = productPicRepository;
    }
    private void orderReadFunction(List<OrderReadOrderBodyResponse> orderBodyList, List<OrderEntity> order) {
        for (OrderEntity anOrder : order) {
            Double price_total = 0.0;
            List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(anOrder.getIdOrder());
            List<OrderReadOrderItemOrderBodyResponse> orderItemBodyList = new ArrayList<>();
            Common.LoggerInfo(orderItem);
            for (OrderItemEntity anOrderItem: orderItem) {
                OrderReadOrderItemOrderBodyResponse orderItemBody = new OrderReadOrderItemOrderBodyResponse();
                orderItemBody.setId_item(anOrderItem.getIdItem());
                orderItemBody.setId_variation(anOrderItem.getIdVariation());
                ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(anOrderItem.getIdVariation());
                orderItemBody.setName_variation(productVariation.getName());
                ProductEntity product = productRepository.findByIdProduct(productVariation.getIdProduct());
                orderItemBody.setId_product(product.getIdProduct());
                orderItemBody.setName_product(product.getNameProduct());
                List<ProductPicEntity> productPicList = productPicRepository.findAllByIdProduct(product.getIdProduct());
                orderItemBody.setPic_product(productPicList.get(0).getPicProduct());
                ShopHasProductEntity shopHasProduct = shopHasProductRepository.findByIdProduct(product.getIdProduct());
                orderItemBody.setId_shop(shopHasProduct.getIdShop());
                ShopEntity shop = shopRepository.findByIdShop(shopHasProduct.getIdShop());
                orderItemBody.setShop_name(shop.getNameShop());
                price_total += productVariation.getPrice()*anOrderItem.getQuantity();
                orderItemBody.setPrice(productVariation.getPrice());
                orderItemBody.setQuantity(anOrderItem.getQuantity());
                // **
                OrderReadShipOfShopOrderItemOrderBodyResponse ship_of_shop = new OrderReadShipOfShopOrderItemOrderBodyResponse();
                ShipOfShopEntity shipOfShopEntity = shipOfShopRepository.findByIdShip(anOrderItem.getIdShipOfShop());
                if (shipOfShopEntity != null) {
                    TypeShippingEntity typeShippingEntity = typeShippingRepository.findByIdType(shipOfShopEntity.getIdType());
                    ship_of_shop.setId_ship_of_shop(anOrderItem.getIdShipOfShop());
                    ship_of_shop.setSlug(typeShippingEntity.getNameShip());
                    ship_of_shop.setPrice(shipOfShopEntity.getPrice());
                    price_total += ship_of_shop.getPrice();
                    ship_of_shop.setTime_ship(shipOfShopEntity.getTimeShip());
                }
                orderItemBody.setId_ship_of_shop(ship_of_shop);
                orderItemBody.setTracking_number(anOrderItem.getTrackingNumber());

                TrackingServiceImpl trackingService = new TrackingServiceImpl();
                TrackingReadResponseParam trackingResponseParam = trackingService.trackingReadAllResponse(ship_of_shop.getSlug(), anOrderItem.getTrackingNumber());

                List<OrderReadOrderItemCheckpointOrderItemResponse> checkpointList = new ArrayList<>();
                if (trackingResponseParam.getData().getTracking() != null) {
                    for (int i = 0; i < trackingResponseParam.getData().getTracking().getCheckpoints().size(); i++) {
                        if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("InTransit")) {
                            anOrderItem.setOrderItemStatus(OrderItemStatus.SHIPPED);
                        } else if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("Delivered")) {
                            anOrderItem.setOrderItemStatus(OrderItemStatus.DELIVERED);
                            if (anOrderItem.getExpiredBuyerConfirm() == null) {
                                Date dt = new Date();
                                Calendar c = Calendar.getInstance();
                                c.setTime(dt);
                                c.add(Calendar.DATE, 7);
                                dt = c.getTime();
                                Timestamp expired_buyer_confirm = new Timestamp(dt.getTime());
                                anOrderItem.setExpiredBuyerConfirm(expired_buyer_confirm);
                            }
                        }
                        OrderReadOrderItemCheckpointOrderItemResponse checkpoint = new OrderReadOrderItemCheckpointOrderItemResponse();
                        checkpoint.setCheckpoint_time(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCheckpoint_time());
                        checkpoint.setCountry_iso3(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCountry_iso3());
                        checkpoint.setCountry_name(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCountry_name());
                        checkpoint.setCreated_at(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCreated_at());
                        checkpoint.setLocation(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getLocation());
                        checkpoint.setMessage(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getMessage());
                        checkpoint.setSlug(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSlug());
                        checkpoint.setSubtag(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSubtag());
                        checkpoint.setSubtag_message(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSubtag_message());
                        checkpoint.setTag(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag());
                        checkpointList.add(checkpoint);
                    }
                    orderItemRepository.save(anOrderItem);
                }

                orderItemBody.setCheckpoint(checkpointList);
                orderItemBodyList.add(orderItemBody);
            }
            OrderReadOrderBodyResponse orderBody = new OrderReadOrderBodyResponse();
            orderBody.setId_order(anOrder.getIdOrder());
            orderBody.setOrder_item(orderItemBodyList);
            orderBody.setOrder_status(anOrder.getOrderStatus());
            orderBody.setOrder_created_at(anOrder.getOrderCreatedAt());
            OrderReadDeliveryAddressOrderResponse deliveryAddressResponse = new OrderReadDeliveryAddressOrderResponse();
            DeliveryAddressEntity deliveryAddress = deliveryAddressRepository.findByIdAddress(anOrder.getIdAddress());
            if (deliveryAddress != null) {
                deliveryAddressResponse.setId_address(deliveryAddress.getIdAddress());
                deliveryAddressResponse.setReceiver(deliveryAddress.getReceiver());
                deliveryAddressResponse.setAddress(deliveryAddress.getAddress());
                deliveryAddressResponse.setSub_district(deliveryAddress.getSubDistrict());
                deliveryAddressResponse.setDistrict(deliveryAddress.getDistrict());
                deliveryAddressResponse.setProvince(deliveryAddress.getProvince());
                deliveryAddressResponse.setPostal_code(deliveryAddress.getPostalCode());
                deliveryAddressResponse.setPhone_receiver(deliveryAddress.getPhoneReceiver());
                orderBody.setDelivery_address(deliveryAddressResponse);
            }
            OrderPaymentEntity orderPayment = orderPaymentRepository.findByIdOrder(anOrder.getIdOrder());
            if (orderPayment != null) {
                OrderReadOrderPaymentOrderResponse orderPaymentResponse = new OrderReadOrderPaymentOrderResponse();
                orderPaymentResponse.setId_order_payment(orderPayment.getIdOrderPayment());
                orderPaymentResponse.setPaid_date(orderPayment.getPaidDate());
                orderPaymentResponse.setExpired_pay(orderPayment.getExpiredPay());
                orderPaymentResponse.setId_type_payment(orderPayment.getIdTypePayment());
                orderBody.setOrder_payment(orderPaymentResponse);
            }
            orderBody.setPrice_total(price_total);
            orderBodyList.add(orderBody);

        }
    }
    @Override
    public OrderReadResponse orderReadAllResponse(String token) {
        OrderReadResponse response = new OrderReadResponse();
        OrderReadBodyResponse body = new OrderReadBodyResponse();
        List<OrderReadOrderBodyResponse> orderBodyList = new ArrayList<>();

        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }

        List<OrderEntity> order = orderRepository.findAllByIdBuyer(user.get(0).getIdUser());
        Common.LoggerInfo(order);
        orderReadFunction(orderBodyList, order);
        body.setOrder(orderBodyList);
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public OrderReadResponse orderReadResponse(String token, int id) {

        OrderReadResponse response = new OrderReadResponse();
        OrderReadBodyResponse body = new OrderReadBodyResponse();
        List<OrderReadOrderBodyResponse> orderBodyList = new ArrayList<>();

        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<OrderEntity> order = orderRepository.findAllByIdBuyerAndIdOrder(user.get(0).getIdUser(), id);
        if (order.size() == 0) {
            response.setStatus(200);
            response.setMsg("Order is empty");
            return response;
        }
        Common.LoggerInfo(order);
        orderReadFunction(orderBodyList, order);
        body.setOrder(orderBodyList);
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public OrderCreateResponse orderCreateResponse(String token, OrderCreateRequest restRequest) {
        OrderCreateResponse response = new OrderCreateResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (orderRepository.findAllByIdBuyerAndOrderStatus(user.get(0).getIdUser(), OrderStatus.ORDERING).isEmpty()) {
            OrderEntity order = new OrderEntity();
            order.setIdBuyer(user.get(0).getIdUser());
            order.setOrderStatus(restRequest.getBody().getOrder_status());
            Date date = new Date();
            Timestamp timeNow = new Timestamp(date.getTime());
            order.setOrderCreatedAt(timeNow);

            try {
                orderRepository.save(order);
                order = orderRepository.getLastId();
                for (int i = 0; i < restRequest.getBody().getOrder_item().size(); i++) {
                    OrderItemEntity orderItem = new OrderItemEntity();
                    orderItem.setIdOrder(order.getIdOrder());
                    orderItem.setIdVariation(restRequest.getBody().getOrder_item().get(i).getId_variation());
                    orderItem.setQuantity(restRequest.getBody().getOrder_item().get(i).getQuantity());
                    orderItem.setOrderItemStatus(OrderItemStatus.NOT_SHIP);
                    orderItemRepository.save(orderItem);
                }

                response.setStatus(201);
                response.setMsg("Created order and order item");
            } catch (Exception e) {
                response.setStatus(400);
                response.setMsg("Unknown error. Can't create order.");
                return response;
            }
        }
        else {
            List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndOrderStatus(user.get(0).getIdUser(), OrderStatus.ORDERING);
            for (int i = 0; i < restRequest.getBody().getOrder_item().size(); i++) {
                OrderItemEntity orderItem = new OrderItemEntity();
                orderItem.setIdOrder(orderEntity.get(0).getIdOrder());
                orderItem.setIdVariation(restRequest.getBody().getOrder_item().get(i).getId_variation());
                orderItem.setQuantity(restRequest.getBody().getOrder_item().get(i).getQuantity());
                orderItem.setOrderItemStatus(OrderItemStatus.NOT_SHIP);
                try {
                    orderItemRepository.save(orderItem);
                    response.setStatus(201);
                    response.setMsg("Found order! Added order item");
                } catch (Exception e) {
                    response.setStatus(400);
                    response.setMsg("Found order! But unknown error. Can't create order item.");
                }
            }
        }
        return response;
    }

    @Override
    public OrderUpdateResponse orderUpdateResponse(String token, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }

        if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERING) {
            return orderStatus_ordering(user, restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.ADDRESSING) {
            return orderStatus_addressing(user,restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_SHIP) {
            return orderStatus_choosing_ship(user,restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.SHIP_CHOSEN) {
            return orderStatus_ship_chosen(user,restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.PAY_CHOSEN) {
            return orderStatus_pay_chosen(user,restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERED) {
            return orderStatus_ordered(user,restRequest);
        }

        else {
            response.setStatus(403);
            response.setMsg("Access Denind. Can't update status!");
            return response;
        }
    }
    private OrderUpdateResponse orderStatus_ordering(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found!");
            return response;
        }
        if (restRequest.getBody().getId_buyer() != null)
            orderEntity.get(0).setIdBuyer(restRequest.getBody().getId_buyer());
        if (restRequest.getBody().getOrder_status() != null)
            orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        if (restRequest.getBody().getId_address() != null)
            orderEntity.get(0).setIdAddress(restRequest.getBody().getId_address());
        try {
            orderRepository.save(orderEntity.get(0));
            if (restRequest.getBody().getOrder_item() != null) {
                for (int i = 0; i < restRequest.getBody().getOrder_item().size(); i++) {
                    List<OrderItemEntity> orderItem = (List<OrderItemEntity>) orderItemRepository.findAllById(Collections.singleton(restRequest.getBody().getOrder_item().get(i).getId_item()));
                    if (restRequest.getBody().getOrder_item().get(i).getId_variation() != null)
                        orderItem.get(0).setIdVariation(restRequest.getBody().getOrder_item().get(i).getId_variation());
                    if (restRequest.getBody().getOrder_item().get(i).getQuantity() != null)
                        orderItem.get(0).setQuantity(restRequest.getBody().getOrder_item().get(i).getQuantity());
                    if (restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop() != null)
                        orderItem.get(0).setIdShipOfShop(restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop());
                    orderItemRepository.save(orderItem.get(0));
                }
            }
            response.setStatus(201);
            response.setMsg("Updated");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update order. Exception : " + e.toString());
        }
        return response;
    }
    private OrderUpdateResponse orderStatus_addressing(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found");
            return response;
        }
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        try {
            orderRepository.save(orderEntity.get(0));
            response.setStatus(200);
            response.setMsg("Updated");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
        }
        return response;
    }
    private OrderUpdateResponse orderStatus_choosing_ship(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found!");
            return response;
        }
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        DeliveryAddressEntity deliveryAddress = deliveryAddressRepository.findByIdAddress(restRequest.getBody().getId_address());
        if (deliveryAddress == null || deliveryAddress.getIdUser() != user.getIdUser()) {
            response.setStatus(404);
            response.setMsg("Address Invalid");
            return response;
        }
        orderEntity.get(0).setIdAddress(restRequest.getBody().getId_address());
        try {
            orderRepository.save(orderEntity.get(0));
            response.setStatus(201);
            response.setMsg("Updated address");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
        }
        return response;
    }
    private OrderUpdateResponse orderStatus_ship_chosen(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found!");
            return response;
        }
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(orderEntity.get(0).getIdOrder());
        for (int i = 0; i < orderItem.size(); i++) {
            for (int j = 0; j < restRequest.getBody().getOrder_item().size(); j++) {
                if (orderItem.get(i).getIdItem().equals(restRequest.getBody().getOrder_item().get(j).getId_item())) {
                    ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(orderItem.get(i).getIdVariation());
                    List<ShipOfShopEntity> shipOfShop = shipOfShopRepository.findAllByIdProduct(productVariation.getIdProduct());
                    for (ShipOfShopEntity aShipOfShop : shipOfShop) {
                        if (aShipOfShop.getIdShip() == restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop())
                            orderItem.get(i).setIdShipOfShop(restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop());
                    }
                    if (orderItem.get(i).getIdShipOfShop() == null) {
                        response.setStatus(400);
                        response.setMsg("Error! no id_ship in this shop!");
                        return response;
                    }
                }
            }

        }
        try {
            orderRepository.save(orderEntity.get(0));
            response.setStatus(200);
            response.setMsg("Updated. ship chosen.");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
        }
        return response;
    }
    private OrderUpdateResponse orderStatus_pay_chosen(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found!");
            return response;
        }
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        OrderPaymentEntity orderPayment = new OrderPaymentEntity();
        orderPayment.setIdOrder(restRequest.getBody().getId_order());
        orderPayment.setIdTypePayment(restRequest.getBody().getId_type_payment());

        ConfigEntity config = configRepository.findByName("expired_pay_time");

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.HOUR, Integer.parseInt(config.getValue()));
        dt = c.getTime();
        Timestamp expired_pay = new Timestamp(dt.getTime());

        orderPayment.setExpiredPay(expired_pay);
        try {
            orderPaymentRepository.save(orderPayment);
            response.setStatus(200);
            response.setMsg("Updated. payment chosen.");
            return response;
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
            return response;
        }
    }
    private OrderUpdateResponse orderStatus_ordered(UserEntity user, OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = orderRepository.findAllByIdBuyerAndIdOrder(user.getIdUser(), restRequest.getBody().getId_order());
        if (orderEntity.size() == 0) {
            response.setStatus(404);
            response.setMsg("Order not found!");
            return response;
        }
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());

        List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(restRequest.getBody().getId_order());

        for (OrderItemEntity anOrderItem1 : orderItem) {
            ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(anOrderItem1.getIdVariation());
            if (productVariation.getStock() < anOrderItem1.getQuantity()) {
                orderEntity.get(0).setOrderStatus(OrderStatus.PAY_CHOSEN);
                orderRepository.save(orderEntity.get(0));
                response.setStatus(200);
                response.setMsg("Out Stock!");
                return response;
            }
        }

        for (OrderItemEntity anOrderItem : orderItem) {
            ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(anOrderItem.getIdVariation());
            productVariation.setStock(productVariation.getStock() - anOrderItem.getQuantity());
            productVariationRepository.save(productVariation);
        }

        try {
            orderRepository.save(orderEntity.get(0));
            response.setStatus(201);
            response.setMsg("Updated Ordered");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
        }
        return response;
    }

    @Override
    public OrderDeleteResponse orderDeleteResponse(String token, OrderDeleteRequest restRequest) {
        OrderDeleteResponse response = new OrderDeleteResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        List<OrderEntity> order = orderRepository.findAllByIdBuyer(user.get(0).getIdUser());
        boolean foundOrder = false;
        if (restRequest.getBody().getId_order() != null) {
            for (OrderEntity anOrder : order) {
                List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(anOrder.getIdOrder());
                for (int j = 0; j < restRequest.getBody().getId_order().length; j++) {
                    if (anOrder.getIdOrder() == restRequest.getBody().getId_order()[j]) {
                        foundOrder = true;
                        if (restRequest.getBody().getId_item() != null) { // delete order_item (required one order)
                            for (int k = 0; k < restRequest.getBody().getId_item().length; k++) {
                                try {
                                    orderItemRepository.deleteById(orderItem.get(k).getIdItem());
                                } catch (Exception e) {
                                    response.setStatus(204);
                                    response.setMsg("Order item not found! Can't deleted order item!");
                                    return response;
                                }
                            }
                            response.setStatus(200);
                            response.setMsg("Deleted order item");
                            return response;
                        } else { // delete order
                            try {
                                orderRepository.deleteById(anOrder.getIdOrder());
                                response.setStatus(200);
                                response.setMsg("Delete Successful");
                            } catch (Exception e) {
                                response.setStatus(204);
                                response.setMsg("Found order! but can't delete order");
                                return response;
                            }
                        }
                    }
                }

            }
            if(!foundOrder) {
                response.setStatus(204);
                response.setMsg("Order not found");
            }
        }

        return response;
    }

}
