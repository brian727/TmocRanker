package com.briansdigital.p1TmocRunRanker.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static javax.xml.datatype.DatatypeConstants.FEBRUARY;
import static javax.xml.datatype.DatatypeConstants.JANUARY;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student shitface = new Student(
                    "shitface",
                    "shitface@aol.com",
                    LocalDate.of(1981, JANUARY, 1)
            );

            Student cocksuck = new Student(
                    "cocksuck",
                    "cock@cock.com",
                    LocalDate.of(2001, FEBRUARY, 3)
            );

            repo.saveAll(
                    List.of(shitface,cocksuck)
            );
        };
    }
}
