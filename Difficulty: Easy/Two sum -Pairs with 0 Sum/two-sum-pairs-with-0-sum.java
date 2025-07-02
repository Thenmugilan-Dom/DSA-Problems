// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> uniquePairs = new TreeSet<>((a, b) -> {
            if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        for (int num : arr) {
            if (seen.contains(-num)) {
                List<Integer> pair = Arrays.asList(Math.min(num, -num), Math.max(num, -num));
                uniquePairs.add(pair);
            }
            seen.add(num);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (List<Integer> pair : uniquePairs) {
            result.add(new ArrayList<>(pair));
        }

        return result;
    }
}
