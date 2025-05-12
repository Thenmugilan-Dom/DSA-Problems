class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPalindrome(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
