package com.bank.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountDTO;
import com.bank.entity.Account;
import com.bank.exception.AccountException;
import com.bank.mapper.AccountMapper;
import com.bank.repository.AccountRepository;
import com.bank.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService
{
	
	private AccountRepository accRepo;
	
	
	@Autowired
	public AccountServiceImpl(AccountRepository accRepo) {
		super();
		this.accRepo = accRepo;
	}



	@Override
	public AccountDTO createAccount(AccountDTO acc) {
		Account account = AccountMapper.mapToAccount(acc);
		Account savedAccount = accRepo.save(account);
		return AccountMapper.mapToAccount(savedAccount);
	}



	@Override
	public AccountDTO deposit(Long id, double amount) {
		Account acc = accRepo.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
		double total = acc.getBalance()+amount;
		acc.setBalance(total);
		Account savedAcc = accRepo.save(acc);
		return AccountMapper.mapToAccount(savedAcc);
	}



	@Override
	public AccountDTO getAccountById(Long id) {
		Account acc = accRepo.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
		return AccountMapper.mapToAccount(acc);
	}



	@Override
	public AccountDTO withdraw(Long id, double amount) {
		Account acc = accRepo.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
		
		if(acc.getBalance() < amount) throw new RuntimeException("Insufficient Amount");
		
		double total = acc.getBalance()-amount;
		acc.setBalance(total);
		Account savedAcc = accRepo.save(acc);
		return AccountMapper.mapToAccount(savedAcc);
	}



	@Override
	public List<AccountDTO> getAllAccounts() {
		List<Account> all = accRepo.findAll();
		List<AccountDTO> collectedAccounts = all.stream().map((acc) -> AccountMapper.mapToAccount(acc)).collect(Collectors.toList());
		return collectedAccounts;
	}



	@Override
	public void deleteById(Long id) {
		Account acc = accRepo.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
		accRepo.deleteById(id);
	}



	@Override
	public void deleteAll() {
		accRepo.deleteAll();
	}

}
