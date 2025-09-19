class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> results = new ArrayList<>();

        if (start == s.length()) {
            results.add(""); 
            return results;
        }

        for (String word : wordSet) {
            if (s.startsWith(word, start)) {
                List<String> subResults = dfs(s, start + word.length(), wordSet, memo);
                for (String sub : subResults) {
                    if (sub.isEmpty()) {
                        results.add(word);
                    } else {
                        results.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(start, results);
        return results;
    }
}
