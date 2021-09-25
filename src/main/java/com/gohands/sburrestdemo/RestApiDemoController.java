package com.gohands.sburrestdemo;

import java.util.ArrayList;
import java.util.List;
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
  private List<Coffee> coffees = new ArrayList<>();

  public RestApiDemoController() {
    coffees.addAll(List.of(new Coffee("Cafe Cerezas"), new Coffee("Cafe Ganador"), new Coffee("Cafe Lareno"),
        new Coffee("Cafe Tres Pontas")

    ));
  }

  // @RequestMapping(value = "/coffees", method = RequestMethod.GET)
  @GetMapping
  Iterable<Coffee> getCoffees() {
    return coffees;
  }

  @GetMapping("/{id}")
  Optional<Coffee> getCoffeById(@PathVariable String id) {
    for (Coffee c : coffees) {
      if (c.getId().equals(id)) {
        return Optional.of(c);
      }
    }
    return Optional.empty();
  }

  @PostMapping
  Coffee postCooffee(@RequestBody Coffee coffee) {
    coffees.add(coffee);
    return coffee;
  }

  @PutMapping("/{id}")
  ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
    int coffeeIndex = -1;

    for (Coffee c : coffees) {
      if (c.getId().equals(id)) {
        coffeeIndex = coffees.indexOf(c);
        coffees.set(coffeeIndex, coffee);
      }
    }
    return (coffeeIndex == -1) ? new ResponseEntity<>(postCooffee(coffee), HttpStatus.CREATED)
        : new ResponseEntity<>(coffee, HttpStatus.OK);

  }

  @DeleteMapping("/{id}")
  void deleteCoffee(@PathVariable String id) {
    coffees.removeIf(c -> c.getId().equals(id));
  }
}
