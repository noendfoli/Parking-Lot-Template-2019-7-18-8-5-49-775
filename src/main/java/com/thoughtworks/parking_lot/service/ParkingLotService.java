package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    public Boolean addParkingLot(ParkingLot parkingLot){
        ParkingLot pk = parkingLotRepository.save(parkingLot);
        return pk == null?false:true;
    }

    public void deletePrakingLot(String id) {
        parkingLotRepository.deleteById(id);
    }
}
