package com.bank.mapper;

import com.bank.dto.AccountDTO;
import com.bank.entity.Account;

//public class AccountMapper {
//	public static Account mapToAccount(AccountDTO accountDto)
//	{
//		Account acc = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
//		return acc;
//	}
//	
//	public static AccountDTO mapToAccount(Account account)
//	{
//		AccountDTO acc = new AccountDTO(account.getId(), account.getAccountHolderName(), account.getBalance());
//		return acc;
//	}
//}

//Changed mapper class according to record class

public class AccountMapper {
public static Account mapToAccount(AccountDTO accountDto)
{
	Account acc = new Account(accountDto.id(), accountDto.accountHolderName(), accountDto.balance());
	return acc;
}

public static AccountDTO mapToAccount(Account account)
{
	AccountDTO acc = new AccountDTO(account.getId(), account.getAccountHolderName(), account.getBalance());
	return acc;
}
}
