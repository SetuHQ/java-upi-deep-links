# Setu Java SDK

SDK to help Java developers integrate with Setu APIs. 

Currently the following APIs are supported : 
  - UPI Deeplinks

The package is under development so stay tuned for changes. 

## Installation

## Usage

### UPI Deeplinks
The following actions are currenly supported : 
 - Generate new payment link
 - Check status of payment
 
 #### Generate new payment link
 Create an instance of SetuRequestHelper and add the required parameters to it as shown. 
 ``` java
 final SetuRequestHelper helper = new SetuRequestHelper(
    schemeId, // unique id 
    secret, // unique key
    productInstance, // unique product instance
    isProduction // determines sandbox or prod environment
 );
 ```
 To generate the link, call the method `generateLink()` on the above created object. The method returns an object of type `GenerateLinkResponse`, 
 to get relevant data from the request use the getters defined in the class as follows. The method contains the following arguments in order: 
  - `Integer` amount -> Bill amount in paisa
  - `Integer` expiresInDays -> Teh deeplink is created on the time of request and we can monitor its validity in the given time frame // optional
  - `String` payeeName -> Details of the customer // optional
  - `String` refId -> Biller's bill ID
  - `String` exactness -> Amount exactness, can be EXACT, EXACT_UP or EXACT_DOWN
  ``` java
 final GenerateLinkResponse res = helper.generateLink(10000, 20, "Test Name", "billerID1234", "EXACT")
 ```
 The following success JSON is converted to the GenerateLinkResponse object.
 ``` JSON
 {
  "status" : "",
  "success" : true,
  "data":{
    "name" : "",
    "platformBillID" : "",
    "paymentLink" : {
      "shortURL" : "",
      "upiID" : "",
      "upiLink" : ""
    }
   }
 }
 ```
 The following getters can be used on the object to get relevant data.
 ``` java
 getStatus() // -> String
 getSuccess() // -> Boolean
 getName() // -> String
 getUpiId() // -> String 
 getPlatformBillId() // -> String 
 getError() // -> DeeplinkError
 ```
 #### Check Status
 
 The deeplink generated can be checked with this method, it gives information about the status of the payment. From the `helper` call the method `checkStatus()`.
 It takes the parameter of `platformBillID` which is returned when link is generated for the first time. 
 The success response is in the given JSON format
 
 ``` JSON
  {
  "status" : "",
  "success" : true,
  "data":{
    "name" : "",
    "createdAt" : "",
    "expiresAt" : "",
    "platformBillID" : "",
    "status" : "",
    "paymentLink" : {
      "shortURL" : "",
      "upiID" : "",
      "upiLink" : ""
    }
   }
 }
 ```
 
 The above JSON is converted to the object of type `CheckStatusResponse` and we can get relevant data from the following getters
 ``` java
 getRequestStatus() // -> String
 getSuccess() // -> Boolean
 getCreatedAt() // -> String
 getExpiresAt() // -> String
 getName() // -> String
 getUpiId() // -> String
 getUpiLink() // -> String
 getPlatformBillID() // -> String
 getError() // -> DeeplinkError
 ```
 
 #### Mock Payment (only in sandbox mode)
 
 Mock payment allows us to test the system in sandbox environment. On the `helper` call the method `mockPayment()`. It takes 2 arguments : 
  - `Integer` amount - Amount in paisa
  - `String` UpiId of the biller (this is received in the status response)
  
 The response returns nothing so we use the status code and provide a String to give feedback to the user. On a successful mock payment we get
 `Mock Success` string in the console else RequestException is thrown with status code from the server.
 
 #### DeeplinkError Object
 
 `DeeplinkError` object has the following members : 
 ``` java
    private final String code;
    private final String detail;
    private final String docURL;
    private final String title;
    private final List<String> errors;
    private final String traceId;
 ```
 This object is not accessible outside the package so to get info related to the error use the getters available withing the response objects. 
 
 ## License

MIT
 
