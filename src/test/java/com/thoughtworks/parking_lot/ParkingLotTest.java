package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entiry.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.json.JSONArray;
import org.json.JSONObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotTest {
    @Autowired
    ParkingLotService parkingLotService;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    MockMvc mockMvc;
    @Test
    public void should_return_created_when_add_parking_lot() throws Exception{
        //given
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setParkingLotName("owen's parking lot");
        parkingLot.setParkingLotCapacity(10);
        parkingLot.setParkingLotPosition("Honkong");
        JSONObject jsonObject = new JSONObject(parkingLot);
        //when//then
        this.mockMvc.perform(post("/parkinglots").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_is_ok_when_delete_parking_lot_by_id() throws Exception{
        //given
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setParkingLotCapacity(10);
        parkingLot.setParkingLotName("owen's parking lot");
        parkingLot.setParkingLotPosition("Honkong");
        JSONObject jsonObject = new JSONObject(parkingLot);
        ParkingLot parkingLot1=parkingLotRepository.save(parkingLot);
        //when
        //then
        this.mockMvc.perform(delete("/parkinglots/"+parkingLot1.getParkingLotId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
