package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shop", schema = "e-commerce_01")
public class ShopEntity {
    private int idShop;
    private int idUser;
    private String nameShop;
    private String shopAddress;
    private String bankAccountName;
    private String bankAccountNumber;
    private Integer idBankCompany;
    private Timestamp createdAt;
    private int mean;
    private int count;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_shop")
    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
    @Column(name = "name_shop")
    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    @Basic
    @Column(name = "shop_address")
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Basic
    @Column(name = "bank_account_name")
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    @Basic
    @Column(name = "bank_account_number")
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Basic
    @Column(name = "id_bank_company")
    public Integer getIdBankCompany() {
        return idBankCompany;
    }

    public void setIdBankCompany(Integer idBankCompany) {
        this.idBankCompany = idBankCompany;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "mean")
    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopEntity that = (ShopEntity) o;
        return idShop == that.idShop &&
                idUser == that.idUser &&
                mean == that.mean &&
                count == that.count &&
                Objects.equals(nameShop, that.nameShop) &&
                Objects.equals(shopAddress, that.shopAddress) &&
                Objects.equals(bankAccountName, that.bankAccountName) &&
                Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
                Objects.equals(idBankCompany, that.idBankCompany) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShop, idUser, nameShop, shopAddress, bankAccountName, bankAccountNumber, idBankCompany, createdAt, mean, count);
    }
}
