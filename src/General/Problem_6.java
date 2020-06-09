package General;

//Search target in row-wise and column-wise sorted 2D Array
public class Problem_6 {
    public static void main(String[] args) {
        int [] [] matrix = {{1,4,7,11,15},{2,5,8,12,19},
                            {3,6,9,16,22},{10,13,14,17,24},
                            {18,21,23,26,30}};

        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int [][] matrix, int target) {
        return searchMatrix(matrix,target, 0, 4, 0, 4);
    }

    public static boolean searchMatrix(int [][] matrix, int target,
                                int fRow, int tRow, int fCol, int tCol) {


        int i = (fRow + tRow) / 2;
        int j = (fCol + tCol) / 2;

        if(matrix[i][j] == target) return  true;

        else {
            if(i != tRow || j != fCol) {
                if(searchMatrix(matrix, target, fRow, i, j, tCol))
                    return true;
            }

            if(fRow == tRow && fCol + 1 == tCol) {
                if(matrix[fRow][tCol] == target) {
                    return true;
                }
            }

            if (matrix[i][j] < target) {
                if(i + 1 <= tRow) {
                    if(searchMatrix(matrix, target, i + 1, tRow, fCol, tCol)) {
                        return true;
                    }
                }
            }

            else {
                if(j - 1 >= fCol) {
                    if(searchMatrix(matrix, target, fRow, tRow, fCol, j - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
