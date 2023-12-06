package com.poja.prime.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
public class PrimeController {
    @GetMapping("/new-prime/{bits}")
    public String generateProbablePrime(@PathVariable int bits) {
        BigInteger probablePrime = generateProbablePrimeNumber(bits);
        return probablePrime.toString();
    }

    private BigInteger generateProbablePrimeNumber(int bits) {
        return BigInteger.probablePrime(bits, new SecureRandom());
    }
}
