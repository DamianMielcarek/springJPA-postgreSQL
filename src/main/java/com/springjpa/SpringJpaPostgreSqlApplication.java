package com.springjpa;

import com.springjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaPostgreSqlApplication implements CommandLineRunner {

  @Autowired CustomerRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(SpringJpaPostgreSqlApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    repository.deleteAll();
  }
}
