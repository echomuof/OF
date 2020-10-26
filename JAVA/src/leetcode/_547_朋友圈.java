package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/26
 */
public class _547_朋友圈 {
    /**
     * 并查集
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i <= M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.getCount();
    }

    static class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }

        }

        public int getCount() {
            return count;
        }
    }
}
