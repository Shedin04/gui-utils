package com.shedin.guicore.config;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration("classpath:spring/gui-context.xml")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CucumberSpringConfiguration {
}