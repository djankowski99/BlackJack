
package blackjack;

public class Hand {
    
    Deck deck;
    HumanPlayer player;
    Dealer dealer;
    int whoWins = -1; //0 for player 1 for dealer tow for tie
    
    public Hand(Dealer dealer, HumanPlayer player){
    
    this.player = player;
    this.dealer =  dealer;
    deck = new Deck();
    deck.suffle();
    
    player.hand.clear();
    dealer.hand.clear();
  
    givePlayerCard();
    giveDealCard();
    givePlayerCard();
    giveDealCard(); 
 
    
    if(player.handVal == 21)
            whoWins = 0;
    }
    
    public void playersTurn(){
        if (player.busted() == true)
            whoWins = 1;
        if (player.hasBlackJack()==true)
            whoWins =0;
    }
    
    public void dealersTurn(){
        while (dealer.gethandVal() < 17){
            giveDealCard();     
        }
        if( dealer.busted()== true)
            whoWins = 0;
    }
    public void whoWon(){//returns 0 for player, 1 for dealer and 2 for tie
      if(whoWins == -1){ //only if someone has not already won 
        if(dealer.handVal > player.gethandVal())
            whoWins = 1;
        else if(player.handVal > dealer.gethandVal())
            whoWins = 0;
        else if(dealer.handVal == player.gethandVal())
            whoWins = 2;
    }
    }
    public void giveDealCard(){
    dealer.hand.add(deck.cards.get(0));
    deck.cards.remove(0);
    }
   
    public void givePlayerCard(){
    player.hand.add(deck.cards.get(0));
    deck.cards.remove(0);
    }

    public int getWinner(){
        return whoWins;
    }
}
