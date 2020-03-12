package com.shopstack.repository.businessuser;

import com.shopstack.DataConfig;
import com.shopstack.model.businessuser.BusinessUser;
import com.shopstack.repository.businessuser.BusinessUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {DataConfig.class})
@Transactional
@Sql(scripts={"/db/insert-users-roles.sql"})
class BusinessUserRepositoryTest {

    Logger logger= Logger.getLogger(getClass().getName());


    @Autowired
    BusinessUserRepository businessUserRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getSavedUsersTest(){

        List<BusinessUser> existingUsers = businessUserRepository.findAll();
        assertThat(existingUsers).isNotNull();
        assertThat(existingUsers).hasSize(7);

    }

    @Test
    public void savedNewUserTest(){

        BusinessUser newUser = new BusinessUser("Titi", "Micheal", "titi@mail.com",
                "07086985874", "{noop}titi@test");
        newUser.setToken("testtoken123");

        assertDoesNotThrow(()-> businessUserRepository.save(newUser));

        //get id of newly saved user
        logger.info("User id is --> "+newUser.getUserId());

        BusinessUser savedUser = businessUserRepository.getOne(newUser.getUserId());
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getFirstName()).isEqualTo("Titi");

    }

    @Test
    public void addNullUserTest() {

        BusinessUser tempUser = null;
        assertThrows(RuntimeException.class,  ()-> businessUserRepository.save(tempUser));

    }

}