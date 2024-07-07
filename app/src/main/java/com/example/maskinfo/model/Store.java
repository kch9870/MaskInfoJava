package com.example.maskinfo.model;


public class Store {

    @com.squareup.moshi.Json(name = "addr")
    private String addr;
    @com.squareup.moshi.Json(name = "code")
    private String code;
    @com.squareup.moshi.Json(name = "created_at")
    private String createdAt;
    @com.squareup.moshi.Json(name = "lat")
    private Double lat;
    @com.squareup.moshi.Json(name = "lng")
    private Double lng;
    @com.squareup.moshi.Json(name = "name")
    private String name;
    @com.squareup.moshi.Json(name = "remain_stat")
    private String remainStat;
    @com.squareup.moshi.Json(name = "stock_at")
    private String stockAt;
    @com.squareup.moshi.Json(name = "type")
    private String type;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemainStat() {
        return remainStat;
    }

    public void setRemainStat(String remainStat) {
        this.remainStat = remainStat;
    }

    public String getStockAt() {
        return stockAt;
    }

    public void setStockAt(String stockAt) {
        this.stockAt = stockAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
