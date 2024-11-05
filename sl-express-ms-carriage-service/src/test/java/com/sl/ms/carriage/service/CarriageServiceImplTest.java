package com.sl.ms.carriage.service;

import com.sl.ms.carriage.domain.constant.CarriageConstant;
import com.sl.ms.carriage.domain.dto.CarriageDTO;
import com.sl.ms.carriage.domain.dto.WaybillDTO;
import com.sl.ms.carriage.entity.CarriageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarriageServiceImplTest {

    @Resource
    private CarriageService carriageService;

    @Test
    void saveOrUpdate() {
        CarriageDTO carriageDTO = new CarriageDTO();
        carriageDTO.setTemplateType(5);
        carriageDTO.setTransportType(6);
        carriageDTO.setAssociatedCityList(Arrays.asList("6"));
        carriageDTO.setFirstWeight(13d);
        carriageDTO.setContinuousWeight(1d);
        carriageDTO.setLightThrowingCoefficient(6000);

        CarriageDTO dto = this.carriageService.saveOrUpdate(carriageDTO);
        System.out.println(dto);
    }

    @Test
    void findAll() {
        List<CarriageDTO> list = this.carriageService.findAll();
        for (CarriageDTO carriageDTO : list) {
            System.out.println(carriageDTO);
        }
    }

    @Test
    void compute() {
        WaybillDTO waybillDTO = new WaybillDTO();
        waybillDTO.setReceiverCityId(7363L);
        waybillDTO.setSenderCityId(2L);
        waybillDTO.setWeight(3.8);
        waybillDTO.setVolume(12500);
        CarriageDTO compute = this.carriageService.compute(waybillDTO);
        System.out.println("运费"+compute);
    }

    @Test
    void findByTemplateType() {
        CarriageEntity carriageEntity = this.carriageService.findByTemplateType(CarriageConstant.SAME_CITY);
        System.out.println(carriageEntity);
    }
}