package com.gohands.sburrestdemo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Coffee {
  @Id
  private String id;
  private String name;

  public Coffee(String id, String name) {
    this.id = id;
    this.setName(name);
  }

  public Coffee() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Coffee(String name) {
    this(UUID.randomUUID().toString(), name);
  }

}
