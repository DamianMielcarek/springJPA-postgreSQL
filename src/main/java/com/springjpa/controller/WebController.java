package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WebController {

  @Autowired CustomerRepository repository;

  @RequestMapping("/save")
  public String process() {
    repository.save(new Customer("John", "Smith"));
    repository.save(
        Arrays.asList(
            new Customer("Adam", "Johnson"),
            new Customer("Kim", "Smith"),
            new Customer("David", "Williams"),
            new Customer("Peter", "Davis")));
    return "Done";
  }

  @RequestMapping("/findall")
  public String findAll() {
    String result = "";

    for (Customer c : repository.findAll()) {
      result += c.toString() + "<br>";
    }

    return result;
  }

  @RequestMapping("/findbyid")
  public String findById(@RequestParam("id") Long id) {
    return repository.findOne(id).toString();
  }

  @RequestMapping("/findbylastname")
  public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
    String result = "";

    for (Customer c : repository.findByLastName(lastName)) {
      result += c.toString() + "<br>";
    }

    return result;
  }
}
