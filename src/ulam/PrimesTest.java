package ulam;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimesTest {

    @Test
    public void testPrimality() {
        assertFalse(Primes.isPrime(1));
        assertTrue(Primes.isPrime(2));
        assertTrue(Primes.isPrime(3));
        assertFalse(Primes.isPrime(4));
        assertTrue(Primes.isPrime(5));
        assertFalse(Primes.isPrime(6));
        assertTrue(Primes.isPrime(7));
        assertFalse(Primes.isPrime(8));
        assertFalse(Primes.isPrime(9));
        assertFalse(Primes.isPrime(10));
    }

}