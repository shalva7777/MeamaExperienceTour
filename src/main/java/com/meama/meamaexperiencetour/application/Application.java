package com.meama.meamaexperiencetour.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        scanBasePackages = {"com.meama.meamaexperiencetour.application"}
)
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {
    public Application() {
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(Application.class, args);
    }
}
