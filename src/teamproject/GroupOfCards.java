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
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private List<Card> cards;
    private int value;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

}
