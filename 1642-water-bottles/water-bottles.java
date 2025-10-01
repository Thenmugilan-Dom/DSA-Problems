class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            drank += newFull;
            empty = empty % numExchange + newFull;
        }

        return drank;
    }
}
