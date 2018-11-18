/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author dan
 */

public class Card {
   private String cardType;
   private int cardVal;
   private String cardLoc;
    
   public Card(int cardVal, String cardType,String cardLoc){
        this.cardType = cardType;
        this.cardVal =  cardVal;
        this.cardLoc = cardLoc;
    }
    
   public int getCardVal(){
        return cardVal;
    }
   
   public String getCardType(){
        return cardType;
    }
   public String getCardLoc(){
       return cardLoc;
   }
}
