package com.everis.treining.service;

import com.everis.treining.entity.FingerPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceFingerprint {

  @Autowired
  private RestTemplate clientRest;

  private String urlFingerPrint = "http://localhost:8082/core/fingerprints/validate";

  public FingerPrint getFinger(String postFingerPrint) {
    return clientRest.postForObject(urlFingerPrint, postFingerPrint, FingerPrint.class);
  }

}
