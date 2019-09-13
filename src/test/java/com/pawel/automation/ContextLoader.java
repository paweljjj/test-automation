package com.pawel.automation;

import io.cucumber.java.Before;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootTest
@AutoConfigureMockMvc
@EnableFeignClients
public class ContextLoader {

    @Before
    public void setupCucumberSpringContext() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

}
