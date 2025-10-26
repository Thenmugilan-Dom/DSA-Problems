class Bank {
    private long[] balance; // store account balances

    // Constructor: initialize the balances
    public Bank(long[] balance) {
        this.balance = balance;
    }

    // Helper: check if account number is valid
    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }

    // Transfer money from account1 → account2
    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        if (balance[account1 - 1] < money) return false;

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    // Deposit money into an account
    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;

        balance[account - 1] += money;
        return true;
    }

    // Withdraw money from an account
    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) return false;
        if (balance[account - 1] < money) return false;

        balance[account - 1] -= money;
        return true;
    }
}
