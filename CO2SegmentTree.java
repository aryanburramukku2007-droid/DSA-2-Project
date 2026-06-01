/*
// CO 2 
// Smart warehouse load-monitoring dashboard
// Segment Tree Range Queries
// Segment Trees
*/
public class SegmentTree {

    static int[] tree;

    static void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(2 * node, start, mid, arr);
            build(2 * node + 1, mid + 1, end, arr);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static int query(int node, int start, int end, int l, int r) {

        if (r < start || l > end)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node, start, mid, l, r)
                + query(2 * node + 1, mid + 1, end, l, r);
    }

    static void update(int node, int start, int end,
                       int idx, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node, start, mid, idx, value);
        else
            update(2 * node + 1, mid + 1, end, idx, value);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void main(String[] args) {

        int arr[] = {12,7,9,15,6,11,10,8};

        tree = new int[4 * arr.length];

        build(1,0,arr.length-1,arr);

        System.out.println("Q1 = " +
                query(1,0,7,2,6));

        System.out.println("Q2 = " +
                query(1,0,7,0,3));

        update(1,0,7,3,4);

        System.out.println("Q3 = " +
                query(1,0,7,2,6));
    }
}
