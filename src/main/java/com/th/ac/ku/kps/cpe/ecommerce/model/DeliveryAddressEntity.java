package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery_address", schema = "e-commerce_01", catalog = "")
public class DeliveryAddressEntity {
    private int idAddress;
    private int idUser;
    private String receiver;
    private String address;
    private String subDistrict;
    private String district;
    private String province;
    private String postalCode;
    private String phoneReceiver;

    @Id
    @Column(name = "id_address")
    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "sub_district")
    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "phone_receiver")
    public String getPhoneReceiver() {
        return phoneReceiver;
    }

    public void setPhoneReceiver(String phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAddressEntity that = (DeliveryAddressEntity) o;
        return idAddress == that.idAddress &&
                idUser == that.idUser &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(address, that.address) &&
                Objects.equals(subDistrict, that.subDistrict) &&
                Objects.equals(district, that.district) &&
                Objects.equals(province, that.province) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(phoneReceiver, that.phoneReceiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, idUser, receiver, address, subDistrict, district, province, postalCode, phoneReceiver);
    }
}
