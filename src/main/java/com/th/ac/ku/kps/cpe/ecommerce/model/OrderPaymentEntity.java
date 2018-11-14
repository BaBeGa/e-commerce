package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_payment", schema = "e-commerce_01")
public class OrderPaymentEntity {
    private int idOrderPayment;
    private int idOrder;
    private Timestamp paidDate;
    private Timestamp expiredPay;
    private Integer idTypePayment;

    @Id
    @Column(name = "id_order_payment")
    public int getIdOrderPayment() {
        return idOrderPayment;
    }

    public void setIdOrderPayment(int idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    @Basic
    @Column(name = "id_order")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "paid_date")
    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
    }

    @Basic
    @Column(name = "expired_pay")
    public Timestamp getExpiredPay() {
        return expiredPay;
    }

    public void setExpiredPay(Timestamp expiredPay) {
        this.expiredPay = expiredPay;
    }

    @Basic
    @Column(name = "id_type_payment")
    public Integer getIdTypePayment() {
        return idTypePayment;
    }

    public void setIdTypePayment(Integer idTypePayment) {
        this.idTypePayment = idTypePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPaymentEntity that = (OrderPaymentEntity) o;
        return idOrderPayment == that.idOrderPayment &&
                idOrder == that.idOrder &&
                Objects.equals(paidDate, that.paidDate) &&
                Objects.equals(expiredPay, that.expiredPay) &&
                Objects.equals(idTypePayment, that.idTypePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderPayment, idOrder, paidDate, expiredPay, idTypePayment);
    }
}
