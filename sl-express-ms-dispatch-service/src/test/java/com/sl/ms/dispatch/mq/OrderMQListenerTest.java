package com.sl.ms.dispatch.mq;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.json.JSONUtil;
import com.sl.transport.common.vo.OrderMsg;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMQListenerTest {

    @Resource
    private OrderMQListener orderMQListener;

    @Test
    void listenOrderMsg() {
        OrderMsg orderMsg = OrderMsg.builder()
                .agencyId(1024981239465110017L)
                .orderId(1590586236289646594L)
                .estimatedEndTime(LocalDateTimeUtil.parse("2023-01-13 23:00:00", "yyyy-MM-dd HH:mm:ss"))
                .longitude(116.41338)
                .latitude(39.91092)
                .created(System.currentTimeMillis())
                .taskType(1)
                .mark("带包装")
                .build();
        this.orderMQListener.listenOrderMsg(JSONUtil.toJsonStr(orderMsg));
    }
}