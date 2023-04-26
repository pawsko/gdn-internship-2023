# Backend oriented task written in Java 17 used Spring Boot 2.7.5

## Description

Simple project runnable as a local server based on Tomcat. Provides 3 endpoints which query some data from Narodowy Bank Polski's public APIs.
Next presents data as a JSON according to defined models (different from NBP).
Additionally, application provides Swagger UI as a simple documentation page and simple UI to make some endpoint tests.



## Endpionts list

1. http://localhost:8080/api/average_exchange_rate/{currency}/{effectiveDate}
2. http://localhost:8080/api/min_max_average_exchange_rate/{currency}/{lastQuotations}
3. http://localhost:8080/api/major_diff_bid_ask/{currency}/{lastQuotations}
4. http://localhost:8080/swagger-ui/index.html

- {currency} - 3 letters currency code according to ISO 4217 standard (i.e. usd, eur, gbp)
- {effectiveDate} - date in RRRR-MM-DD format according to ISO 8601 standard (i.e. 2022-02-01 NOTICE: Weekend dates or holidays, do not return data.)
- {lastQuotations} - amount of last queries (NBP's limit is 255)


### Examples
Make a JAR from project (Maven - install)

- To start the server, run this command (Java 17 is needed):
```
java -jar gdn-internship-2023-0.0.1-SNAPSHOT.jar
```
Remind (if executing problem): 
```
sudo chmod u+x gdn-internship-2023-0.0.1-SNAPSHOT.jar
```
- To query operation 1, run this command (which should have the value 3.8 as the returning information):
```
curl http://localhost:8080/api/average_exchange_rate/usd/2020-01-02
```
- To query operation 2, run this command (which should have the values: min = 4.1557, max = 4.4888 as the returning information):
```
curl http://localhost:8080/api/min_max_average_exchange_rate/usd/100
```
- To query operation 3, run this command (which should have the value 0.10040000000000049 as the returning information):
```
curl http://localhost:8080/api/major_diff_bid_ask/usd/150
```