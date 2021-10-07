package com.gohands.sburrestdemo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
class DataLoader {

  private final CoffeeRepository coffeeRepository;

  public DataLoader(CoffeeRepository coffeeRepository) {

    this.coffeeRepository = coffeeRepository;
  }

  @PostConstruct
  private void loadData() {
    this.coffeeRepository.saveAll(List.of(new Coffee("Cafe Cerezas"), new Coffee("Cafe Ganador"),
        new Coffee("Cafe Lareno"), new Coffee("Cafe Tres Pontas")));
  }

}
