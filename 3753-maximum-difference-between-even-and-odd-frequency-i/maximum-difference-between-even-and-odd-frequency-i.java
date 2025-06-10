class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int maxodd = Integer.MIN_VALUE;
        int mineven = Integer.MAX_VALUE;
        
        int max;
        
        for(int i : freq.values()){ 
            if(i%2==0){
                mineven = Math.min(mineven, i);
            }else{
                maxodd = Math.max(maxodd, i);
            }
        }
        return maxodd - mineven;
    }
}