package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entiry.Car;
import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.entiry.ParkingLotOrder;
import com.thoughtworks.parking_lot.entiry.ParkingOrderStatusEnum;
import com.thoughtworks.parking_lot.repository.ParkingLotOrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.util.LocateDateUtil;
import org.h2.util.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ParkingLotOrderService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotOrderRepository parkingLotOrderRepository;
    public Boolean addNewParkingLotOrder(Car car)throws Exception{
        ParkingLot pk1 = parkingLotRepository.findAll().get(0);
        if(pk1.parkingCarIntoParkingLot(car)){
            ParkingLotOrder parkingOrder = new ParkingLotOrder();
            parkingOrder.setParkingLot(pk1);
            parkingOrder.setCarId(car.getCarId());
            parkingOrder.setStartTime(LocateDateUtil.getLocalDateTime(new Date()));
            parkingOrder.setOrderStatus(ParkingOrderStatusEnum.OPEN_ORDER.getCode());
            ParkingLotOrder po =  parkingLotOrderRepository.save(parkingOrder);
            return po != null;
        }
        return false;
    }

    public ParkingLotOrder endParkingLotOrder(Car car) {
        ParkingLotOrder openOrder = parkingLotOrderRepository.findOpenOrderByCarId(car.getCarId());
        openOrder.setOrderStatus(ParkingOrderStatusEnum.END_ORDER.getCode());
        openOrder.setEndTime(LocateDateUtil.getLocalDateTime(new Date()));
        ParkingLotOrder endOrder = parkingLotOrderRepository.saveAndFlush(openOrder);
        return endOrder;
    }
}
