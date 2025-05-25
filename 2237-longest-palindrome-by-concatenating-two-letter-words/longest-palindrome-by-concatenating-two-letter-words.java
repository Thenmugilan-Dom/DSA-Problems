class Solution {
    public int longestPalindrome(String[] words) {
       HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasCenter = false;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            String reverse = new StringBuilder(word).reverse().toString();

            if (!word.equals(reverse) && map.containsKey(reverse)) {
                int pairCount = Math.min(map.get(word), map.get(reverse));
                length += pairCount * 4;

                map.put(word, map.get(word) - pairCount);
                map.put(reverse, map.get(reverse) - pairCount);
            }

            else if (word.equals(reverse)) {
                int count = map.get(word);
                length += (count / 2) * 4;

                if (count % 2 == 1) {
                    hasCenter = true;
                }
            }
        }

        if (hasCenter) {
            length += 2;
        }

        return length;
    }
}