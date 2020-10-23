package com.everis.treining.business;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.everis.treining.business.DepositBusiness;
import com.everis.treining.entity.Account;
import com.everis.treining.entity.Card;
import com.everis.treining.entity.CardResponse;
import com.everis.treining.entity.Deposit;
import com.everis.treining.entity.FingerPrint;
import com.everis.treining.entity.Person;
import com.everis.treining.entity.Reniec;
import com.everis.treining.entity.ValidAccounts;
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServiceCards;
import com.everis.treining.service.ServiceFingerprint;
import com.everis.treining.service.ServicePerson;
import com.everis.treining.service.ServiceReniec;

import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
public class DepositBusinessTest {

  @InjectMocks
  private DepositBusiness serviceAtm;

  @Mock
  private ServicePerson servicePerson;
  
  @Mock
  private ServiceFingerprint serviceFinger;

  @Mock
  private ServiceReniec serviceReniec;

  @Mock
  private ServiceCards serviceCard;
  
  
  @Mock
  private ServiceAccount serviceAccount;

  @Test
  public void testGetAtm() throws Exception {

//    when(servicePerson.getPerson("111111111")).thenReturn(new Person(1L, "111111111", true, true));
//    when(serviceFinger.getFinger("111111111")).thenReturn(new FingerPrint("Core", true));
//    when(serviceReniec.getReniec("111111111")).thenReturn(new Reniec("Reniec", true));
//
//    List<Card> cards = new ArrayList();
//    cards.add(new Card("11112222333", true));
//    cards.add(new Card("11112222344", false));
//    cards.add(new Card("11112222355", true));
//
//    when(serviceCard.getCards("111111111")).thenReturn(new CardResponse(cards));
//    when (serviceAccount.getAccount("11112222333")).thenReturn(new Account("11112222333XXX",1000.0 ));
//    
//    
//    
//    Person person = servicePerson.getPerson("111111111");
//
//    System.out.println(person.getFingerprint());

//    List<ValidAccounts> listValist = new ArrayList();
//    listValist.add(new ValidAccounts("111111111"));
//    listValist.add(new ValidAccounts("111111112"));
//    listValist.add(new ValidAccounts("111111113"));
//
//    Deposit deposit = new Deposit("Reniec", listValist, 13.23);
//
//    when(servicePerson.getPerson("11111111")).thenReturn(new Person(1L, "1111111X", true, true));
//
//    TestObserver<Deposit> testObserver = serviceAtm.getAtm("11111111").test();
//
//    testObserver.assertSubscribed().assertComplete()
////    .assertNever(cards -> cards.stream().anyMatch(card -> !card.getActive()))  // F
////    .assertValue(cards -> cards.size() == 3)
//        .assertValueCount(1).assertNoErrors();
  }

}
