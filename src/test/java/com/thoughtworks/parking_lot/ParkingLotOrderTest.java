package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entiry.Car;
import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotOrderService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotOrderTest {
    @Autowired
    private ParkingLotOrderService parkingLotOrderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_add_order_when_parking_lot_not_full() throws Exception {
        //given
        Car car =new Car();
        car.setCarId("hk-001");
        JSONObject jsonObject = new JSONObject(car);
        //when//then
        this.mockMvc.perform(post("/parkinglots/parkingLotOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
