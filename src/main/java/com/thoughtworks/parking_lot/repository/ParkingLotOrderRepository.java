package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entiry.ParkingLotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParkingLotOrderRepository extends JpaRepository<ParkingLotOrder,String> {
    @Query(value = "select * from  PARKING_LOT_ORDER where CAR_ID = ?1 and ORDER_STATUS=1",nativeQuery = true)
    ParkingLotOrder findOpenOrderByCarId(String carId);
}
