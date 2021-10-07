package com.gohands.sburrestdemo;

import org.springframework.data.repository.CrudRepository;

interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
