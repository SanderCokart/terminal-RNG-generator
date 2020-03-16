public class Test {
    private static int rows = 3;
    private static int columns = 3;
    private static int[][] data = new int[rows][columns];
    private static int[] averageOfMultipleRows = new int[rows];

    public static void main(String[] args) {
        generateHeader();
        generateData();
        generateMin();
        generateMultipleRowsAverage();
        generateMax();
        generateSD();
    }

    /**
     * generates the top header above the first row which contains column indexes
     * and prints out average at the end
     */
    private static void generateHeader() {
        System.out.print("\t\t");
        for (int c = 0; c < columns; c++) {
            System.out.print(c + 1 + "\t");
        }

        System.out.print("average:");
        System.out.print("\n\n");
    }

    /**
     * generates random number data (1 to 99) for the amount of columns
     * generates the index of the row, adds 2 tabs
     * loops through the rows
     * shows the average
     */
    private static void generateData() {
        for (int r = 0; r < rows; r++) {
            System.out.print(r + 1 + "\t\t");

            int sum = 0;

            for (int c = 0; c < columns; c++) {
                int rand = (int) (Math.random() * 99 + 1);
                data[r][c] = rand;
                sum += rand;
                System.out.print(rand + "\t");
            }

            int average = Math.round((float) sum / columns);
            averageOfMultipleRows[r] = average;

            System.out.print(average);
            System.out.print("\n");
        }
        System.out.println();
    }

    private static void generateMin() {
        //print min with a tab
        System.out.print("min:\t");


        //for each column
        for (int c = 0; c < columns; c++) {

            //initialize the min variable
            int min = data[0][c];

            //for each row
            for (int r = 0; r < rows; r++) {

                //set data as new min if trues
                //check if the current data at position [rows][columns] is smaller than the initialized min
                if (data[r][c] < min) min = data[r][c];
            }

            //print out the min for each column
            System.out.print(min + "\t");
        }
    }

    private static void generateMultipleRowsAverage() {
        int sum = 0;
        for (int r = 0; r < rows; r++) {
            sum += averageOfMultipleRows[r];
        }
        System.out.print(Math.round((float) sum / rows) + "\n");

    }

    private static void generateMax() {
        System.out.print("max:\t");

        for (int c = 0; c < columns; c++) {
            int max = data[0][c];
            for (int r = 0; r < rows; r++) {
                if (data[r][c] > max) max = data[r][c];
            }
            System.out.print(max + "\t");
        }


    }

    private static void generateSD() {

    }


}
