package com.thoughtworks.parking_lot.entiry;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private  String parkingLotId;
    @Column(unique = true)
    private String parkingLotName;
    private int parkingLotCapacity;
    private String parkingLotPosition;
    @OneToMany
    @JoinColumn(name = "parkingLotId")
    private List<Car> parkingSpace;
    public ParkingLot() {
    }

    public ParkingLot(String parkingLotId, String parkingLotName, int parkingLotCapacity, String parkingLotPosition) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        this.parkingLotCapacity = parkingLotCapacity;
        this.parkingLotPosition = parkingLotPosition;
    }

    public ParkingLot(String parkingLotName, int parkingLotcapacity, String parkingLotPosition) {
        this.parkingLotName = parkingLotName;
        this.parkingLotCapacity = parkingLotcapacity;
        this.parkingLotPosition = parkingLotPosition;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getParkingLotCapacity() {
        return parkingLotCapacity;
    }

    public void setParkingLotCapacity(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public String getParkingLotPosition() {
        return parkingLotPosition;
    }

    public void setParkingLotPosition(String parkingLotPosition) {
        this.parkingLotPosition = parkingLotPosition;
    }
}
