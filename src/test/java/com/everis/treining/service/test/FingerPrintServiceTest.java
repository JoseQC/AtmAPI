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
import com.everis.treining.entity.FingerPrint;
import com.everis.treining.entity.Person;
import com.everis.treining.entity.Reniec;
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServiceFingerprint;
import com.everis.treining.service.ServicePerson;
import com.everis.treining.service.ServiceReniec;

import io.reactivex.Single;

@ExtendWith(MockitoExtension.class)
public class FingerPrintServiceTest {

  @InjectMocks
  private ServiceFingerprint serviceFingerPrint;

  @Mock
  private RestTemplate restTemplate;

  @Test
  public void getPersonTest() throws Exception {

    when(restTemplate.postForObject("http://localhost:8082/core/fingerprints/validate","1111111" ,FingerPrint.class))
        .thenReturn(new FingerPrint("Core", true));

    /* Test */
    FingerPrint fingerPrint = serviceFingerPrint.getFinger("1111111");

    /* Asserts */
    assertEquals(fingerPrint.getEntityName(), "Core");
    assertEquals(fingerPrint.getSucces(), true);

  }

//  @Test
//  public void whenAddCalledVerified() {
//    ServicePerson person = mock(ServicePerson.class);
//    doNothing().when(person).updatePerson(is(Person.class), document);   add(isA(Integer.class), isA(String.class));
//    myList.add(0, "");
//
//    verify(myList, times(1)).add(0, "");
//  }

}
