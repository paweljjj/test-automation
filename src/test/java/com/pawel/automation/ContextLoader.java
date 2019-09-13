package com.pawel.automation;

import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableFeignClients
public class ContextLoader {

    @Before
    public void setupCucumberCpringContext() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

}
