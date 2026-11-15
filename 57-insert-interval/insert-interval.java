class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 >= s2) {
                e1 = Math.max(e1, e2);
                continue;
            } else {
                list.add(new int[] { s1, e1 });
                s1 = s2;
                e1 = e2;
            }

        }

        list.add(new int[] { s1, e1 });

        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int s1 = newInterval[0];
        int e1 = newInterval[1];

        if (intervals.length == 0) {
            list.add(new int[] {s1, e1});
            return list.toArray(new int[list.size()][]);
        }
        int i = 0;
        boolean isInserted = false;
        while( i < intervals.length) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if(isInserted == false && s1 < s2){
                list.add(new int[] {s1, e1});
                isInserted = true;
            }
            list.add(new int[] {s2, e2});
            i++;
        }

        if(isInserted == false){
            list.add(new int[] {s1,e1});
        }

        return merge(list.toArray(new int[list.size()][]));
    }
}