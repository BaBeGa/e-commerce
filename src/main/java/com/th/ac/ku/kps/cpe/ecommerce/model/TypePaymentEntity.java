package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_payment", schema = "e-commerce_01")
public class TypePaymentEntity {
    private int idTypePayment;
    private String nameType;

    @Id
    @Column(name = "id_type_payment")
    public int getIdTypePayment() {
        return idTypePayment;
    }

    public void setIdTypePayment(int idTypePayment) {
        this.idTypePayment = idTypePayment;
    }

    @Basic
    @Column(name = "name_type")
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePaymentEntity that = (TypePaymentEntity) o;
        return idTypePayment == that.idTypePayment &&
                Objects.equals(nameType, that.nameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypePayment, nameType);
    }
}
