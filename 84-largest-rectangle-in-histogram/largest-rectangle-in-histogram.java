class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                maxArea = getMaxArea(heights, stack, maxArea, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()){
            maxArea = getMaxArea(heights, stack, maxArea, i);
        }

        return maxArea;
    }

    private int getMaxArea(int[] arr, Stack<Integer> stack, int maxArea, int i) {
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped] * i;
        } else{
            area = arr[popped] * (i-1 - stack.peek());
        }

        return Math.max(maxArea, area);
    }
}