package Tree;

import java.util.*;

public class FindLongestZigzag {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Test cases:
        // 5 5 -1 5 5 5 5 -1 5 -1 -1 5 5 -1 -1 -1 -1 -1 5 5 -1 5 -1 -1 5 -1 -1 -> 4
        // 5 3 20 6 -1 -1 -1 -1 10 1 -1 -1 15 30 -1 9 -1 -1 8 -1 -1 -> 2
        Tree tree = Tree.buildTree(sc);
        System.out.println(solution(tree));
    }
    
    private static int solution(Tree T) {
    	helper(T.l, true, 0);
    	helper(T.r, false, 0);
    	return res;
    }
    
    private static void helper(Tree T, boolean fromLeft, int turns) {
        if (T == null) return;
    	res = Math.max(res, turns);
    	if (T.l != null) {
    		if (fromLeft) helper(T.l, true, turns);
    		else helper(T.l, true, turns + 1);
    	}
    	if (T.r != null) {
    		if (fromLeft) helper(T.r, false, turns + 1);
    		else helper(T.r, false, turns);
    	}
    }
}
