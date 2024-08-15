package priv.cxs.classic150;

public class Question108 {

    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n - 1, n - 1);
    }

    private Node construct(int[][] grid, int leftI, int leftJ, int rightI, int rightJ) {
        if (leftI == rightI) {
            int val = grid[leftI][leftJ];
            return new Node(val != 0, true);
        }
        int pre = -1;
        for (int i = leftI; i <= rightI; i++) {
            for (int j = leftJ; j <= rightJ; j++) {
                int val = grid[i][j];
                if (pre == -1) {
                    pre = val;
                } else if (val != pre) {
                    Node root = new Node(true, false);
                    int half = (rightI - leftI + 1) / 2;
                    root.topLeft = construct(grid, leftI, leftJ, rightI - half, rightJ - half);
                    root.topRight = construct(grid, leftI, leftJ + half, rightI - half, rightJ);
                    root.bottomLeft = construct(grid, leftI + half, leftJ, rightI, rightJ - half);
                    root.bottomRight = construct(grid, leftI + half, leftJ + half, rightI, rightJ);
                    return root;
                }
            }
        }
        return new Node(pre != 0, true);
    }
}
