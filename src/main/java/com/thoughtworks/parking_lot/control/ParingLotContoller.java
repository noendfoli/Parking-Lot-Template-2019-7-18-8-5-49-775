package com.thoughtworks.parking_lot.control;

import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkinglots")
public class ParingLotContoller {
    @Autowired
    private ParkingLotService parkingLotService;
    @PostMapping()
    public ResponseEntity addNewParkingLot(@RequestBody ParkingLot parkingLot){
        Boolean result = parkingLotService.addParkingLot(parkingLot);
        if (result){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteParkingLot(@PathVariable("id")String id){
       parkingLotService.deletePrakingLot(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
