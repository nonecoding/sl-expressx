package com.sl.ms.work.service;

import com.sl.ms.work.domain.enums.pickupDispatchtask.PickupDispatchTaskAssignedStatus;
import com.sl.ms.work.domain.enums.pickupDispatchtask.PickupDispatchTaskSignStatus;
import com.sl.ms.work.domain.enums.pickupDispatchtask.PickupDispatchTaskType;
import com.sl.ms.work.entity.PickupDispatchTaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PickupDispatchTaskServiceTest {

    @Resource
    private PickupDispatchTaskService pickupDispatchTaskService;

    /**
     * 测试新增取件任务
     */
    @Test
    void saveTaskPickupDispatch() {
        PickupDispatchTaskEntity pickupDispatchTaskEntity = new PickupDispatchTaskEntity();
        pickupDispatchTaskEntity.setCourierId(1019618890088508577L);
        pickupDispatchTaskEntity.setOrderId(1564170062718373889L);
        pickupDispatchTaskEntity.setAgencyId(1015716681416180257L);
        pickupDispatchTaskEntity.setTaskType(PickupDispatchTaskType.PICKUP);
        pickupDispatchTaskEntity.setMark("带包装");
        pickupDispatchTaskEntity.setSignStatus(PickupDispatchTaskSignStatus.NOT_SIGNED);
        pickupDispatchTaskEntity.setAssignedStatus(PickupDispatchTaskAssignedStatus.DISTRIBUTED);
        PickupDispatchTaskEntity pickupDispatchTask = this.pickupDispatchTaskService.saveTaskPickupDispatch(pickupDispatchTaskEntity);
        System.out.println(pickupDispatchTask);
    }

}