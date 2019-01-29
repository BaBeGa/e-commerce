package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderHistoryStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read.FavoriteProductReadBodyProductResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read.FavoriteProductReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read.FavoriteProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory.OrderHistoryReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory.OrderHistoryReadOrderHisBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory.OrderHistoryReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read.RatingProductReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read.RatingProductReadRatingProBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read.RatingProductReadResponse;
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
    private final OrderHistoryRepository orderHistoryRepository;
    private final RatingProductRepository ratingProductRepository;
    private final FavoriteProductRepository favoriteProductRepository;
    private final RatingProductPicRepository ratingProductPicRepository;

    // ============= Order ============== //
    public BuyerServiceImpl(OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, ProductVariationRepository productVariationRepository, ProductRepository productRepository, ShipOfShopRepository shipOfShopRepository, OrderPaymentRepository orderPaymentRepository, DeliveryAddressRepository deliveryAddressRepository, TypeShippingRepository typeShippingRepository, ConfigRepository configRepository, ShopHasProductRepository shopHasProductRepository, ShopRepository shopRepository, ProductPicRepository productPicRepository, OrderHistoryRepository orderHistoryRepository, RatingProductRepository ratingProductRepository, FavoriteProductRepository favoriteProductRepository, RatingProductPicRepository ratingProductPicRepository) {
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
        this.orderHistoryRepository = orderHistoryRepository;
        this.ratingProductRepository = ratingProductRepository;
        this.favoriteProductRepository = favoriteProductRepository;
        this.ratingProductPicRepository = ratingProductPicRepository;
    }

    private void orderReadFunction(List<OrderReadOrderBodyResponse> orderBodyList, List<OrderEntity> order) {
        for (OrderEntity anOrder : order) {
            Double price_total = 0.0;
            List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(anOrder.getIdOrder());
            List<OrderReadOrderItemOrderBodyResponse> orderItemBodyList = new ArrayList<>();
            Common.LoggerInfo(orderItem);
            for (OrderItemEntity anOrderItem : orderItem) {
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
                price_total += productVariation.getPrice() * anOrderItem.getQuantity();
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
                        if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("InTransit") && anOrderItem.getOrderItemStatus() == OrderItemStatus.NOT_SHIP) {
                            anOrderItem.setOrderItemStatus(OrderItemStatus.SHIPPED);
                        } else if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("Delivered") && (anOrderItem.getOrderItemStatus() == OrderItemStatus.NOT_SHIP || anOrderItem.getOrderItemStatus() == OrderItemStatus.SHIPPED)) {
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
                orderItemBody.setOrder_item_status(anOrderItem.getOrderItemStatus());
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
        } else {
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
        } else if (restRequest.getBody().getOrder_status() == OrderStatus.ADDRESSING) {
            return orderStatus_addressing(user, restRequest);
        } else if (restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_SHIP) {
            return orderStatus_choosing_ship(user, restRequest);
        } else if (restRequest.getBody().getOrder_status() == OrderStatus.SHIP_CHOSEN) {
            return orderStatus_ship_chosen(user, restRequest);
        } else if (restRequest.getBody().getOrder_status() == OrderStatus.PAY_CHOSEN) {
            return orderStatus_pay_chosen(user, restRequest);
        } else if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERED) {
            return orderStatus_ordered(user, restRequest);
        } else {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
                                    orderItemRepository.deleteById(restRequest.getBody().getId_item()[k]);
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
            if (!foundOrder) {
                response.setStatus(204);
                response.setMsg("Order not found");
            }
        }

        return response;
    }

    // =========== OrderItem ============= //
    @Override
    public OrderItemUpdateResponse orderItemUpdateResponse(String token, OrderItemUpdateRequest restRequest) {
        OrderItemUpdateResponse response = new OrderItemUpdateResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (restRequest.getOrder_item_status() == OrderItemStatus.COMPLETED) {
            return orderItemStatus_confirm(user, restRequest);
        } else {
            response.setStatus(403);
            response.setMsg("Access Denind. Can't update status!");
            return response;
        }
    }

    private OrderItemUpdateResponse orderItemStatus_confirm(UserEntity user, OrderItemUpdateRequest restRequest) {
        OrderItemUpdateResponse response = new OrderItemUpdateResponse();
        OrderItemEntity orderItem = orderItemRepository.findByIdItem(restRequest.getId_item());
        if (orderItem == null) {
            response.setStatus(404);
            response.setMsg("Wrong id_item");
            return response;
        }
        OrderEntity order = orderRepository.findByIdOrder(orderItem.getIdOrder());
        if (order == null) {
            response.setStatus(404);
            response.setMsg("No Order! Please check Id_item matching with Id_order");
            return response;
        }
        if (order.getIdBuyer() != user.getIdUser()) {
            response.setStatus(404);
            response.setMsg("No id_item in your account");
            return response;
        }
        orderItem.setOrderItemStatus(OrderItemStatus.COMPLETED);
        orderItemRepository.save(orderItem);

        Common.LoggerInfo(user);

        OrderHistoryEntity orderHistory = orderHistoryRepository.findByIdItem(orderItem.getIdItem());
        if (orderHistory == null) {
            orderHistory = new OrderHistoryEntity();
            orderHistory.setIdBuyer(user.getIdUser());
            orderHistory.setUsernameBuyer(user.getUsername());
            orderHistory.setIdItem(orderItem.getIdItem());

            ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(orderItem.getIdVariation());
            ProductEntity product = productRepository.findByIdProduct(productVariation.getIdProduct());
            ShopHasProductEntity shopHasProduct = shopHasProductRepository.findByIdProduct(product.getIdProduct());
            ShopEntity shop = shopRepository.findByIdShop(shopHasProduct.getIdShop());

            orderHistory.setIdShop(shop.getIdShop());
            orderHistory.setNameShop(shop.getNameShop());
            orderHistory.setIdProduct(product.getIdProduct());
            orderHistory.setNameProduct(product.getNameProduct());
            orderHistory.setIdVariation(productVariation.getIdVariation());
            orderHistory.setNameVariation(productVariation.getName());
            orderHistory.setQuantity(orderItem.getQuantity());
            orderHistory.setPrice(productVariation.getPrice());
            orderHistory.setStatus(OrderHistoryStatus.COMPLETED);
            Date date = new Date();
            orderHistory.setSuccessfulDate(date);

            orderHistoryRepository.save(orderHistory);
        }

        response.setStatus(200);
        response.setMsg("Update Successful");
        return response;
    }

    // =========== OrderHistory ========== //
    private void setOrderHistoryToJSON(List<OrderHistoryEntity> orderHistory, List<OrderHistoryReadOrderHisBodyResponse> order_history_list) {
        for (OrderHistoryEntity an_order_history_list : orderHistory) {
            OrderHistoryReadOrderHisBodyResponse order_history = new OrderHistoryReadOrderHisBodyResponse();
            order_history.setId_buyer(an_order_history_list.getIdBuyer());
            order_history.setId_item(an_order_history_list.getIdItem());
            order_history.setId_order_history(an_order_history_list.getIdOrderHistory());
            order_history.setId_product(an_order_history_list.getIdProduct());
            order_history.setId_shop(an_order_history_list.getIdShop());
            order_history.setId_variation(an_order_history_list.getIdVariation());
            order_history.setName_product(an_order_history_list.getNameProduct());
            order_history.setName_shop(an_order_history_list.getNameShop());
            order_history.setName_variation(an_order_history_list.getNameVariation());
            order_history.setPrice(an_order_history_list.getPrice());
            order_history.setQuantity(an_order_history_list.getQuantity());
            order_history.setStatus(an_order_history_list.getStatus());
            order_history.setUsername_buyer(an_order_history_list.getUsernameBuyer());
            order_history_list.add(order_history);
        }
    }

    @Override
    public OrderHistoryReadResponse orderHistoryReadAllResponse(String token) {
        OrderHistoryReadResponse response = new OrderHistoryReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<OrderHistoryEntity> orderHistory = orderHistoryRepository.findAllByIdBuyer(user.getIdUser());
        OrderHistoryReadBodyResponse body = new OrderHistoryReadBodyResponse();

        List<OrderHistoryReadOrderHisBodyResponse> order_history_list = new ArrayList<>();
        setOrderHistoryToJSON(orderHistory, order_history_list);
        body.setOrder_history(order_history_list);
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("successful");

        return response;
    }

    @Override
    public OrderHistoryReadResponse orderHistoryReadResponse(String token, int id_order_history) {
        OrderHistoryReadResponse response = new OrderHistoryReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<OrderHistoryEntity> orderHistory = orderHistoryRepository.findByIdBuyerAndIdOrderHistory(user.getIdUser(), id_order_history);
        OrderHistoryReadBodyResponse body = new OrderHistoryReadBodyResponse();

        List<OrderHistoryReadOrderHisBodyResponse> order_history_list = new ArrayList<>();
        setOrderHistoryToJSON(orderHistory, order_history_list);
        body.setOrder_history(order_history_list);
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("successful");

        return response;
    }

    // ======== Rating Product =========== //
    @Override
    public RatingProductReadResponse ratingProductReadByIdRatingProduct(String token, int id) {
        RatingProductReadResponse response = new RatingProductReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }

        RatingProductReadBodyResponse bodyResponse = new RatingProductReadBodyResponse();
        RatingProductReadRatingProBodyResponse ratingProductResponse = new RatingProductReadRatingProBodyResponse();
        RatingProductEntity ratingProduct = ratingProductRepository.findByIdRatingProduct(id);

        OrderHistoryEntity orderHistory = orderHistoryRepository.findByIdOrderHistory(ratingProduct.getIdOrderHistory());

        if (user.getIdUser() != orderHistory.getIdBuyer()) {
            response.setStatus(404);
            response.setMsg("id_rating_product is not your");
            return response;
        }

        ratingProductResponse.setId_rating_product(ratingProduct.getIdRatingProduct());
        ratingProductResponse.setId_order_history(ratingProduct.getIdOrderHistory());
        ratingProductResponse.setId_product(orderHistory.getIdProduct());
        ProductEntity product = productRepository.findByIdProduct(orderHistory.getIdProduct());
        ratingProductResponse.setName_product(product.getNameProduct());
        ratingProductResponse.setRating(ratingProduct.getRating());
        ratingProductResponse.setContent(ratingProduct.getContent());
        ratingProductResponse.setRated_date(ratingProduct.getRatedDate());

        List<RatingProductPicEntity> ratingProductPicList = ratingProductPicRepository.findAllByIdRatingProduct(ratingProduct.getIdRatingProduct());
        List<String> picList = new ArrayList<>();
        for (int i = 0; i < ratingProductPicList.size(); i++) {
            picList.add(ratingProductPicList.get(i).getContentPic());
        }
        String[] picArr = new String[picList.size()];
        picArr = picList.toArray(picArr);
        ratingProductResponse.setPic_comment(picArr);

        bodyResponse.setRating_product(ratingProductResponse);
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public RatingProductCreateResponse ratingProductCreate(String token, RatingProductCreateRequest restRequest) {
        RatingProductCreateResponse response = new RatingProductCreateResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        OrderHistoryEntity orderHistory = orderHistoryRepository.findByIdOrderHistory(restRequest.getId_order_history());
        if (orderHistory == null) {
            response.setStatus(404);
            response.setMsg("Order history not found!");
            return response;
        }
        if (user.getIdUser() != orderHistory.getIdBuyer()) {
            response.setStatus(403);
            response.setMsg("Order history isn't you");
            return response;
        }
        ProductEntity product = productRepository.findByIdProduct(orderHistory.getIdProduct());
        if (product == null) {
            response.setStatus(404);
            response.setMsg("Not found the product or has been deleted");
            return response;
        }
        if (ratingProductRepository.findByIdOrderHistory(restRequest.getId_order_history()) != null) {
            response.setStatus(406);
            response.setMsg("Already rate.");
            return response;
        }
        RatingProductEntity ratingProduct = new RatingProductEntity();

        ratingProduct.setIdOrderHistory(restRequest.getId_order_history());
        ratingProduct.setRating(restRequest.getRating());
        ratingProduct.setContent(restRequest.getContent());
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        ratingProduct.setRatedDate(timeNow);
        ratingProductRepository.save(ratingProduct);
        product.setCount(product.getCount() + 1);
        product.setMean(((product.getMean() * (product.getCount() - 1)) + restRequest.getRating()) / product.getCount());
        productRepository.save(product);

        response.setStatus(200);
        response.setMsg("Successful");

        return response;
    }

    @Override
    public FavoriteProductReadResponse favoriteProductRead(String token) {
        FavoriteProductReadResponse response = new FavoriteProductReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<FavoriteProductEntity> favorite = favoriteProductRepository.findAllByIdUser(user.getIdUser());
        FavoriteProductReadBodyResponse bodyResponse = new FavoriteProductReadBodyResponse();
        List<FavoriteProductReadBodyProductResponse> productFavList = new ArrayList<>();
        for (FavoriteProductEntity aFavorite : favorite) {
            FavoriteProductReadBodyProductResponse productFav = new FavoriteProductReadBodyProductResponse();
            productFav.setId_favorite(aFavorite.getIdFavorite());
            productFav.setId_product(aFavorite.getIdProduct());
            ProductEntity product = productRepository.findByIdProduct(aFavorite.getIdProduct());
            productFav.setName_product(product.getNameProduct());
            List<ProductPicEntity> productPic = productPicRepository.findAllByIdProduct(product.getIdProduct());
            productFav.setPic_product(productPic.get(0).getPicProduct());
            productFavList.add(productFav);
        }
        bodyResponse.setProduct_favorite(productFavList);
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("Successful");

        return response;
    }

    @Override
    public FavoriteProductCreateResponse favoriteProductCreate(String token, FavoriteProductCreateRequest restRequest) {
        FavoriteProductCreateResponse response = new FavoriteProductCreateResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        FavoriteProductEntity favoriteProduct = new FavoriteProductEntity();
        favoriteProduct.setIdUser(user.getIdUser());
        if (restRequest.getId_product() == null) {
            response.setStatus(400);
            response.setMsg("Bad Request. id_product required.");
            return response;
        }
        if (productRepository.findByIdProduct(restRequest.getId_product()) == null) {
            response.setStatus(404);
            response.setMsg("This product is no longer available");
            return response;
        }
        favoriteProduct.setIdProduct(restRequest.getId_product());
        try {
            favoriteProductRepository.save(favoriteProduct);
            response.setStatus(200);
            response.setMsg("Successful");
            return response;
        } catch (Exception e) {
            response.setStatus(406);
            response.setMsg("favorite has exist.");
            return response;
        }
    }

    @Override
    public FavoriteProductDeleteResponse favoriteProductDelete(String token, FavoriteProductDeleteRequest restRequest) {
        FavoriteProductDeleteResponse response = new FavoriteProductDeleteResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (restRequest.getId_favorite() == null) {
            response.setStatus(400);
            response.setMsg("Bad Request. id_favorite required");
            return response;
        }
        FavoriteProductEntity favoriteProduct = favoriteProductRepository.findByIdFavoriteAndIdUser(restRequest.getId_favorite(), user.getIdUser());
        if (favoriteProduct == null) {
            response.setStatus(404);
            response.setMsg("id_favorite not found");
            return response;
        }
        favoriteProductRepository.delete(favoriteProduct);
        response.setStatus(200);
        response.setMsg("Delete Successful");
        return response;
    }


}
