/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author yin_zhj
 * @date 2020/4/9
 */
public class ContainerWithMostWater {
    /**
     * 矩形面积为(i1-i2) * min(ai1,ai2)，受较短的线段约束，初始时用两个指针指向头尾，数值小的指针移动，
     * 比较并记录当前最大矩形面积，当两个指针重叠时结束
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i1 = 0;
        int i2 = height.length - 1;
        int rs = 0;
        while(i1 != i2) {
            int tmp = (i2 - i1) * Math.min(height[i1], height[i2]);
            if(tmp > rs) {
                rs = tmp;
            }
            if(height[i1] < height[i2]) {
                i1++;
            } else {
                i2--;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
