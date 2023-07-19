package de.ait.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "de.ait")
public class ApplicationConfig {

}
