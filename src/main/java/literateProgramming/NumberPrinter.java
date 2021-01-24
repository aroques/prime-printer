package literateProgramming;

class NumberPrinter {
    private final int linesPerPage;
    private final int columnsPerPage;

    public NumberPrinter(int linesPerPage, int columnsPerPage) {
        this.linesPerPage = linesPerPage;
        this.columnsPerPage = columnsPerPage;
    }

    public void print(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1;
        int PAGE_OFFSET = 1;
        while (PAGE_OFFSET <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(numberOfNumbers);
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(pageNumber);
            System.out.println("\n");
            for (int rowOffset = PAGE_OFFSET; rowOffset <= PAGE_OFFSET + linesPerPage - 1; rowOffset++) {
                for (int column = 0; column <= columnsPerPage - 1; column++)
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
