package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_shipping", schema = "e-commerce_01")
public class TypeShippingEntity {
    private int idType;
    private String nameShip;

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "name_ship")
    public String getNameShip() {
        return nameShip;
    }

    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeShippingEntity that = (TypeShippingEntity) o;
        return idType == that.idType &&
                Objects.equals(nameShip, that.nameShip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, nameShip);
    }
}
