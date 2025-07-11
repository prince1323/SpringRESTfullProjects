package com.bank.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class AccountDTO {
//	private Long id;
//	private String accountHolderName;
//	private double balance;
//}

//Here Now I Am Using Record
public record AccountDTO(Long id, String accountHolderName, double balance) {
	
}

