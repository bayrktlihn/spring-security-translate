package io.bayrktlihn.springapp;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

