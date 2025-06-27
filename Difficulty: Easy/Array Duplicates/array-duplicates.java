class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                if (!added.contains(num)) {
                    duplicates.add(num);
                    added.add(num);
                }
            } else {
                seen.add(num);
            }
        }
        return duplicates;
    }
}
