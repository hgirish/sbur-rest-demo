package com.gohands.sburrestdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
class GreetingController {
  private final Greetings greeting;

  public GreetingController(Greetings greeting) {
    this.greeting = greeting;
  }

  @GetMapping
  String getGreeting() {
    return greeting.getName();
  }

  @GetMapping("/coffee")
  String GetNameAndCoffee() {
    return greeting.getCoffee();
  }
}