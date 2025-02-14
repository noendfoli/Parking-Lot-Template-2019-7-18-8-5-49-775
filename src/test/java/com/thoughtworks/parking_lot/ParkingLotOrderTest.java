package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entiry.Car;
import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotOrderService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotOrderTest {
    @Autowired
    private ParkingLotOrderService parkingLotOrderService;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_add_order_when_parking_lot_not_full() throws Exception {
        //given
        parkingLotRepository.saveAndFlush(new ParkingLot("owens parking lot",10,"Honkong"));
        Car car =new Car();
        car.setCarId("hk-001");
        JSONObject jsonObject = new JSONObject(car);
        //when//then
        this.mockMvc.perform(post("/parkinglots/parkingLotOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_order_when_end_the__parking_order() throws Exception {
        //given
        parkingLotRepository.saveAndFlush(new ParkingLot("owens parking lot",10,"Honkong"));
        Car car =new Car();
        car.setCarId("hk-001");
        JSONObject jsonObject = new JSONObject(car);
        //when
        this.mockMvc.perform(post("/parkinglots/parkingLotOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
       String result =  this.mockMvc.perform(patch("/parkinglots/parkingLotOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

       //then
        JSONObject jsonObject1 =new JSONObject(result);
        Assertions.assertEquals(0,jsonObject1.getInt("orderStatus"));

    }

    @Test
    public void should_return_erro_message_when_parking_the__full_parking_lot() throws Exception {
        //given
        parkingLotRepository.saveAndFlush(new ParkingLot("owens parking lot",0,"Honkong"));
        Car car =new Car();
        car.setCarId("nw-1001");
        //when
        JSONObject jsonObject = new JSONObject(car);
        //then
        try {
            String result =  this.mockMvc.perform(post("/parkinglots/parkingLotOrders").content(jsonObject.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e){
            Assertions.assertEquals("Request processing failed; nested exception is BusinessException(code=1001, message=停车场已经满, method=/parkinglots/parkingLotOrders)",e.getMessage());
        }
    }
}
