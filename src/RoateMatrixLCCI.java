/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author yin_zhj
 * @date 2020/4/7
 */
public class RoateMatrixLCCI {
    /**
     * 通过对比旋转前后数组下标可得规律：
     * matrix[i][j] --> martix[j][n - i - 1]
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length == 1) {
            return;
        }
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                tmp[j][n - i - 1] = matrix[i][j];
            }
        }
        System.arraycopy(tmp, 0, matrix, 0, n);
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix.length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        RoateMatrixLCCI roateMatrixLCCI = new RoateMatrixLCCI();
        roateMatrixLCCI.rotate(matrix);
    }
}
