#Introduction
Customers are load to an h2 in-memory database with data.sql fine (AccountMS): there are 4 customers with ids (1,2,3,4).
Exception are managed with @RestControllerAdvice.
Common module contains common classes (RTOs, Entities).


# Account microservice
This microservice contains two endpoints:
1) /openAccount which creates a new Account and, if initialCredit is > 0, it sends a standard transaction (-1). The transaction is sent with a webclient call to the 
Transaction microservice at the endpoint /sendStdTransaction.

2) /getCustomerInfo which retrieves Customer's information (name, surname), the customer's account list and the transactions list connected with each account.
The transactions list is retrieved with a with a webclient call to the Transaction microservice at the endpoint /getCustomerTransactions.
Then transaction list is iterated because is more efficient than use a client call for every account.


# Transaction microservice
This microservice contains two endpoints:
1) /sendStdTransaction, used to create a standard transaction when a new account is open and account's initial credit is > 0.
2) /getCustomerTransactions, used to retrieve transactions list for the current customer


# Testing
Import projects on eclipse, build with "maven clean" and "maven install", then put .war files in serve instance (Tomcat) and run

1) Send with Postman a PUT request to endpoint /openAccount, with a json body 
Example:
Url: http://localhost:8080/AccountMS/openAccount
{
  customerId: 1
  initialCredit: 10.0
}

2) Send with Postman a GET request to endpoint /getCustomerInfo, with a json body 
Example:
Url: http://localhost:8080/AccountMS/getCustomerInfo/1



