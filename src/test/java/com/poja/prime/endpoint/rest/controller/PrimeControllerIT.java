package com.poja.prime.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.poja.prime.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PrimeControllerIT extends FacadeIT {

    @Autowired
    private PrimeController primeController;

    @Test
    void testGenerateProbablePrime() {
        int bits = 1000;

        String probablePrime = primeController.generateProbablePrime(bits);

        assertTrue(isProbablePrime(probablePrime));
    }

    private boolean isProbablePrime(String num) {
        try {
            return new java.math.BigInteger(num).isProbablePrime(10);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
