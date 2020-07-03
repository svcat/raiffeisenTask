import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Just a little bit smarter way to check if a number is prime. Caches the already found Prime numbers in memory, so
 * make sure there is enough memory for it.
 */
public class PrimeChecker {

    // Values taken from com.sun.org.apache.xerces.internal.util.PrimeNumberSequenceGenerator;
    // Trading off a bit of memory for performance
    private final Set<Integer> PRIMES = new HashSet<>(
            Arrays.asList(
                    3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
                    61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
                    139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227,
                    229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
                    317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419,
                    421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509,
                    521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617,
                    619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727));

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (PRIMES.contains(n)) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        PRIMES.add(n);
        return true;
    }

    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();

        System.out.println("Not primes:");
        System.out.println("1 " + checker.isPrime(1));
        System.out.println("24 " + checker.isPrime(24));
        System.out.println("1000000 " + checker.isPrime(24));

        System.out.println("\nPrimes:");
        System.out.println("347 " + checker.isPrime(347));
        System.out.println("7919 " + checker.isPrime(7919));
        System.out.println("241271 " + checker.isPrime(241271));
    }
}