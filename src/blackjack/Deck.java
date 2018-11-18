/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {
ArrayList<Card> cards;

 public Deck(){
     cards = new ArrayList();
     cards.add(new Card(11,"Ace","cardSpadesA"));
     cards.add(new Card(11,"Ace","cardDiamondsA"));
     cards.add(new Card(11,"Ace","cardHeartsA"));
     cards.add(new Card(11,"Ace","cardClubsA"));
     cards.add(new Card(2, "Two","cardSpades2"));
     cards.add(new Card(2, "Two","cardDiamonds2"));
     cards.add(new Card(2, "Two","cardHearts2"));
     cards.add(new Card(2, "Two","cardClubs2"));
     cards.add(new Card(3, "Three","cardSpades3"));
     cards.add(new Card(3, "Three","cardDiamonds3"));
     cards.add(new Card(3, "Three","cardHearts3"));
     cards.add(new Card(3, "Three","cardClubs3"));
     cards.add(new Card(4, "Four","cardSpades4"));
     cards.add(new Card(4, "Four","cardDiamonds4"));
     cards.add(new Card(4, "Four","cardHearts4"));
     cards.add(new Card(4, "Four","cardClubs4"));
     cards.add(new Card(5, "Five","cardSpades5"));  
     cards.add(new Card(5, "Five","cardDiamonds5"));
     cards.add(new Card(5, "Five","cardHearts5"));
     cards.add(new Card(5, "Five","cardClubs5"));
     cards.add(new Card(6, "Six","cardClubs6")); 
     cards.add(new Card(6, "Six","cardDiamonds6"));
     cards.add(new Card(6, "Six","cardHearts6"));
     cards.add(new Card(6, "Six","cardClubs6"));
     cards.add(new Card(7, "Seven","cardSpades7"));
     cards.add(new Card(7, "Seven","cardDiamonds7"));
     cards.add(new Card(7, "Seven","cardHearts7"));
     cards.add(new Card(7, "Seven","cardClubs7"));
     cards.add(new Card(8, "Eight","cardSpades8"));
     cards.add(new Card(8, "Eight","cardDiamonds8"));
     cards.add(new Card(8, "Eight","cardHearts8"));
     cards.add(new Card(8, "Eight","cardClubs8"));
     cards.add(new Card(9, "Nine","cardSpades9"));
     cards.add(new Card(9, "Nine","cardDiamonds9"));
     cards.add(new Card(9, "Nine","cardHearts9"));
     cards.add(new Card(9, "Nine","cardClubs9"));
     cards.add(new Card(10, "Ten","cardSpades10"));
     cards.add(new Card(10, "Ten","cardDiamonds10"));
     cards.add(new Card(10, "Ten","cardHearts10"));
     cards.add(new Card(10, "Ten","cardClubs10"));  
     cards.add(new Card(10, "Jack","cardSpadesJ"));
     cards.add(new Card(10, "Jack","cardDiamondsJ"));
     cards.add(new Card(10, "Jack","cardHeartsJ")); 
     cards.add(new Card(10, "Jack","cardClubsJ"));
     cards.add(new Card(10, "Queen","cardClubsQ"));
     cards.add(new Card(10, "Queen","cardDiamondsQ"));
     cards.add(new Card(10, "Queen","cardHeartsQ"));
     cards.add(new Card(10, "Queen","cardClubsQ"));
     cards.add(new Card(10, "King","cardSpadesK"));
     cards.add(new Card(10, "King","cardDiamondsK"));
     cards.add(new Card(10, "King","cardHeartsK"));
     cards.add(new Card(10, "King","cardClubsK"));
 };
 

 public void suffle(){
     Collections.shuffle(cards);
 }
 
 public void printDeck(){
     for(int x = 0; x < cards.size()-1; x++)
         System.out.println(cards.get(x).getCardType());
 }
}