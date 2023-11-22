package org.test.Casino;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String username;
    private int balance;

    Player(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    String getUsername() {
        return username;
    }

    int getBalance() {
        return balance;
    }

    void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    void withdraw(int amount) {
        if (amount < 0 || amount > balance) {
            throw new IllegalArgumentException("Withdrawal amount is invalid");
        }
        balance -= amount;
    }

    void win(int amount) {
        balance += amount;
    }

    void lose(int amount) {
        balance -= amount;
    }
}


