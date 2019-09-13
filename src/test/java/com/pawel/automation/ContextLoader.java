package com.pawel.automation;

import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContextLoader {

    @Before
    public void setupCucumberCpringContext() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }
}
