package com.everis.treining.business;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.treining.entity.Account;
import com.everis.treining.entity.Card;
import com.everis.treining.entity.CardResponse;
import com.everis.treining.entity.Deposit;
import com.everis.treining.entity.Person;
import com.everis.treining.entity.ValidAccounts;
import com.everis.treining.service.ServiceAccount;
import com.everis.treining.service.ServiceCards;
import com.everis.treining.service.ServiceFingerprint;
import com.everis.treining.service.ServicePerson;
import com.everis.treining.service.ServiceReniec;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Service
public class DepositBusiness {

  @Autowired
  private ServicePerson servicePerson;

  @Autowired
  private ServiceReniec serviceReniec;

  @Autowired
  private ServiceCards serviceCards;

  @Autowired
  private ServiceAccount serviceAccount;

  @Autowired
  private ServiceFingerprint serviceFingerPrint;

  double amount = 0;

  Deposit deposit = new Deposit();

  public Single<Deposit> getAtm(String numDocu) throws JSONException {
    
    JSONObject jsonObj = new JSONObject(numDocu);
    amount = 0;
    Person person = servicePerson.getPerson(jsonObj.getString("numberDocument"));
    if (person.getBlacklist()) {
      return Single.just(new Deposit());
    } else {
      if (person.getFingerprint()) {
        deposit.setFingerprintEntityName(
            serviceFingerPrint.getFinger(jsonObj.getString("numberDocument")).getEntityName());
      } else {
        person.setFingerprint(true);
        servicePerson.updatePerson(person, person.getDocument());
        deposit.setFingerprintEntityName(serviceReniec.getReniec(jsonObj.getString("numberDocument")).getEntityName());
      }
      List<ValidAccounts> validAccounts = new ArrayList<>();
      CardResponse cards = serviceCards.getCards(jsonObj.getString("numberDocument"));
      
      Observable.just(cards).map(x -> x.getListCards()).flatMapIterable(card -> card).filter(test -> test.getActive())
          .map(r -> r).subscribe(r -> {
            Account account = serviceAccount.getAccount(r.getCardNumber());
            validAccounts.add(new ValidAccounts(account.getAccountNumber()));
            amount = amount + account.getAmount();
          });
      deposit.setCustomerAmount(amount);
      deposit.setValidAccounts(validAccounts);

      return Single.just(deposit);

    }

  }

}
