import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author yin_zhj
 * @date 2020/4/16
 */
public class MergeIntervals {
    /**
     * 将待合并区间存入一个list中，从list第一个元素开始，分别判断它和后面的元素next是否可以合并，如果可以合并，
     * 用一个标志flag=true记录当前元素可以和后面的元素合并，并将当前元素置为合并后的元素，将next移除，继续内层遍历，内层
     * 遍历完后判断flag，如果为false，则说明当前元素和后面元素已经不能合并，则将当前元素指为下一个元素继续判断；如果为ture,
     * 则说明当前元素已经发生合并，它和后面的元素有可能可以继续合并，所以继续循环。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(null == intervals || intervals.length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++) {
            list.add(intervals[i]);
        }
        for(int i = 0;i < list.size();) {
            int[] tmp = list.get(i);
            boolean flag = false;
            for(int j = i + 1;j < list.size();) {
                int[] next = list.get(j);
                if (tmp[1] >= next[0] && tmp[0] <= next[0] && next[1] > tmp[1]) {
                    tmp[1] = next[1];
                    list.set(i, tmp);
                    list.remove(j);
                    flag = true;
                } else if(tmp[1] >= next[1] && tmp[0] <= next[1] && next[0] < tmp[0]) {
                    tmp[0] = next[0];
                    list.set(i, tmp);
                    list.remove(j);
                    flag = true;
                } else if (next[0] <= tmp[0] && next[1] >= tmp[1]) {
                    list.remove(i);
                    flag = true;
                    break;
                } else if (tmp[0] <= next[0] && tmp[1] >= next[1]) {
                    list.remove(j);
                    flag = true;
                } else {
                    j++;
                }
            }
            if(!flag) {
                i++;
            }
        }

        int[][] rs = new int[list.size()][2];
        for(int i = 0;i < list.size();i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] rs = mergeIntervals.merge(intervals);
        for(int i = 0;i < rs.length;i++) {
            for(int j = 0;j < rs[i].length;j++) {
                System.out.print(rs[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
