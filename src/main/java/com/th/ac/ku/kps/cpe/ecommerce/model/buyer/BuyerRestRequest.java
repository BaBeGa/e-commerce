package com.th.ac.ku.kps.cpe.ecommerce.model.buyer;

import java.util.Date;

public class BuyerRestRequest {
    private String id;
    private String name;
    private String sername;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private Date bod;
    private String pic_profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public String getPic_profile() {
        return pic_profile;
    }

    public void setPic_profile(String pic_profile) {
        this.pic_profile = pic_profile;
    }
}
