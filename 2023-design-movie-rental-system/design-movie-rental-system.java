import java.util.*;

class MovieRentingSystem {
    private Map<Integer, Integer> priceMap;  
    private Map<Integer, TreeSet<int[]>> available;
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        
        Comparator<int[]> cmpAvail = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; 
            return a[1] - b[1]; 
        };
        Comparator<int[]> cmpRent = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1]; 
            return a[2] - b[2]; 
        };

        rented = new TreeSet<>(cmpRent);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            int key = shop * 100000 + movie;
            priceMap.put(key, price);

            available.computeIfAbsent(movie, k -> new TreeSet<>(cmpAvail))
                     .add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        Iterator<int[]> it = available.get(movie).iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            int[] cur = it.next();
            res.add(cur[1]);
            cnt++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int key = shop * 100000 + movie;
        int price = priceMap.get(key);

        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int key = shop * 100000 + movie;
        int price = priceMap.get(key);

        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            int[] cur = it.next();
            res.add(Arrays.asList(cur[1], cur[2]));
            cnt++;
        }
        return res;
    }
}
