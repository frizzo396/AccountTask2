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
	
	private static final String BASE_URL = "http://localhost:8080";
	private static final String SEND_STD_TRANSACTION = "/TransactionMS/sendStdTransaction";
	private static final String GET_ALL_TRANSACTION = "/TransactionMS/getAllTransactions";
	
	private final WebClient webClient;
	
	public AccountClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
	}
	
	public ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request) {
		TransactionRTO response = webClient.put().uri(SEND_STD_TRANSACTION)
				   							.bodyValue(request)
				   							.retrieve()
				   							.bodyToMono(TransactionRTO.class)
				   							.block();
		return new  ResponseEntity<TransactionRTO>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<List<TransactionRTO>> getAllTransactions() {
		List<TransactionRTO> response = webClient.get().uri(GET_ALL_TRANSACTION)
				   							.retrieve()
				   							.bodyToFlux(TransactionRTO.class)
				   		                    .collectList()
				   		                    .block();

		return new  ResponseEntity<List<TransactionRTO>>(response, HttpStatus.OK);
	}

}
