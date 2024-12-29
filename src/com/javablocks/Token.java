package com.javablocks;
import java.util.HashMap;
import java.util.Map;

// Token contract to manage tokens on the blockchain
class Token {
    private Map<String, Integer> balances; // Map of address to token balances

    public Token() {
        balances = new HashMap<>();
    }

    // Method to get token balance of an address
    public int getBalance(String address) {
        return balances.getOrDefault(address, 0);
    }

    // Method to transfer tokens from one address to another
    public boolean transfer(String fromAddress, String toAddress, int amount) {
        if (getBalance(fromAddress) >= amount) {
            balances.put(fromAddress, getBalance(fromAddress) - amount);
            balances.put(toAddress, getBalance(toAddress) + amount);
            System.out.println(amount + " tokens transferred from " + fromAddress + " to " + toAddress);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}
