package com.sl.ms.carriage.handler;

import com.sl.ms.carriage.domain.dto.WaybillDTO;
import com.sl.ms.carriage.entity.CarriageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarriageChainHandlerTest {

    @Resource
    private CarriageChainHandler carriageChainHandler;

    @Test
    void findCarriage() {

        WaybillDTO waybillDTO = WaybillDTO.builder()
                .senderCityId(2L)
                .receiverCityId(161793L)
                .volume(1)
                .weight(1d)
                .build();

        CarriageEntity carriage = this.carriageChainHandler.findCarriage(waybillDTO);
        System.out.println(carriage);
    }
}