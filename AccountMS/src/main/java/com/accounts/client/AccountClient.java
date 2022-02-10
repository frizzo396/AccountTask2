package com.accounts.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;

@Component("AccountClient")
public class AccountClient {

	/**
	 * Account client URL constants
	 */
	private static final String BASE_URL = "http://localhost:8080";
	private static final String SEND_STD_TRANSACTION = "/TransactionMS/sendStdTransaction";
	private static final String GET_CUSTOMER_TRANSACTION = "/TransactionMS/getCustomerTransactions";

	/**
	 * Account webClient attribute and constructor
	 */
	private final WebClient webClient;

	public AccountClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
	}

	/**
	 * Account client call to Transactions Service, due to send a standard transaction on account
	 */
	public ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request) {
		TransactionRTO response = webClient.put().uri(SEND_STD_TRANSACTION)
				.bodyValue(request)
				.retrieve()
				.bodyToMono(TransactionRTO.class)
				.block();
		return new  ResponseEntity<TransactionRTO>(response, HttpStatus.OK);
	}

	/**
	 * Account client call to Transactions Service, due to retrieve transactions list
	 */
	public ResponseEntity<List<TransactionRTO>> getCustomerTransactions(Integer customerId) {
		List<TransactionRTO> response = webClient.get().uri(GET_CUSTOMER_TRANSACTION+"/{customerId}", customerId)
										.retrieve().bodyToFlux(TransactionRTO.class).collectList()
										.block();

		return new  ResponseEntity<List<TransactionRTO>>(response, HttpStatus.OK);
	}

}
