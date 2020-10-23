package com.everis.treining.service.test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import io.reactivex.Single;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

  @InjectMocks
  private ServiceAccount serviceAccount;

  @Mock
  private RestTemplate restTemplate;

  @Test
  public void getAccountTest() throws Exception {

    when(restTemplate.getForObject("http://localhost:8085/core/accounts?cardNumber=1111111X", Account.class))
        .thenReturn(new Account("1111111X", 22.3));

    /* Test */
    Account account = serviceAccount.getAccount("1111111X");

    /* Asserts */
    assertEquals(account.getAccountNumber(), "1111111X");
    assertEquals(account.getAmount(), 22.3);
    
   

  }

}
