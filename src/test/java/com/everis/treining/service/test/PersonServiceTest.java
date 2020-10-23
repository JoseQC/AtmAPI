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
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServicePerson;

import io.reactivex.Single;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @InjectMocks
  private ServicePerson servicePerson;

  @Mock
  private RestTemplate restTemplate;

  @Test
  public void getPersonTest() throws Exception {

    when(restTemplate.getForObject("http://localhost:8081/core/persons?documentNumber=1111111X", Person.class))
        .thenReturn(new Person(1L, "1111111X", true, true));

    /* Test */
    Person person = servicePerson.getPerson("1111111X");

    /* Asserts */
    assertEquals(person.getDocument(), "1111111X");
    assertEquals(person.getId(), 1L);
    assertEquals(person.getBlacklist(), true);
    assertEquals(person.getFingerprint(), true);

  }

  @Test
  public void updatePerson() {

  }

}
