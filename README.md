## Primechecker

Simple web page based on servlet to check if a number is prime. 
Can be used to check other information by replacing PrimeNumberProcessor with other processor in CheckerServlet:

```java
private ServletProcessor processor = new PrimeNumberProcessor();
```
