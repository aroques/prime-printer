package literateProgramming;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;
    private static final int linesPerPage = 50;
    private static final int columnsPerPage = 4;

    public static void main(String[] args) {
        final PrimeGenerator primeGenerator = new PrimeGenerator();
        int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
        new NumberPrinter(linesPerPage, columnsPerPage).print(primes, numberOfPrimes);
    }
}

class PrimeGenerator {
    private final int ord_max = 30;
    private int[] primes;
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n;
    private final int[] multiples = new int[ord_max + 1];

    public int[] generatePrimes(int numberOfPrimes) {
        primes = new int[numberOfPrimes + 1];
        primes[1] = 2;
        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
        return primes;
    }
}
