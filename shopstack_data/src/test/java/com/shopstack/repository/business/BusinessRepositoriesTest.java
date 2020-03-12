package com.shopstack.repository.business;

import com.shopstack.DataConfig;
import com.shopstack.model.business.Business;
import com.shopstack.model.business.BusinessCategory;
import com.shopstack.model.business.BusinessServiceType;
import com.shopstack.repository.business.BusinessCategoryRepository;
import com.shopstack.repository.business.BusinessRepository;
import com.shopstack.repository.business.BusinessServiceTypeRepository;
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

//@EnableTransactionManagement
@SpringBootTest(classes = {DataConfig.class})
@Sql(scripts = {"classpath:/db/insert-into-business-and-user-data.sql"})
@Transactional
class BusinessRepositoriesTest {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private BusinessCategoryRepository businessCategoryRepository;

    @Autowired
    private BusinessServiceTypeRepository businessServiceTypeRepository;

    @Autowired
    private BusinessUserRepository businessUserRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getSavedBusinessCategoriesTest(){

        logger.info("Fetching saved business categories from databases");
        List<BusinessCategory> businessCategoryList = null;
        BusinessCategory singleCategory = null;
        try {

            logger.info("quering all saved business category objects");
            businessCategoryList = businessCategoryRepository.findAll();
            logger.info("query successful");


            logger.info("quering single category object by id ");
            singleCategory = businessCategoryRepository.findById(1).get();
            logger.info("query successful");

        }catch (RuntimeException exe){
            logger.info("Exception thrown while fetching categories from the database");
            exe.printStackTrace();
        }

        assertThat(singleCategory).isNotNull();
        assertThat(singleCategory.getBizCategoryName()).isEqualTo("Patnership");
        assertThat(businessCategoryList).isNotNull();
    }

    @Test
    public void getSavedBusinessServicesTest(){


        logger.info("Fetching saved business services from databases");
        List<BusinessServiceType> businessServiceTypeList = null;

        BusinessServiceType serviceType = null;

        try {

            businessServiceTypeList = businessServiceTypeRepository.findAll();

            serviceType =  businessServiceTypeRepository.findById(5).get();

        }catch (RuntimeException exe){
            logger.info("Exception thrown while fetching services from the database");
            exe.printStackTrace();
        }

        assertThat(businessServiceTypeList).isNotNull();

        assertThat(serviceType).isNotNull();
        assertThat(serviceType.getBizServiceName()).isEqualTo("Accomodation and Food Services");
    }

    @Test
    public void fetchSavedBusinessTest(){

        List<Business> existingBiz = null;

        logger.info("Fetching list of saved businesses from databases ");
        try {

            existingBiz = businessRepository.findAll();

        }catch(RuntimeException exe){

            logger.info("Exception thrown while fetching businesses from the database");
            exe.printStackTrace();
        }

        assertThat(existingBiz).isNotNull();
        assertThat(existingBiz).hasSize(7);
    }

    @Test
    public void saveNewBusinessTest(){

        Business tempBusiness = new Business();
        tempBusiness.setBizName("Shopstack");
        tempBusiness.setBizEmail("shop@mail.com");

        tempBusiness.setBizCategory(businessCategoryRepository.findById(4).get());
        logger.info("Saved business category object --> "+ tempBusiness.getBizCategory());

        tempBusiness.setBizServiceType(businessServiceTypeRepository.findById(10).get());
        logger.info("Saved business service object --> "+ tempBusiness.getBizServiceType());

        tempBusiness.setCreator(businessUserRepository.findById(4).get());
        logger.info("Saved business service object --> "+ tempBusiness.getCreator());

        assertDoesNotThrow(() -> businessRepository.save(tempBusiness));


        //assert that business was saved in the database
        Business savedBusiness = businessRepository.getOne(tempBusiness.getBizId());

        assertThat(savedBusiness).isNotNull();
        assertThat(savedBusiness.getBizCategory()).isNotNull();
        assertThat(savedBusiness.getBizServiceType()).isNotNull();

    }

//    @SpringBootApplication
//    static class TestConfigruation{}
}