package com.sl.pay.lock;

import com.sl.pay.entity.TradingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class NativePayServiceTest {

    @Resource
    NativePayService nativePayService;

    @Test
    void createDownLineTradingLock() throws Exception {
        Long productOrderNo = 1122334455L;

        //多线程模拟并发
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                TradingEntity tradingEntity = nativePayService.createDownLineTradingLock(productOrderNo);
                System.out.println("交易单：" + tradingEntity + ", 线程id = " + Thread.currentThread().getId());
            }).start();
        }

        //睡眠20秒，等待所有子线程的完成
        Thread.sleep(20000);
    }

    @Test
    void createDownLineTradingRedissonLock() throws Exception {
        Long productOrderNo = 1122334455L;

        //多线程模拟并发
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                TradingEntity tradingEntity = nativePayService.createDownLineTradingRedissonLock(productOrderNo);
                System.out.println("交易单：" + tradingEntity + ", 线程id = " + Thread.currentThread().getId());
            }).start();
        }

        //睡眠20秒，等待所有子线程的完成
        Thread.sleep(20000);
    }

}