package com.everis.treining.service;

import com.everis.treining.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceAccount {

  @Autowired
  private RestTemplate clientRest;

  private String urlAccount = "http://localhost:8085/core/accounts?cardNumber=";

  public Account getAccount(String cardNumber) {
    return clientRest.getForObject(urlAccount + cardNumber, Account.class);
  }

}
