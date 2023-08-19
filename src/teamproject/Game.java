/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teamproject;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private GroupOfCards deck;

    public Game() {
        players = new ArrayList<>();
        deck = new GroupOfCards();
        deck.shuffle();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Initialize players and bets
        for (Player player : players) {
            player.placeBet(); // You need to implement this method in Player class
        }

        // Deal initial cards
        dealInitialCards();

        
        for (Player player : players) {
            while (!player.isBust() && !player.isStanding() && player.wantToHit()) {
                player.hit(deck.drawCard());
            }
        }

        // Dealer's turn
        dealer();

        // Determine winners and distribute winnings
        winnings();

        // Clear hands and reset standing status for the next round
        clearHands();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.hit(deck.drawCard());
            }
        }
    }

    private void dealer() {
        Player dealer = players.get(0); // Assuming dealer is always the first player
        while (dealer.getScore() < 17) {
            dealer.hit(deck.drawCard());
        }
    }

    private void winnings() {
        Player dealer = players.get(0);
        int dealerScore = dealer.getScore();

        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.isBust()) {
                // Player busts, dealer wins
                player.lose();
            } else if (dealerScore > 21 || player.getScore() > dealerScore) {
                // Dealer busts or player's score is higher, player wins
                player.win();
            } else if (player.getScore() == dealerScore) {
                // It's a push
                player.push();
            } else {
                // Player's score is lower than dealer's, player loses
                player.lose();
            }
        }
    }

    private void clearHands() {
        for (Player player : players) {
            player.clearHand();
            player.resetStanding();
        }
    }

}
