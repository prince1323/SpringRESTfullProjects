package com.bank.service;

import java.util.List;

import com.bank.dto.AccountDTO;

public interface IAccountService {
	public AccountDTO createAccount(AccountDTO acc);
	public AccountDTO deposit(Long id, double amount);
	public AccountDTO getAccountById(Long id);
	public AccountDTO withdraw(Long id, double amount);
	public List<AccountDTO> getAllAccounts();
	public void deleteById(Long id);
	public void deleteAll();
}
