class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.first != b.first) {
                return  Double.compare(b.first , a.first);
            }

            return Integer.compare(a.second, b.second);
        });

        for (int i = 0; i < k; i++) {
            int point1 = points[i][0];
            int point2 = points[i][1];

            double dist = distFromOrigin(point1, point2);

            pq.offer(new Pair<>(dist, i));
        }

        for (int i = k; i < points.length; i++) {
            int point1 = points[i][0];
            int point2 = points[i][1];

            double dist = distFromOrigin(point1, point2);

            if (dist < pq.peek().first) {
                pq.poll();
                pq.offer(new Pair<>(dist, i));
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < ans.length; i++) {
            Pair<Double, Integer> pq1 = pq.poll();

            int j = pq1.second;

            ans[i][0] = points[j][0];
            ans[i][1] = points[j][1];
        }

        return ans;
    }

    private double distFromOrigin(int first, int second) {
        double a = Math.pow(first, 2) + Math.pow(second, 2);
        return Math.sqrt(a);
    }
}

public class Pair<X, Y> {
    X first;
    Y second;

    Pair(X a, Y b){
        first = a;
        second = b;
    }
}