public class Main {
    static int rows = 5;
    static int columns = 5;


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

    private static void generateMin() {
        System.out.print("Min:\t");
        for (int c = 0; c < columns; c++) {
            System.out.print("[min]\t");
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
            }

            System.out.print(getAverage(sumOfRow, columns));

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