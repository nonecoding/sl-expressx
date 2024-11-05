package com.sl.ms.carriage.handler;

import cn.hutool.core.util.ObjectUtil;
import com.sl.ms.base.api.common.AreaFeign;
import com.sl.ms.carriage.domain.constant.CarriageConstant;
import com.sl.ms.carriage.domain.dto.WaybillDTO;
import com.sl.ms.carriage.entity.CarriageEntity;
import com.sl.ms.carriage.service.CarriageService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Order(200)
@Component
public class SameProvinceChainHandler extends AbstractCarriageChainHandler{
    @Resource
    private CarriageService carriageService;
    @Resource
    private AreaFeign areaFeign;
    @Override
    public CarriageEntity doHandler(WaybillDTO waybillDTO) {
        CarriageEntity carriageEntity=null;
        // 获取收寄件地址省份id
        Long receiverProvinceId = this.areaFeign.get(waybillDTO.getReceiverCityId()).getParentId();
        Long senderProvinceId = this.areaFeign.get(waybillDTO.getSenderCityId()).getParentId();
        if (ObjectUtil.equals(receiverProvinceId,senderProvinceId)){
            carriageEntity=this.carriageService.findByTemplateType(CarriageConstant.SAME_PROVINCE);
        }
        //省内

        return doNextHandler(waybillDTO,carriageEntity);
    }
}
