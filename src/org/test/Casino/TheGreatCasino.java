package org.test.Casino;

import java.util.HashMap;
import java.util.Map;

public class TheGreatCasino {
    private Map<String, Player> players;

    public TheGreatCasino() {
        this.players = new HashMap<>();
    }

    public void runCasino(String[] actions) {
        for (String action : actions) {
            String[] parts = action.split(",");
            String command = parts[0];
            String username = parts[1];

            switch (command) {
                case "register":
                    int initialBalance = Integer.parseInt(parts[2]);
                    registerPlayer(username, initialBalance);
                    break;
                case "deposit":
                    int depositAmount = Integer.parseInt(parts[2]);
                    deposit(username, depositAmount);
                    break;
                case "withdraw":
                    int withdrawalAmount = Integer.parseInt(parts[2]);
                    withdraw(username, withdrawalAmount);
                    break;
                case "playBlackjack":
                    int blackjackBet = Integer.parseInt(parts[2]);
                    playGame(new Blackjack(), username, blackjackBet);
                    break;
                case "playSlots":
                    int slotsBet = Integer.parseInt(parts[2]);
                    playGame(new Slots(), username, slotsBet);
                    break;
                case "playRoulette":
                    int rouletteBet = Integer.parseInt(parts[2]);
                    playGame(new Roulette(), username, rouletteBet);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private void registerPlayer(String username, int initialBalance) {
        if (players.containsKey(username.toLowerCase())) {
            throw new IllegalArgumentException("Username already exists: " + username);
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        Player player = new Player(username, initialBalance);
        players.put(username.toLowerCase(), player);
    }

    private void deposit(String username, int amount) {
        Player player = getPlayer(username);
        player.deposit(amount);
    }

    private void withdraw(String username, int amount) {
        Player player = getPlayer(username);
        player.withdraw(amount);
    }

    private void playGame(CasinoGame game, String username, int bet) {
        Player player = getPlayer(username);
        game.play(player, bet);
    }

    private Player getPlayer(String username) {
        Player player = players.get(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found: " + username);
        }
        return player;
    }

    public static void main(String[] args) {
        TheGreatCasino casino = new TheGreatCasino();

        String[] actions1 = {"register,erezlevi,100", "deposit,erezlevi,10", "playSlots,erezlevi,5"};
        casino.runCasino(actions1);

        String[] actions2 = {"register,erezlevi,50", "register,erezlevi,80"};
        try {
            casino.runCasino(actions2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[] actions3 = {"register,erezlevi,100", "playRoulette,erezlevi,5",
                "playSlots,erezlevi,10", "playSlots,erezlevi,5"};
        casino.runCasino(actions3);

        String[] actions4 = {"register,erezlevi,100", "withdraw,erezlevi,80",
                "playBlackjack,erezlevi,90", "playBlackjack,erezlevi,20"};
        casino.runCasino(actions4);
    }
}