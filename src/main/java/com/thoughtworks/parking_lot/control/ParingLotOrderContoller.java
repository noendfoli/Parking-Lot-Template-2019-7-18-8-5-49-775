package com.thoughtworks.parking_lot.control;

import com.thoughtworks.parking_lot.entiry.Car;
import com.thoughtworks.parking_lot.entiry.ParkingLotOrder;
import com.thoughtworks.parking_lot.service.ParkingLotOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkinglots/parkingLotOrders")
public class ParingLotOrderContoller {
    @Autowired
    private ParkingLotOrderService parkingLotOrderService;
    @PostMapping()
    public ResponseEntity addNewParkingLotOrder(@RequestBody Car car)throws Exception{
        Boolean pakringResult  = parkingLotOrderService.addNewParkingLotOrder(car);
        if(pakringResult){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping()
    public ResponseEntity<Object> endParkingLotOrder(@RequestBody Car car){
        ParkingLotOrder newParkingLotOrder = parkingLotOrderService.endParkingLotOrder(car);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newParkingLotOrder);
    }
}
