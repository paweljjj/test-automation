package com.pawel.automation.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class SeleniumConfig {

    @Bean(destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    WebDriver webDriver() {
        log.info("Creating webdriver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PAWELSABINA\\IdeaProjects\\test-automation\\src\\test\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    @Bean
    WebDriverWait webDriverWait() {
        return new WebDriverWait(webDriver(), 5);
    }
}
