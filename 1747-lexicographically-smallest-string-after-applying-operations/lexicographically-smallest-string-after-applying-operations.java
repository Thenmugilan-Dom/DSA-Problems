class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        seen.add(s);
        q.offer(s);
        String smallest = s;
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            
            String added = addToOddIndices(curr, a);
            
            if (seen.add(added)) {
                q.offer(added);
            }
            String rotated = rotate(curr, b);
            
            if (seen.add(rotated)) {
                q.offer(rotated);
            }
        }
        
        return smallest;
    }
    
    private String addToOddIndices(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int digit = chars[i] - '0';
            digit = (digit + a) % 10;
            chars[i] = (char) (digit + '0');
        }
        return new String(chars);
    }
    
    private String rotate(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
