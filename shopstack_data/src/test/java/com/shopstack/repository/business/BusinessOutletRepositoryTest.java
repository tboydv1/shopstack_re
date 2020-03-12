package com.shopstack.repository.business;

import com.shopstack.DataConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest(classes = {DataConfig.class})
@Sql(scripts = {"classpath:/db/insert-into-business-and-user-data.sql"})
@Transactional
class BusinessOutletRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}