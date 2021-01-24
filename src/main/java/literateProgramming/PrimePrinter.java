package literateProgramming;

public class PrimePrinter {
    public static void main(String[] args) {
        new PrimePrinterHelper().invoke();
    }
}

class PrimePrinterHelper {
    public void invoke() {
        final int M = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORD_MAX = 30;
        int[] P = new int[M + 1];
        int PAGE_NUMBER;
        int ROW_OFFSET;
        int C;
        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N;
        int[] MULT = new int[ORD_MAX + 1];

        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;
        while (K < M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K] = J;
        }
        PAGE_NUMBER = 1;
        int PAGE_OFFSET = 1;
        while (PAGE_OFFSET <= M) {
            System.out.print("The First ");
            System.out.print(M);
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(PAGE_NUMBER);
            System.out.println("\n");
            for (ROW_OFFSET = PAGE_OFFSET; ROW_OFFSET <= PAGE_OFFSET + RR - 1; ROW_OFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROW_OFFSET + C * RR <= M)
                        System.out.printf("%10d", P[ROW_OFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGE_NUMBER++;
            PAGE_OFFSET += RR * CC;
        }
    }
}
