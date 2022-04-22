package com.mulcam.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mulcam.bank.dto.Account;
import com.mulcam.bank.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@PostMapping("/makeaccount")
	public ResponseEntity<String> makeaccount(@RequestBody Account acc) {
		ResponseEntity<String> result = null;
		try {
			System.out.println(acc.getId());
			accountService.makeAccount(acc);
			result =  new ResponseEntity<String>("계좌개설 성공", HttpStatus.OK);
		} catch(Exception e) {
			result =  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@GetMapping("/accountinfo/{id}")
	public ResponseEntity<Account> accountInfo(@PathVariable("id") String id) {
		ResponseEntity<Account> result = null;
		try {
			Account acc = accountService.accountInfo(id);
			result = new ResponseEntity<Account>(acc, HttpStatus.OK);
		} catch(Exception e) {
			result = new ResponseEntity<Account>(new Account(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Account>> allAccs() {
		ResponseEntity<List<Account>> result = null;
		try {
			List<Account> accs = accountService.allAccountInfo();
			result = new ResponseEntity<List<Account>>(accs, HttpStatus.OK);
		} catch(Exception e) {
			result = new ResponseEntity<List<Account>>(new ArrayList<Account>(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@RequestMapping(value="/deposit/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Integer> deposit(@PathVariable("id") String id, @RequestBody Integer money) {
		ResponseEntity<Integer> result = null;
		try {
			Integer balance = accountService.deposit(id, money);
			result = new ResponseEntity<Integer>(balance, HttpStatus.OK);
		}catch(Exception e) {
			result = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}		
		return result;
	}
	
	@RequestMapping(value="/withdraw/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Integer> withdraw(@PathVariable("id") String id, @RequestBody Integer money) {
		ResponseEntity<Integer> result = null;
		try {
			Integer balance = accountService.withdraw(id, money);
			result = new ResponseEntity<Integer>(balance, HttpStatus.OK);
		}catch(Exception e) {
			result = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}		
		return result;
	}
	
	@PostMapping("/accoverlap")
	public ResponseEntity<String>  accOverlap(@RequestParam(value="id") String gid) {
		ResponseEntity<String> result = null;
		boolean overlap = true;
		try {
			overlap = accountService.accOverlap(gid);
			result = new ResponseEntity<String>(String.valueOf(overlap), HttpStatus.OK);
		}catch(Exception e) {
			result = new ResponseEntity<String>(String.valueOf(overlap), HttpStatus.BAD_REQUEST);
		}		
		return result;
	}
}