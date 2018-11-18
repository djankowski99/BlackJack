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
public class Dealer extends Player {
    public Dealer(){}
    
    public Boolean dealerHits(){
        if (handVal < 17) return true;
        else return false;
    }
  
}
