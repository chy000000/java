package flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: chy
 * @Date: 2021/1/14 20:43
 * @Description:
 */
public class FlyweightTest {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("abc", "123"));
        TreeNode treeNode2 = new TreeNode(3, 4, TreeFactory.getTree("abc", "123"));

        TreeNode treeNode3 = new TreeNode(3, 4, TreeFactory.getTree("abc1", "123"));
        TreeNode treeNode4 = new TreeNode(3, 4, TreeFactory.getTree("abc1", "123"));
    }
}

class TreeNode {
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree abc) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "x=" + x +
                ", y=" + y +
                ", tree=" + tree +
                '}';
    }
}
class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
        System.out.println("Tree " + name + " create!");
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<> ();
    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
}