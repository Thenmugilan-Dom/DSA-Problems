import java.util.*;

class FoodRatings {
    private static class Food {
        String name;
        int rating;
        Food(String n, int r) {
            name = n;
            rating = r;
        }
    }

    private Map<String, String> foodToCuisine;        // food -> cuisine
    private Map<String, Integer> foodToRating;        // food -> rating
    private Map<String, TreeSet<String>> cuisineMap;  // cuisine -> foods (ordered)

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineMap.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int ra = foodToRating.get(a);
                    int rb = foodToRating.get(b);
                    if (ra != rb) return rb - ra; // higher rating first
                    return a.compareTo(b);       // lexicographically smaller first
                }
            ));
            cuisineMap.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);

        // Remove old entry
        cuisineMap.get(cuisine).remove(food);

        // Update rating
        foodToRating.put(food, newRating);

        // Reinsert with new rating
        cuisineMap.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first();
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */