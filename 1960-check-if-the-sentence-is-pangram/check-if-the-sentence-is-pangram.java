class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        sentence.toLowerCase();
        for(char c : sentence.toCharArray()){
            set.add(c);
        }
        return set.size() == 26;
    }
}