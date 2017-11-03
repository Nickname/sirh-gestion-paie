package dev.paie.config;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.util"})
@Import({DataSourceMySQLConfig.class, JpaConfig.class})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {


}
