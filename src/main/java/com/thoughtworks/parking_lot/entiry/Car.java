package com.thoughtworks.parking_lot.entiry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
public class Car {

    private  String carId;

    public Car() {
    }
}
