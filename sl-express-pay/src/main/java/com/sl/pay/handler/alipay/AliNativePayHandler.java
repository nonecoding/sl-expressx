package com.sl.pay.handler.alipay;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONUtil;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.sl.pay.entity.TradingEntity;
import com.sl.pay.enums.TradingStateEnum;
import com.sl.pay.handler.NativePayHandler;
import com.sl.transport.common.exception.SLException;
import org.springframework.stereotype.Component;

/**
 * 支付宝实现类
 */
@Component("aliNativePayHandler")
public class AliNativePayHandler implements NativePayHandler {

    @Override
    public void createDownLineTrading(TradingEntity tradingEntity) throws SLException {
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(AlipayConfig.getConfig());
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .preCreate(tradingEntity.getMemo(),  //订单描述
                            Convert.toStr(tradingEntity.getTradingOrderNo()), //交易单号
                            Convert.toStr(tradingEntity.getTradingAmount())); //交易金额
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
                tradingEntity.setPlaceOrderMsg(response.getQrCode()); //二维码信息
                tradingEntity.setPlaceOrderCode(response.getCode());
                tradingEntity.setPlaceOrderJson(JSONUtil.toJsonStr(response));
                tradingEntity.setTradingState(TradingStateEnum.FKZ);
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }


}
