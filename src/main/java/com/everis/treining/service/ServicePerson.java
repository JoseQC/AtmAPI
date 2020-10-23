package com.everis.treining.service;

import com.everis.treining.entity.Person;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicePerson {

  @Autowired
  private RestTemplate clientRest;

  private String urlPerson = "http://localhost:8081/core/persons?documentNumber=";

  /**
   * Method Comment.
   * 
   * 
   * 
   */
  public Person getPerson(String numberDocument) {

    return clientRest.getForObject(urlPerson + numberDocument, Person.class);

  }

  /**
   * Method Comment.
   * 
   * 
   * 
   */
  public void updatePerson(Person person, String document) {

    Map<String, String> params = new HashMap<String, String>();
    params.put("document", "document");
    clientRest.put("http://localhost:8081/core/update/" + document, person, "");

  }

}
