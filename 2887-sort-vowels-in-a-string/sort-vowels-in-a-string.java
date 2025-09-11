class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelList.add(c);
            }
        }

        Collections.sort(vowelList);

        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                result.append(vowelList.get(idx++));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
