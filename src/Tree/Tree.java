package Tree;
import java.util.*;

public class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public static Tree buildTree(Scanner sc) {
        int val = sc.nextInt();
        if (val == -1) return null;

        Tree tree = new Tree();
        tree.x = val;
        tree.l = buildTree(sc);
        tree.r = buildTree(sc);
        return tree;
    }
}
