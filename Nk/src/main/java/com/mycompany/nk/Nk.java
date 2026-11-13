package com.mycompany.nk;

import com.nkkaraoke.repository.ReservaRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.nk", "com.nkkaraoke"})
@EnableJpaRepositories(basePackages = "com.nkkaraoke.repository")
@EntityScan(basePackages = "com.nkkaraoke.model")
public class Nk {
    public static ReservaRepository repo;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Nk.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        repo = context.getBean(ReservaRepository.class);

        java.awt.EventQueue.invokeLater(() -> {
            new com.nkkaraoke.view.TelaLogin().setVisible(true);
        });
    }
}