import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class FindMoreInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> tmpList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        mid(root,tmpList);
        int tmp = tmpList.get(0);
        int maxCount = 0;
        int tmpCount = 0;
        Iterator<Integer> i = tmpList.iterator();
        while(i.hasNext()){
            int tmp1 = i.next();
            if(tmp == tmp1){
                tmpCount++;
            }
            else{
                if(maxCount < tmpCount) {
                    list.clear();
                    list.add(tmp);
                    maxCount = tmpCount;
                }
                else if(maxCount == tmpCount){
                    list.add(tmp);
                }
                tmp = tmp1;
                tmpCount = 1;
            }
        }
        if(maxCount < tmpCount) {
            list.clear();
            list.add(tmp);
            maxCount = tmpCount;
        }
        else if(maxCount == tmpCount){
            list.add(tmp);
        }
        int[] res = new int[list.size()];
        for(int j = 0;j < list.size();j++){
            res[j] = list.get(j);
        }
        return res;
    }
    public void mid(TreeNode root,List<Integer> list){
        if(root != null){
            if(root.left != null){
                mid(root.left,list);
            }
            list.add(root.val);
            if(root.right != null){
                mid(root.right,list);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.right = null;
        root.right = treeNode;
        FindMoreInBinarySearchTree findMoreInBinarySearchTree = new FindMoreInBinarySearchTree();
        int[] i = findMoreInBinarySearchTree.findMode(root);
        for(int j = 0;j < i.length;j++){
            System.out.println(i[j]);
        }
    }
}
