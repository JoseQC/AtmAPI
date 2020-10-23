package com.everis.treining.service.test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.everis.treining.entity.Card;
import com.everis.treining.entity.CardResponse;
import com.everis.treining.entity.Person;
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServiceCards;
import com.everis.treining.service.ServicePerson;

import io.reactivex.Single;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

  @InjectMocks
  private ServiceCards serviceCard;

  @Mock
  private RestTemplate restTemplate;

  @Test
  public void getPersonTest() throws Exception {
    
    List<Card> cardsList = new ArrayList<>();
    cardsList.add(new Card("111111122222", true));
    cardsList.add(new Card("111111122223", false));
    

    when(restTemplate.getForObject("http://localhost:8084/core/cards?documentNumber=1111111X", CardResponse.class))
        .thenReturn(new CardResponse(cardsList));

    /* Test */
    CardResponse cardResponse = serviceCard.getCards("1111111X");

    /* Asserts */
    assertEquals(2, cardResponse.getListCards().size());


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
