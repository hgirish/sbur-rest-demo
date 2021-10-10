package com.gohands.sburrestdemo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {

  private final CoffeeRepository coffeeRepository;

  public RestApiDemoController(CoffeeRepository coffeeRepository) {
    this.coffeeRepository = coffeeRepository;

  }

  // @RequestMapping(value = "/coffees", method = RequestMethod.GET)
  @GetMapping
  Iterable<Coffee> getCoffees() {
    return this.coffeeRepository.findAll();
  }

  @GetMapping("/{id}")
  Optional<Coffee> getCoffeById(@PathVariable String id) {
    return coffeeRepository.findById(id);
  }

  @PostMapping
  Coffee postCooffee(@RequestBody Coffee coffee) {
    return coffeeRepository.save(coffee);
  }

  @PutMapping("/{id}")
  ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
    return (coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
        : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);

  }

  @DeleteMapping("/{id}")
  void deleteCoffee(@PathVariable String id) {
    coffeeRepository.deleteById(id);
  }
}
