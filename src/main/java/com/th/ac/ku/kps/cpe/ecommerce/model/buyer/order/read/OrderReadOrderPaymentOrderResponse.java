package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class OrderReadOrderPaymentOrderResponse {
    private Integer id_order_payment;
    private Timestamp paid_date;
    private Timestamp expired_pay;
    private Integer id_type_payment;

    @JsonGetter
    public Integer getId_order_payment() {
        return id_order_payment;
    }

    @JsonSetter
    public void setId_order_payment(Integer id_order_payment) {
        this.id_order_payment = id_order_payment;
    }

    @JsonGetter
    public Timestamp getPaid_date() {
        return paid_date;
    }

    @JsonSetter
    public void setPaid_date(Timestamp paid_date) {
        this.paid_date = paid_date;
    }

    @JsonGetter
    public Timestamp getExpired_pay() {
        return expired_pay;
    }

    @JsonSetter
    public void setExpired_pay(Timestamp expired_pay) {
        this.expired_pay = expired_pay;
    }

    @JsonGetter
    public Integer getId_type_payment() {
        return id_type_payment;
    }

    @JsonSetter
    public void setId_type_payment(Integer id_type_payment) {
        this.id_type_payment = id_type_payment;
    }
}

