package com.airbrb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.airbrb.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
