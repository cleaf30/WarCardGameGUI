/**
   Cody Leaf
   CS 110
*/


public class War extends Game
{

   /**
      create a Game object
   */      
   public War()
   {
      super();
   }
   
   /**
      play a hand
      @return outcome of hand
   */ 
   public String play()
   {    
      String outcome = null;
      //if (!hand1.isEmpty() && !hand2.isEmpty())
      try
      {
         
         card1 = hand1.get(hand1.size());//get card 
         card2 = hand2.get(hand2.size());//get card
         hand1.remove(hand1.size());//remove card from the hand
         hand2.remove(hand2.size());//remove card from the hand
         if (card1.compareTo(card2) == 0)//Tie
         {
            //add tied cards to pile
            pile.add(card1);
            pile.add(card2);
            //add next two cards face down to pile
            card1down = hand1.get(hand1.size());//get card 
            card2down = hand2.get(hand2.size());//get card
            hand1.remove(hand1.size());//remove card from the hand
            hand2.remove(hand2.size());//remove card from the hand
            pile.add(card1down);
            pile.add(card2down);
            
            outcome = "Tie";
         }
         else if (card1.compareTo(card2) > 0)//card1 is bigger
         {
            //player1 takes cards
            hand1.add(card2);
            hand1.add(card1);
            //take any cards left over from a tie
            while (!pile.isEmpty())
            {
               hand1.add(pile.get(1));
               pile.remove(1);
            }
            
            outcome = "You Won!";
               
         }
         else//card2 is bigger
         {
            //player2 takes cards
            hand2.add(card1);
            hand2.add(card2);
            //take any cards left over from a tie
            while (!pile.isEmpty())
            {
               hand2.add(pile.get(1));
               pile.remove(1);
            }
            
            outcome = "The computer won.";

         }  
      
      }
      catch (ListIndexOutOfBoundsException e)//tried to acess cards in a tie but someone ran out
      {
      if (hand1.isEmpty())//user ran out of cards
      {
         outcome = "The computer won";
      }
      else//computer ran out of cards
      {
         outcome = "You Won!";
      }
      }
      return outcome;
   } 
    
}