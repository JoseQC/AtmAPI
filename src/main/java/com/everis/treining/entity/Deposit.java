package com.everis.treining.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Deposit {

  private String fingerprintEntityName;
  private List<ValidAccounts> validAccounts;
  private Double customerAmount;

}
