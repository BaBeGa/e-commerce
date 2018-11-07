package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.OrderItemEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadOrderBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadOrderItemOrderBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.UserEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductVariationEntity;
import com.th.ac.ku.kps.cpe.ecommerce.repository.OrderItemRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.OrderRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ProductVariationRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.UserRepository;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BuyerServiceImpl implements BuyerService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductVariationRepository productVariationRepository;

    public BuyerServiceImpl(OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, ProductVariationRepository productVariationRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.productVariationRepository = productVariationRepository;
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
        for (OrderEntity anOrder : order) {
            List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(anOrder.getIdOrder());
            List<OrderReadOrderItemOrderBodyResponse> orderItemBodyList = new ArrayList<>();
        Common.LoggerInfo(orderItem);
                for (OrderItemEntity anOrderItem: orderItem) {
                OrderReadOrderItemOrderBodyResponse orderItemBody = new OrderReadOrderItemOrderBodyResponse();
                orderItemBody.setId_item(anOrderItem.getIdItem());
                orderItemBody.setId_variation(anOrderItem.getIdVariation());
                orderItemBody.setQuantity(anOrderItem.getQuantity());
                orderItemBodyList.add(orderItemBody);
            }
            OrderReadOrderBodyResponse orderBody = new OrderReadOrderBodyResponse();
            orderBody.setId_order(anOrder.getIdOrder());
            orderBody.setOrder_item(orderItemBodyList);
            orderBody.setOrder_status(anOrder.getOrderStatus());
            orderBody.setOrder_created_at(anOrder.getOrderCreatedAt());
            orderBodyList.add(orderBody);
        }
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
        for (OrderEntity anOrder : order) {
            List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(anOrder.getIdOrder());
            List<OrderReadOrderItemOrderBodyResponse> orderItemBodyList = new ArrayList<>();
            Common.LoggerInfo(orderItem);
            for (OrderItemEntity anOrderItem: orderItem) {
                OrderReadOrderItemOrderBodyResponse orderItemBody = new OrderReadOrderItemOrderBodyResponse();
                orderItemBody.setId_item(anOrderItem.getIdItem());
                orderItemBody.setId_variation(anOrderItem.getIdVariation());
                orderItemBody.setQuantity(anOrderItem.getQuantity());
                orderItemBodyList.add(orderItemBody);
            }
            OrderReadOrderBodyResponse orderBody = new OrderReadOrderBodyResponse();
            orderBody.setId_order(anOrder.getIdOrder());
            orderBody.setOrder_item(orderItemBodyList);
            orderBody.setOrder_status(anOrder.getOrderStatus());
            orderBody.setOrder_created_at(anOrder.getOrderCreatedAt());
            orderBodyList.add(orderBody);
        }
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
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }

        if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERING) {
            return orderStatus_ordering(restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_ADD) {
            return orderStatus_choosing_add(restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_SHIP) {
            return orderStatus_choosing_ship(restRequest);
        }
        else if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERED) {

        }


        if ( !(restRequest.getBody().getOrder_status() == OrderStatus.ORDERING ||
                restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_ADD ||
                restRequest.getBody().getOrder_status() == OrderStatus.CHOOSING_SHIP ||
                restRequest.getBody().getOrder_status() == OrderStatus.ORDERED)) {
            response.setStatus(403);
            response.setMsg("Access Denind. Can't update status!");
            return response;
        }

//        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAllById(Collections.singleton(restRequest.getBody().getId_order()));
//        if (restRequest.getBody().getId_buyer() != null)
//            orderEntity.get(0).setIdBuyer(restRequest.getBody().getId_buyer());
//        if (restRequest.getBody().getOrder_status() != null)
//            orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
//        if (restRequest.getBody().getId_address() != null)
//            orderEntity.get(0).setIdAddress(restRequest.getBody().getId_address());

//        if (restRequest.getBody().getOrder_status() == OrderStatus.ORDERED) { // if Change to ORDERED ---> decrease stock
//            List<ProductVariationEntity> product = (List<ProductVariationEntity>) productVariationRepository.findAllById(Collections.singleton(orderItem.get(0).getIdVariation()));
//            if (product.get(0).getStock() >= restRequest.getBody().getOrder_item().get(i).getQuantity()) {
//                product.get(0).setStock(product.get(0).getStock() - restRequest.getBody().getOrder_item().get(i).getQuantity());
//                productVariationRepository.save(product.get(0));
//            }
//        }

//        try {
//            orderRepository.save(orderEntity.get(0));
//            if (restRequest.getBody().getOrder_item() != null) {
//                for (int i = 0; i < restRequest.getBody().getOrder_item().size(); i++) {
//                    List<OrderItemEntity> orderItem = (List<OrderItemEntity>) orderItemRepository.findAllById(Collections.singleton(restRequest.getBody().getOrder_item().get(i).getId_item()));
//
////                    if (orderItem.get(0).getIdOrder() != null)
////                        orderItem.get(0).setIdOrder(orderEntity.get(0).getIdOrder());
//                    if (restRequest.getBody().getOrder_item().get(i).getId_variation() != null)
//                        orderItem.get(0).setIdVariation(restRequest.getBody().getOrder_item().get(i).getId_variation());
//                    if (restRequest.getBody().getOrder_item().get(i).getQuantity() != null)
//                        orderItem.get(0).setQuantity(restRequest.getBody().getOrder_item().get(i).getQuantity());
//                    if (restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop() != null)
//                        orderItem.get(0).setIdShipOfShop(restRequest.getBody().getOrder_item().get(i).getId_ship_of_shop());
//                    orderItemRepository.save(orderItem.get(0));
//                }
//            }
//            response.setStatus(201);
//            response.setMsg("Updated");
//        }
//        catch (Exception e) {
//            response.setStatus(400);
//            response.setMsg("Unknown error. Can't update order." + e.toString());
//        }
        return response;
    }
    private OrderUpdateResponse orderStatus_ordering(OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAllById(Collections.singleton(restRequest.getBody().getId_order()));
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
    private OrderUpdateResponse orderStatus_choosing_add(OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAllById(Collections.singleton(restRequest.getBody().getId_order()));
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
        try {
            orderRepository.save(orderEntity.get(0));
            response.setStatus(201);
            response.setMsg("Updated");
        }
        catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Unknown error. Can't update status order. Exception : " + e.toString());
        }
        return response;
    }
    private OrderUpdateResponse orderStatus_choosing_ship(OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAllById(Collections.singleton(restRequest.getBody().getId_order()));
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());
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
    private OrderUpdateResponse orderStatus_ordered(OrderUpdateRequest restRequest) {
        OrderUpdateResponse response = new OrderUpdateResponse();
        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAllById(Collections.singleton(restRequest.getBody().getId_order()));
        orderEntity.get(0).setOrderStatus(restRequest.getBody().getOrder_status());


        return response;
    }

    @Override
    public OrderDeleteResponse orderDeleteResponse(String token, OrderDeleteRequest restRequest) {
        OrderDeleteResponse response = new OrderDeleteResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        List<OrderEntity> order = orderRepository.findAllByIdBuyer(user.get(0).getIdUser());
        boolean foundOrder = false;
        if (restRequest.getBody().getId_order() != null) {
            for (int i = 0; i < order.size(); i++) {
                List<OrderItemEntity> orderItem = orderItemRepository.findAllByIdOrder(order.get(i).getIdOrder());
                for (int j = 0; j < restRequest.getBody().getId_order().length; j++) {
                    if (order.get(i).getIdOrder() == restRequest.getBody().getId_order()[j]) {
                        foundOrder = true;
                        if (restRequest.getBody().getId_item() != null) { // delete order_item (required one order)
                            for (int k = 0; k < restRequest.getBody().getId_item().length; k++) {
                                try {
                                    orderItemRepository.deleteById(orderItem.get(k).getIdItem());
                                }
                                catch (Exception e) {
                                    response.setStatus(204);
                                    response.setMsg("Order item not found! Can't deleted order item!");
                                    return response;
                                }
                            }
                            response.setStatus(200);
                            response.setMsg("Deleted order item");
                            return response;
                        }
                        else { // delete order
                            try {
                                orderRepository.deleteById(order.get(i).getIdOrder());
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
