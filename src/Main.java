public class Main {
    static int rows = 5;
    static int columns = 5;
    static int[][] data = new int[rows][columns];


    public static void main(String[] args) {
        generateHeader();
        generateData();
        generateMin();
        generateAvarageOfRowAverages();
        generateMax();
        generateStandardDeviation();
    }

    private static void generateStandardDeviation() {
        System.out.print("[SD]");

    }

    private static void generateAvarageOfRowAverages() {
        System.out.print("[avgOfRow]\n");
    }

    private static void generateMax() {
        System.out.print("Max:\t");
        for (int c = 0; c < columns; c++) {
            System.out.print("[max]\t");
        }
    }

    /**
     * generates the minimum numbers in a column range
     * uses the global data variable to find it
     * min is initialized with the first row entry of the column
     * if the rng data that occurs in the column range is smaller than current min
     * then the data becomes the new min
     */
    private static void generateMin() {
        System.out.print("Min:\t");
        for (int c = 0; c < columns; c++) {
            int min = data[0][c];
            for (int r = 0; r < rows; r++) {
                if (data[r][c] < min) min = data[r][c];
            }
            System.out.print(min + "\t\t");
        }
    }

    private static void generateData() {
        for (int r = 0; r < rows; r++) {
            //sum of row init
            int sumOfRow = 0;

            //row index
            System.out.print(r + "\t\t");

            for (int c = 0; c < columns; c++) {
                //generate random number and show on screen
                int rng = RNG();
                System.out.print(rng + "\t\t");

                //add random number to sum
                sumOfRow += rng;

                //add random number to global data array
                data[r][c] = rng;
            }

            //shows average of data per row
            System.out.print(getAverage(sumOfRow, columns));

            //end of data row
            System.out.print("\n");
        }
    }

    private static double getAverage(int sum, int devidedBy) {
        return (double) sum / devidedBy;
    }

    /**
     * @return random number
     */
    private static int RNG() {
        return (int) (Math.random() * 50 + 1);
    }


    /**
     * generate top header with numbered index and average
     */
    private static void generateHeader() {
        for (int c = 0; c < columns; c++) {
            System.out.print("\t\t" + c);
        }
        System.out.print("\t\tAverage: \n");
    }


}