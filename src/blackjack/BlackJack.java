package blackjack;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //imports
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BlackJack {
    Frame frame;
    Hand hand;
    HumanPlayer player;
    Dealer dealer;
    Boolean handOn = false;
    int orgBank=100;
    int newBank;
  
    ArrayList<ImageIcon> userCard = new ArrayList();
    ArrayList<ImageIcon> dealCard = new ArrayList();
    ArrayList<JLabel> userLabel = new ArrayList();
    ArrayList<JLabel> dealLabel = new ArrayList();
    
    
    public BlackJack(){
    
     frame = new Frame();
     frame.setTitle("Blackjack");
     frame.setVisible(true);
     frame.setResizable(false);
     player = new HumanPlayer(getBet(),getBank());
     dealer = new Dealer();
     frame.newHandButton.addActionListener(new HandListener());
     frame.hitButton.addActionListener(new HitListener());
     frame.betField.addActionListener(new BetListener());
     frame.stayButton.addActionListener(new StayListener());
     frame.userPanel.setLayout(new GridLayout());
     frame.dealPanel.setLayout(new GridLayout());
    
     userLabel.add(frame.uCard1);
     userLabel.add(frame.uCard2);
     userLabel.add(frame.uCard3);
     userLabel.add(frame.uCard4);
     dealLabel.add(frame.dCard1);
     dealLabel.add(frame.dCard2);
     dealLabel.add(frame.dCard3);
     dealLabel.add(frame.dCard4);
  
    }
 

    class HandListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {        
            clearPlayer();
            handOn = true;
            hand = new Hand(dealer,player);
            frame.betField.setEditable(false);
            setBank(getBank()-getBet());
            printPlayer();
            showPlayer();
            showDealer1();
            checkWhoWins();
        }
     
 }
    class HitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
         if(handOn == true){
         hand.givePlayerCard();
         printPlayer();
         showPlayer();
         hand.playersTurn();
         checkWhoWins();
         }
        }
    }
    class StayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           if(handOn == true){
           hand.dealersTurn();
  //       printDealer();
           showDealer2();
           hand.whoWon();
           checkWhoWins();
        }
    }
    }
    
    class BetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){            
            setBet();
            }
    }
    
  public void checkWhoWins(){
      if (hand.getWinner() ==0){
          frame.playerArea.append("\n"+ "YOU WIN!");
          setBank(getBank() + 2*getBet());
          frame.betField.setText("0");
          frame.betField.setEditable(true);
          handOn = false;
      }
      if (hand.getWinner() == 1){
          frame.playerArea.append("\n"+ "YOU LOSE");
          frame.betField.setText("0");
          frame.betField.setEditable(true);
          handOn = false;
      }
      if(hand.getWinner()==2){
          frame.playerArea.append("\n"+ "TIE");
          setBank(getBank()+getBet());
          frame.betField.setEditable(true);
          handOn = false;
      }
  }
  
public void showPlayer(){
    clearPlayer();
    for(int x = 0; x < player.hand.size();x++){
       userCard.add(x,(new ImageIcon("/home/dan/Documents/JavaFiles/BlackJack/Cards/"+player.hand.get(x).getCardLoc()+".png")));
       userLabel.get(x).setIcon(userCard.get(x));
       System.out.println(player.hand.get(x).getCardLoc()+ " " + userLabel.get(x).getText());
     }
    System.out.println();
}
public void clearPlayer(){
   for(int x = 0; x < userCard.size();x++){
       userCard.remove(x);
   }
   for(int x = 0; x < userLabel.size();x++){
       userLabel.get(x).setIcon(null);
   }
}
public void showDealer1(){
    clearDealer();
    for(int x = 0; x < dealer.hand.size();x++){
       dealCard.add(x,(new ImageIcon("/home/dan/Documents/JavaFiles/BlackJack/Cards/"+dealer.hand.get(x).getCardLoc()+".png")));
       if(x == 0){
          dealLabel.get(x).setIcon(new ImageIcon("/home/dan/Documents/JavaFiles/BlackJack/Cards/cardBack_red2.png"));
       }
       
       else dealLabel.get(x).setIcon(dealCard.get(x));
     }
    System.out.println();
}

public void showDealer2(){
    clearDealer();
    for(int x = 0; x < dealer.hand.size();x++){
       dealCard.add(x,(new ImageIcon("/home/dan/Documents/JavaFiles/BlackJack/Cards/"+dealer.hand.get(x).getCardLoc()+".png")));
       dealLabel.get(x).setIcon(dealCard.get(x));
     }
    System.out.println();
}

public void clearDealer(){
   for(int x = 0; x < dealCard.size();x++){
       dealCard.remove(x);
   }
   for(int x = 0; x < dealLabel.size();x++){
       dealLabel.get(x).setIcon(null);
   }
}

  public void printPlayer(){
     frame.playerArea.setText(null);
      for(int x = 0; x < player.hand.size();x++)
        frame.playerArea.append(player.hand.get(x).getCardType()+ " ");
      frame.playerArea.append("\n"+ "Hand Value: "+ Integer.toString(player.gethandVal()));
  }
  
  public void printDealer(){
     frame.dealerArea.setText(null);
      for(int x = 0; x < dealer.hand.size();x++)
        frame.dealerArea.append(dealer.hand.get(x).getCardType()+ " ");
      frame.dealerArea.append("\n"+ "Hand Value: "+ Integer.toString(dealer.gethandVal()));
  }
 
  public int getBet(){
   return Integer.parseInt(frame.betField.getText());  
  }
  public int getBank(){
      return Integer.parseInt(frame.bankField.getText());
  }
  public void setBet(){
    if(getBet() > getBank())
      frame.betField.setText(frame.bankField.getText()); 
  }
  public void setBank(int bank){
      frame.bankField.setText(Integer.toString(bank));
  }
  public static void main(String[] args) {
    BlackJack blackjack = new BlackJack();
     
    }
}
