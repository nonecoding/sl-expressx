package com.sl.ms.carriage.handler;

import cn.hutool.core.util.ObjectUtil;
import com.sl.ms.carriage.domain.constant.CarriageConstant;
import com.sl.ms.carriage.domain.dto.WaybillDTO;
import com.sl.ms.carriage.entity.CarriageEntity;
import com.sl.ms.carriage.service.CarriageService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Order(100)
@Component
public class SameCityChainHandler extends AbstractCarriageChainHandler{
    @Resource
    private CarriageService carriageService;
    @Override
    public CarriageEntity doHandler(WaybillDTO waybillDTO) {
        CarriageEntity carriageEntity=null;
        if (ObjectUtil.equals(waybillDTO.getReceiverCityId(),waybillDTO.getSenderCityId())){
            carriageEntity=this.carriageService.findByTemplateType(CarriageConstant.SAME_CITY);
        }
        return doNextHandler(waybillDTO,carriageEntity);
    }
}
