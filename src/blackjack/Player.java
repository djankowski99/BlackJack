/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;


public class Player {
    
    ArrayList<Card> hand;
    int handVal;
    
    public Player(){
        hand = new ArrayList();
    }
    
    public int gethandVal(){
        handVal = 0;
        for(int x = 0; x < hand.size();x++)
            handVal = handVal + hand.get(x).getCardVal();
       return handVal;
}
      public Boolean hasBlackJack(){
        if(handVal==21) return true;
        else return false;     
    }
      public Boolean busted(){
          if (gethandVal() > 21) return true;
          else return false;
      }
}