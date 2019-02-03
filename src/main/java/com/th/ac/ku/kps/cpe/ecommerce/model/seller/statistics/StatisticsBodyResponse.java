package com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class StatisticsBodyResponse {
    private List<StatisticsOrderHistoryBodyResponse> order_history;
    private Double total_income;
    private Integer total_sold;

    @JsonGetter
    public List<StatisticsOrderHistoryBodyResponse> getOrder_history() {
        return order_history;
    }

    @JsonSetter
    public void setOrder_history(List<StatisticsOrderHistoryBodyResponse> order_history) {
        this.order_history = order_history;
    }

    @JsonGetter
    public Double getTotal_income() {
        return total_income;
    }

    @JsonSetter
    public void setTotal_income(Double total_income) {
        this.total_income = total_income;
    }

    @JsonGetter
    public Integer getTotal_sold() {
        return total_sold;
    }

    @JsonSetter
    public void setTotal_sold(Integer total_sold) {
        this.total_sold = total_sold;
    }
}
