package literateProgramming;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;
    public static void main(String[] args) {
        final PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int[] primes = primePrinterHelper.generatePrimes();
        primePrinterHelper.printNumbers(primes, numberOfPrimes);
    }
}

class PrimePrinterHelper {
    private final int numberOfPrimes = 1000;
    private final int linesPerPage = 50;
    private final int columnsPerPage = 4;
    private final int ord_max = 30;
    private final int[] primes = new int[numberOfPrimes + 1];
    private int pageNumber;
    private int rowOffset;
    private int column;
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n;
    private final int[] multiples = new int[ord_max + 1];

    public int[] generatePrimes() {
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

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        pageNumber = 1;
        int PAGE_OFFSET = 1;
        while (PAGE_OFFSET <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(numberOfNumbers);
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(pageNumber);
            System.out.println("\n");
            for (rowOffset = PAGE_OFFSET; rowOffset <= PAGE_OFFSET + linesPerPage - 1; rowOffset++) {
                for (column = 0; column <= columnsPerPage - 1; column++)
                    if (rowOffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowOffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            PAGE_OFFSET += linesPerPage * columnsPerPage;
        }
    }
}
