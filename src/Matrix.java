import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * @author yin_zhj
 * @date 2020/4/15
 */
public class Matrix {
    /**
     * 多源广度优先遍历，首先将所有0的下标入队列，将原数组中1置为-1，代表未遍历，遍历队列，当队列不空时，出队列，
     * 分别判断该元素matrix[x][y]上下左右四个元素matrix[newX][newY]是否未被遍历(值为-1)，如果是，
     * 则将{newX,newY}入队列并将matrix[newX][newY]置为matrix[x][y] + 1
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if(null == matrix || matrix.length == 0) {
            return matrix;
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                if(0 == matrix[i][j]) {
                    int[] tmp = {i, j};
                    queue.offer(tmp);
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] tmpX = {0, 0, -1, 1};
        int[] tmpY = {-1, 1, 0, 0};

        while(!queue.isEmpty()) {
            int[] index = queue.poll();
            int x = index[0];
            int y = index[1];
            for(int i = 0;i < 4;i++) {
                int newX = x + tmpX[i];
                int newY = y + tmpY[i];
                if(0 <= newX && newX < matrix.length && 0 <= newY && newY < matrix[0].length) {
                    if(matrix[newX][newY] == -1) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        int[] tmp = {newX, newY};
                        queue.offer(tmp);
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] m = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] rs = matrix.updateMatrix(m);
        for(int i = 0;i < rs.length;i++) {
            for(int j = 0;j < rs[i].length;j++) {
                System.out.print(rs[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
