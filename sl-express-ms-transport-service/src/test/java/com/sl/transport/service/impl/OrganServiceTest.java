package com.sl.transport.service;

import com.sl.transport.domain.OrganDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class OrganServiceTest {

    @Resource
    private OrganService organService;

    @Test
    void findByBid() {
        //bid值要改成自己neo4j中的值
        OrganDTO organDTO = this.organService.findByBid(1012479939628238305L);
        System.out.println(organDTO);
    }

    @Test
    void findAll() {
        //查询包含“上海”关键字的机构
        List<OrganDTO> list = this.organService.findAll("上海");
        list.forEach(System.out::println);
    }
}