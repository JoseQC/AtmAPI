package com.everis.treining.service;

import com.everis.treining.entity.Reniec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceReniec {

  @Autowired
  private RestTemplate clientRest;

  private String urlReniec = "http://localhost:8083/external/reniec/validate";

  public Reniec getReniec(String postReniec) {

    return clientRest.postForObject(urlReniec, postReniec, Reniec.class);
  }

}
