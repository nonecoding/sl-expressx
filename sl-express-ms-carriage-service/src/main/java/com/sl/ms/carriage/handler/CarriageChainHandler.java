package com.sl.ms.carriage.handler;

import cn.hutool.core.collection.CollUtil;
import com.sl.ms.carriage.domain.dto.WaybillDTO;
import com.sl.ms.carriage.entity.CarriageEntity;
import com.sl.transport.common.exception.SLException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 查找运费模板处理链 @Order注解
 */
@Component
public class CarriageChainHandler {
    /**
     * 利用Spring注入特性，按照 @Order 从小到达排序注入到集合中
     */
    @Resource
    private List<AbstractCarriageChainHandler> chainHandlers;

    private AbstractCarriageChainHandler firstHandler;

    /**
     * 组装处理链
     */
    @PostConstruct
    private void constructChain(){
        if(CollUtil.isEmpty(chainHandlers)){
            throw new SLException("not found carriage chain handler!");
        }
        //处理链中第一个节点
        firstHandler=chainHandlers.get(0);
        for (int i = 0; i < chainHandlers.size(); i++) {
            //最后一个处理链节点
            if (i==chainHandlers.size()-1){
                //设置下游节点
                chainHandlers.get(i).setNextHandler(null);
            }else {
                chainHandlers.get(i).setNextHandler(chainHandlers.get(i+1));
            }
        }




    }

    public CarriageEntity findCarriage(WaybillDTO waybillDTO){
        //从第一个节点开始处理
        return firstHandler.doHandler(waybillDTO);
    }
}
