package com.thoughtworks.parking_lot.entiry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class ParkingOrder {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private  String orderId;
    @OneToOne
    @JoinColumn(name = "parking_lot_name")
    private ParkingLot parkingLot;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int orderStatus;

    public ParkingOrder() {
    }
}
