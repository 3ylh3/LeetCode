import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 589
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class NAryTreePreorderTravelsal {
    public List<Integer> preorder(Node root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<Integer>();
        pre(list,root);
        return list;
    }
    public void pre(List list,Node root){
        list.add(root.val);
        Iterator<Node> i = root.children.iterator();
        while(i.hasNext()){
            pre(list,i.next());
        }
    }
}
