package org.test.Casino;

class Blackjack extends CasinoGame {
    void play(Player player, int bet) {
        validate(player, bet);
        System.out.println("Shuffling deck");
        System.out.println("Drawing cards");

        if (bet % 2 == 0) {
            player.win(bet);
            System.out.println("Blackjack validation passed");
        } else {
            player.lose(bet);
            System.out.println("Blackjack validation failed");
        }

        System.out.println("Finished round Blackjack for player " +
                player.getUsername() + ", current balance: " + player.getBalance());
    }

    private void validate(Player player, int bet) {
        if (bet > player.getBalance()) {
            throw new IllegalArgumentException("Blackjack validation failed");
        } else {
            System.out.println("Blackjack validation passed");
        }
    }
}