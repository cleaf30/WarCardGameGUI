/**
   Cody Leaf
   CS 110
*/

public abstract class Game
{
   //Declarations
   Card newCard, card1, card2, card1down, card2down;
   Deck d, hand1, hand2, pile; 
   int rank, suit, cardsInDeck, index, deck, cont;
      
   public Game()
   {
      d = new Deck();
      d.fill();//fill the deck
      d.deal();//shuffle and deal out two hands
      hand1 = d.getHand1();//get users hand
      hand2 = d.getHand2();//get computer's hand
      pile = new Deck();
   }
   
   /**
      get the appropriate picture for the player aka card 1
   */
   public String getPlayerCard()
   {
      return card1.getCardPic();
   }
   
   /**
      get the appropriate picture for the computer aka card 2
   */   
   public String getCompCard()
   {
      return card2.getCardPic();
   }
   
   /**
      get the number of cards in the player's hand
   */
   public int sizePlayersHand()
   {
      return hand1.size();
   }
   
   /**
      get the number of cards in the computer's hand
   */
   public int sizeCompHand()
   {
      return hand2.size();
   }
   

   
   /**
      play a hand
      @return outcome of the hand
   */ 
   abstract String play();
   
     

}