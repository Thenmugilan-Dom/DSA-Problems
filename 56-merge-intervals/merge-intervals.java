class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) ->Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] start = intervals[0];
 
        for(int i=0; i<n; i++){
            int [] end = intervals[i];
            if(end[0] <= start[1]){
                start[1] = Math.max(start[1], end[1]);
            }
            else{
                merged.add(start);
                start = end;
            }
        }
        merged.add(start);
        return merged.toArray(new int[merged.size()][]);
    }
}