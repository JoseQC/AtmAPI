package com.everis.treining.service.test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.everis.treining.entity.Account;
import com.everis.treining.entity.Person;
import com.everis.treining.entity.Reniec;
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServicePerson;
import com.everis.treining.service.ServiceReniec;

import io.reactivex.Single;

@ExtendWith(MockitoExtension.class)
public class ReniecServiceTest {

  @InjectMocks
  private ServiceReniec serviceReniec;

  @Mock
  private RestTemplate restTemplate;

  @Test
  public void getPersonTest() throws Exception {

    when(restTemplate.postForObject("http://localhost:8083/external/reniec/validate","1111111" ,Reniec.class))
        .thenReturn(new Reniec("Reniec", true));

    /* Test */
    Reniec reniec = serviceReniec.getReniec("1111111");
    
    System.out.println(reniec.getEntityName());

    /* Asserts */
    assertEquals(reniec.getEntityName(), "Reniec");
    assertEquals(reniec.getSucces(), true);

  }



}
