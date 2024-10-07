package com.ligg;

import com.ligg.service.ProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MmallApplicationTests {

    @Autowired
    private ProductCategoryService service;

    @Test
    void contextLoads() {

    }

}
