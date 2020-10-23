package com.everis.treining.controller;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.treining.business.DepositBusiness;
import com.everis.treining.entity.Deposit;
import com.sun.el.stream.Stream;

import io.reactivex.Observable;
import io.reactivex.Single;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "atm/")
public class AtmController {

  @Autowired
  private DepositBusiness depositBusiness;

  /**
   * Comment.
   * 
   * @throws Exception
   * 
   * 
   */

  @PostMapping("deposits/")
  public Single<Deposit> getDeposit(@RequestBody String numDocu) throws Exception {
    return depositBusiness.getAtm(numDocu);
  }

}
