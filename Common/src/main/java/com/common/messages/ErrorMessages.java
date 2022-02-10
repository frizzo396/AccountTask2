package com.common.messages;

public final class ErrorMessages {
	
	/**
	 * Service&Dao messages
	 */
	public static final String CUST_NOT_EXISTS = "Customer doesn't exists.";	
	public static final String ACCOUNT_NOT_FOUND = "Account not found";
	
	
	/**
	 * Input validation messages
	 */
	public static final String CUST_NOT_VALORIZED = "Customer id must be valorized.";
	public static final String CUST_MIN_VALUE = "Customer id minimun value is 1.";
	public static final String INIT_CREDIT_NOT_VALORIZED = "Initial credit must be valorized.";
	public static final String INIT_CREDIT_NEGATIVE = "Initial credit must be positive.";
	
	
	/**
	 * Generic error messages
	 */
	public static final String SAVE_ERROR = "Error during saving data.";
	public static final String GENERIC_ERROR = "Generic error.";
	public static final String FIND_ERROR = "Cannot retrieve data.";	
	public static final String ACCESS_DATA_ERROR = "Cannot access data.";
}
