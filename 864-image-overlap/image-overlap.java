class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for(int i = 0; i< img1.length; i++){
            for(int j = 0; j < img1.length; j++){
                if(img1[i][j] == 1){
                    list1.add(new int[]{i, j});
                }
            }
        }

        for(int i = 0; i< img1.length; i++){
            for(int j = 0; j < img1.length; j++){
                if(img2[i][j] == 1){
                    list2.add(new int[]{i, j});
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;

        for(int[] p1 : list1){
            for(int[] p2 : list2){
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];

                String key = dr + "_" + dc;


                map.put(key, map.getOrDefault(key, 0) + 1);

                maxOverlap = Math.max(maxOverlap, map.get(key)); 
            }
        }

        return maxOverlap;
    }
}