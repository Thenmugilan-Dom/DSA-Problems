class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] populationChange = new int[101]; 

        for (int[] log : logs) {
            populationChange[log[0] - 1950]++; 
            populationChange[log[1] - 1950]--; 
        }

        int maxPopulation = 0;
        int year = 1950;
        int currentPopulation = 0;

        for (int i = 0; i < 101; i++) {
            currentPopulation += populationChange[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                year = 1950 + i;
            }
        }

        return year;
    }
}