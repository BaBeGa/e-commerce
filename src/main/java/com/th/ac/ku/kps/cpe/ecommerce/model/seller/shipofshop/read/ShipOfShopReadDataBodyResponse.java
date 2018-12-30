package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShipOfShopReadDataBodyResponse {

    private int id_ship;
    private int id_shop;
    private String name_shop;
    private int id_product;
    private String name_product;
    private int id_type;
    private String slug;
    private double price;
    private Integer time_ship;

    @JsonGetter
    public int getId_ship() {
        return id_ship;
    }

    @JsonSetter
    public void setId_ship(int id_ship) {
        this.id_ship = id_ship;
    }

    @JsonGetter
    public int getId_shop() {
        return id_shop;
    }

    @JsonSetter
    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    @JsonGetter
    public String getName_shop() {
        return name_shop;
    }

    @JsonSetter
    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
    }

    @JsonGetter
    public int getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    @JsonGetter
    public String getName_product() {
        return name_product;
    }

    @JsonSetter
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    @JsonGetter
    public int getId_type() {
        return id_type;
    }

    @JsonSetter
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    @JsonGetter
    public String getSlug() {
        return slug;
    }
    @JsonSetter
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonGetter
    public double getPrice() {
        return price;
    }

    @JsonSetter
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonGetter
    public Integer getTime_ship() {
        return time_ship;
    }

    @JsonSetter
    public void setTime_ship(Integer time_ship) {
        this.time_ship = time_ship;
    }
}
