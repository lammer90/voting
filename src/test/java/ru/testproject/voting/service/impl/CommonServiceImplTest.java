package ru.testproject.voting.service.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.testproject.voting.service.CommonService;

@SpringJUnitConfig(locations ={
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})

@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class CommonServiceImplTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    protected CommonService commonService;
}