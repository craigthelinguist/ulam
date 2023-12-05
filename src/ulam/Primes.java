package ulam;

public class Primes {

    public static boolean isPrime(int x) {

        // We don't really consider negative numbers as prime, but the properties of primality still hold for them.
        // Treat negative numbers as the corresponding positive numbers.
        x = Math.abs(x);

        // 1 and 0 are not prime numbers.
        if (x < 2) {
            return false;
        }

        // 2 is the only even prime number. Every other even number will have 2 as a factor. If we conclude that 2 is
        // not a factor here, we don't need to check if any of the other even numbers are factors.
        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }

        // It is sufficient to only search up to sqrt(x). If there were a factor k such that sqrt(x) < k < x then
        // p * k = x for some p. Since k > sqrt(x) and p * k = x then p < sqrt(x), hence we would have already
        // determined that n is composite and this check is redundant.
        //
        // Conclusion: it is sufficient to search for factors up to k = sqrt(x).
        int upperBound = (int) Math.sqrt(x);
        for (int y = 3; y <= upperBound; y += 2) {
            if (x % y == 0) {
                return false;
            }
        }
        return true;
    }

}