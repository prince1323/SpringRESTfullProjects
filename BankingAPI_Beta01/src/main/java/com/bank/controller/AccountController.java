package com.bank.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountDTO;
import com.bank.repository.AccountRepository;
import com.bank.service.impl.AccountServiceImpl;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountRepository accountRepository;
	private AccountServiceImpl accServ;

	@Autowired
	public AccountController(AccountServiceImpl accServ, AccountRepository accountRepository) {
		super();
		this.accServ = accServ;
		this.accountRepository = accountRepository;
	}
	
	//Add account REST API
	@PostMapping("/add_account")
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO acc){
		return new ResponseEntity<AccountDTO>(accServ.createAccount(acc), HttpStatus.CREATED);
	}
	
	//Get Account REST API
	@GetMapping("/get_account_by_id/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
		AccountDTO accountData = accServ.getAccountById(id);
		return ResponseEntity.ok(accountData);
	}
	
	//Deposit REST API
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDTO> depositeAmount(@PathVariable Long id, @RequestBody Map<String, Double> req){
		return new ResponseEntity<AccountDTO>(accServ.deposit(id, req.get("amount")), HttpStatus.OK);
	}
	
	//Withdraw REST API
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> req){
		return new ResponseEntity<AccountDTO>(accServ.withdraw(id, req.get("amount")), HttpStatus.OK);
	}
	
	//All Account REST API
	@GetMapping("/get_all_accounts")
	public ResponseEntity<List<AccountDTO>> getAllAccounts(){
		List<AccountDTO> allAccounts = accServ.getAllAccounts();
		return ResponseEntity.ok(allAccounts);
	}
	
	//Delete Account REST API
	@DeleteMapping("/delete_by_id/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
		accServ.deleteById(id);
		return ResponseEntity.ok("Account deleted successfully");
	}
	
	//Delete All Account REST API
	@DeleteMapping("/delete_all_account")
	public ResponseEntity<String> deleteAllAccount(){
		accServ.deleteAll();
		return ResponseEntity.ok("All AccountsF deleted successfully");
	}
}
