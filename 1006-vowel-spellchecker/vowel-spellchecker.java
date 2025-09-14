import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordsPerfect = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> wordsCap = new HashMap<>();
        Map<String, String> wordsVow = new HashMap<>();
        
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String devowel = devowel(lower);
            
            wordsCap.putIfAbsent(lower, word);
            wordsVow.putIfAbsent(devowel, word);
        }
        
        String[] ans = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (wordsPerfect.contains(query)) {
                ans[i] = query; 
            } else {
                String lower = query.toLowerCase();
                String devowel = devowel(lower);
                
                if (wordsCap.containsKey(lower)) {
                    ans[i] = wordsCap.get(lower);
                } else if (wordsVow.containsKey(devowel)) {
                    ans[i] = wordsVow.get(devowel); 
                } else {
                    ans[i] = "";
                }
            }
        }
        
        return ans;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
