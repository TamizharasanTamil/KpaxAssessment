package org.test.Casino;

public class Slots extends CasinoGame {
    void play(Player player, int bet) {
        validate(player, bet);
        System.out.println("Spinning the reels");

        if (bet % 2 == 0) {
            player.win(bet);
            System.out.println("Slots validation passed");
        } else {
            player.lose(bet);
            System.out.println("Slots validation failed");
        }

        System.out.println("Finished round Slots for player " +
                player.getUsername() + ", current balance: " + player.getBalance());
    }

    private void validate(Player player, int bet) {
        if (bet > player.getBalance()) {
            throw new IllegalArgumentException("Slots validation failed");
        } else {
            System.out.println("Slots validation passed");
        }
    }
}