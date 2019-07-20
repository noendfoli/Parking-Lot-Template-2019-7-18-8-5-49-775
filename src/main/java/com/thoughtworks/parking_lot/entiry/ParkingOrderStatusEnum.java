package com.thoughtworks.parking_lot.entiry;

import lombok.Data;

public enum ParkingOrderStatusEnum {
    OPEN_ORDER(0,"Indicates that order is open"),
    END_ORDER(1,"Indicates that order is close");
    private int code;
    private String value;

    ParkingOrderStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
