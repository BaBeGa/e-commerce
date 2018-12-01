package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "config", schema = "e-commerce_01")
public class ConfigEntity {
    private int idConfig;
    private String name;
    private String value;
    private String description;

    @Id
    @Column(name = "id_config")
    public int getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigEntity that = (ConfigEntity) o;
        return idConfig == that.idConfig &&
                Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConfig, name, value, description);
    }
}
