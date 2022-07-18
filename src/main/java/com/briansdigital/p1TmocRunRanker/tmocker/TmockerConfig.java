package com.briansdigital.p1TmocRunRanker.tmocker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class TmockerConfig {

    @Bean
    CommandLineRunner commandLineRunner(TmockerRepo repo) {
        return args -> {
            Tmocker Brian = new Tmocker(
                    "Brian",
                    "brian@aol.com"

            );

            Tmocker Andrew = new Tmocker(
                    "Andrew",
                    "andrew@cox.com"
            );

            repo.saveAll(
                    List.of(Brian,Andrew)
            );
        };
    }
}
