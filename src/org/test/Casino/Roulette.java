package org.test.Casino;

public class Roulette extends CasinoGame {
    void play(Player player, int bet) {
        validate(player, bet);
        System.out.println("Spinning wheel");

        if (bet % 2 == 0) {
            player.win(bet);
            System.out.println("Roulette validation passed");
        } else {
            player.lose(bet);
            System.out.println("Roulette validation failed");
        }

        System.out.println("Finished round Roulette for player " +
                player.getUsername() + ", current balance: " + player.getBalance());
    }

    private void validate(Player player, int bet) {
        if (bet > player.getBalance()) {
            throw new IllegalArgumentException("Roulette validation failed");
        } else {
            System.out.println("Roulette validation passed");
        }
    }
}