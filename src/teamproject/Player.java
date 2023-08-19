/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teamproject;

/**
 *
 * @author iparu
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private Hand hand;
    private double bet;
    private boolean isStanding;
    private boolean isVictor;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new Hand();
        this.bet = 0;
        this.isStanding = false;
        this.isVictor = false;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void hit(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }

    public double getBet() {
        return bet;
    }

    public boolean isVictor() {
        return isVictor;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public void setVictor(boolean victor) {
        isVictor = victor;
    }

    @Override
    public String toString() {
        return name + " - Score: " + score + " - Bet: " + bet + " - Standing: " + isStanding;
    }
}
