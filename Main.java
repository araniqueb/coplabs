class Main {



    public static void main(String[] args) {

        /*1.) print Array
        2.) row sums
        3.) column sums
        4.)fill right
        5.)fill down
         */

        int[][] fillRightArray = new int [5][8];
        fillRight(fillRightArray,  2);
        printArray(fillRightArray);
        System.out.println();

        int[][] fillDownArray = new int [5][8];
        fillDown(fillDownArray,  -2);
        printArray(fillDownArray);
        System.out.println();

        System.out.println(getRowSum(fillRightArray,  0));
        System.out.println(getColSum(fillDownArray,  0));




    }

    public static void printArray(int[][] array) {


        for (int row = 0; row < array.length; row++) {


            for (int col = 0; col < array[row].length; col++) {


                System.out.format("%-10d", array[row][col]);
            }

            System.out.println();


        }
    }

    public static int getRowSum (int [][] array, int rowIndex) {
        if(rowIndex < 0 || rowIndex >= array.length) {
            return -1;
        }
        else {

            int rowSum = 0;

            for (int col = 0; col < array[rowIndex].length; col++) {
                rowSum += array[rowIndex][col];
            }

            return rowSum;
        }

    }

    public static int getColSum (int[][] array, int colIndex) {
        if(colIndex < 0 || colIndex >= array[0].length) {
            return -1;
        }
        else {

            int colSum = 0;

            for (int row =0;row <array.length;row++) {
                colSum += array [row][colIndex];

            }

            return colSum;
        }


    }

    public static void fillDown (int[][] array, int step) {

        int val = step;

        for (int col = 0; col < array[0].length; col++) {

            for (int row = 0; row < array.length; row++) {

                array [row][col] = val;
                val += step;
            }
        }

    }

    public static void fillRight (int [][] array, int step) {
        int val = step;

        for (int row = 0; row < array.length; row++) {

            for (int col = 0; col < array[row].length; col++) {
                array [row][col] = val;
                val += step;
            }
        }



    }

}









