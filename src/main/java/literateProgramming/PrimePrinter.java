package literateProgramming;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;
    private static final int linesPerPage = 50;
    private static final int columnsPerPage = 4;

    public static void main(String[] args) {
        final PrimeGenerator primeGenerator = new PrimeGenerator();
        final NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columnsPerPage);

        int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
        numberPrinter.print(primes, numberOfPrimes);
    }
}

