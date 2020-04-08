import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @author yin_zhj
 * @date 2020/4/8
 */
class Index {
    private int i;

    public int getJ() {
        return j;
    }

    private int j;

    public int getI() {
        return i;
    }

    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(obj instanceof Index) {
            if(((Index) obj).getI() == this.i && ((Index) obj).getJ() == this.j) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(j);
        char[] charArr = sb.toString().toCharArray();
        int hash = 0;

        for(char c : charArr) {
            hash = hash * 131 + c;
        }
        return hash;
    }
}
public class LCOF {
    /**
     * 计算数位之和
     * @param a
     * @return
     */
    public int add(int a) {
        int rs = 0;
        while(a != 0) {
            rs += a % 10;
            a = a / 10;
        }
        return rs;
    }

    /**
     * 广度优先遍历思想，利用一个队列存储下标节点，分别判断在当前位置向下走和向右走是否可行
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        LinkedList<Index> list = new LinkedList<>();
        if(k == 0) {
            return 1;
        }
        Index index = new Index(0, 0);
        list.offer(index);
        int rs = 1;
        while(!list.isEmpty()) {
            //出队列
            Index index1 = list.poll();
            int i = index1.getI();
            int j = index1.getJ();
            //判断向右是否可以走
            if(add(i) + add(j + 1) <= k && j + 1 < n) {
                Index index2 = new Index(i, j + 1);
                if(!list.contains(index2)) {
                    list.offer(index2);
                    rs++;
                }
            }
            //判断向下是否可以走
            if(add(i + 1) + add(j) <= k && i + 1 < m) {
                Index index2 = new Index(i + 1, j);
                if(!list.contains(index2)) {
                    list.offer(index2);
                    rs++;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        LCOF lcof = new LCOF();
        System.out.println(lcof.movingCount(3, 2, 17));
    }
}
