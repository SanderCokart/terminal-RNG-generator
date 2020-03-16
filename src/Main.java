public class Main {
    private static int rows = 5;
    private static int columns = 5;
    private static int[][] data = new int[rows][columns];
    private static double[] multipleRowAverages = new double[rows];


    public static void main(String[] args) {
        generateHeader();
        generateData();
        generateMin();
        generateMultipleRowAverage();
        generateMax();
        generateStandardDeviation();
    }

    private static double square(double number) {
        return number * number;
    }

    private static double getAverageOfRows() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += multipleRowAverages[i];
        }
        return getAverage(sum, rows);
    }

    private static void generateMultipleRowAverage() {
        double average = getAverageOfRows();

        System.out.printf("%.3f", average);

        System.out.print("\n");
    }

    /**
     * generates the maximum numbers in a column range
     * uses the global data variable to find it
     * max is initialized with 0 and if a data entry is higher
     * then it becomes the new max
     */
    private static void generateMax() {
        int max = 0;

        System.out.print("Max:\t");
        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                if (data[r][c] > max) max = data[r][c];
            }
            System.out.print(max + "\t\t");
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
            double sumOfRow = 0;

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

            //shows average of data per row and stores average in an array
            double average = getAverage(sumOfRow, columns);
            multipleRowAverages[r] = average;
            System.out.print(average);

            //end of data row
            System.out.print("\n");
        }
    }

    /**
     * @param sum
     * @param devidedBy
     * @return average
     */
    private static double getAverage(double sum, double devidedBy) {
        return (float) sum / devidedBy;
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

    private static void generateStandardDeviation() {
        double average = getAverageOfRows();
        double sampleVariation = 0;

        for (int i = 0; i < rows; i++) {
            sampleVariation += square(multipleRowAverages[i] - average) / rows;
        }

        double standardDeviation = Math.sqrt(sampleVariation);

        System.out.printf("%.3f", standardDeviation);
    }


}