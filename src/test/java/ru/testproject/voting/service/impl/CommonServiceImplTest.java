package ru.testproject.voting.service.impl;

import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.testproject.voting.BootApplication;
import ru.testproject.voting.service.CommonService;

/*@SpringJUnitConfig(locations ={
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@Sql(scripts = "classpath:data.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public abstract class CommonServiceImplTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    protected CommonService commonService;
}