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
   
   /**
      create a new game
      there will be two shuffled hands in the hand1 and hand2 deck objects
      and a deck object pile to store cards intermittenly during game play
   */   
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
      get the appropriate picture for the player 
<<<<<<< HEAD
      @return file name for a picture of the user's card 
=======
>>>>>>> origin/master
   */
   public String getPlayerCard()
   {
      return card1.getCardPic();
   }
   
   /**
<<<<<<< HEAD
      get the appropriate picture for the computer
      @return file name for a picture of the computer's card 
=======
      get the appropriate picture for the computer 
>>>>>>> origin/master
   */   
   public String getCompCard()
   {
      return card2.getCardPic();
   }
   
   /**
      get the number of cards in the player's hand
      @return number of cards in player's hand
   */
   public int sizePlayersHand()
   {
      return hand1.size();
   }
   
   /**
      get the number of cards in the computer's hand
      @return number of cards in computer's hand
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
