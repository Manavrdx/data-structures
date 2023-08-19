public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};

        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println("Before:: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    int index = rows - i;
                    while (index >= 0) {
                        if (matrix[index][j] != 0) {
                            matrix[index][j] = -1;
                        }
                        index--;
                    }

                    index = i + 1;
                    while (index < rows) {
                        if (matrix[index][j] != 0) {
                            matrix[index][j] = -1;
                        }
                        index++;
                    }

                    index = j - 1;
                    while (index >= 0) {
                        if (matrix[i][index] != 0) {
                            matrix[i][index] = -1;
                        }
                        index--;
                    }

                    index = j + 1;
                    while (index < columns) {
                        if (matrix[i][index] != 0) {
                            matrix[i][index] = -1;
                        }
                        index++;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }

        System.out.println("After:: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
