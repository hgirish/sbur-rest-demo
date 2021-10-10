package com.gohands.sburrestdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "greeting")
class Greetings {

  private String name;
  private String coffee;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCoffee() {
    return coffee;
  }

  public void setCoffee(String coffee) {
    this.coffee = coffee;
  }
}
