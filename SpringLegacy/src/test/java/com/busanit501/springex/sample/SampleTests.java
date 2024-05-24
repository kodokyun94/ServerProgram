package com.busanit501.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
@ExtendWith(SpringExtension.class)
public class SampleTests {
    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleDAO sampleDAO;

    @Test
    public void testService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testDAO() {
        log.info(sampleDAO);
        Assertions.assertNotNull(sampleDAO);
    }



}
