package lc.list2;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230627
 **/
public class L73Ans {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean row = false;
        boolean col = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // Ошибка: Здесь нужно использовать matrix[i][0] = 0;
                    matrix[i][0] = 0; // Ошибка: Здесь нужно использовать matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (col) {
            cleanZeroCol(matrix, n);
        }

        if (row) {
            cleanZeroRow(matrix, m);
        }
    }

    private void cleanZeroCol(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
        }
    }

    private void cleanZeroRow(int[][] matrix, int m) {
        for (int j = 0; j < m; j++) {
            matrix[0][j] = 0;
        }
    }
}
