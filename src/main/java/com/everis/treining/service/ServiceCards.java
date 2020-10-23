package com.everis.treining.service;

import com.everis.treining.entity.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCards {

  @Autowired
  private RestTemplate clientRest;

  private String urlCards = "http://localhost:8084/core/cards?documentNumber=";

  public CardResponse getCards(String numberDocument) {
    return clientRest.getForObject(urlCards + numberDocument, CardResponse.class);
  }

}
