package com.everis.treining.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Person {

  private Long id;
  private String document;
  private Boolean fingerprint;
  private Boolean blacklist;

}
