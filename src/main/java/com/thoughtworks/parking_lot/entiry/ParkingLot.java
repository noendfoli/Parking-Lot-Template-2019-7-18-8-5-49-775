package com.thoughtworks.parking_lot.entiry;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private  String parkingLotId;
    @Column(unique = true)
    private String parkingLotName;
    private int parkingLotcapacity;
    private String parkingLotPosition;

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotName, int parkingLotcapacity, String parkingLotPosition) {
        this.parkingLotName = parkingLotName;
        this.parkingLotcapacity = parkingLotcapacity;
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

    public int getParkingLotcapacity() {
        return parkingLotcapacity;
    }

    public void setParkingLotcapacity(int parkingLotcapacity) {
        this.parkingLotcapacity = parkingLotcapacity;
    }

    public String getParkingLotPosition() {
        return parkingLotPosition;
    }

    public void setParkingLotPosition(String parkingLotPosition) {
        this.parkingLotPosition = parkingLotPosition;
    }
}
