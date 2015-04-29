/**
   Cody Leaf 
   CS 110
*/

import java.util.Random;

public class Deck 
{
   //declarations 
   int rank, suit, index;
   Card newCard;
   Deck hand1;
   Deck hand2;
   Random rand = new Random();
   
   private Card head;
   private int numItems;
   
   /**
      Create an empty deck 
   */
   public Deck()
   {
      head = null;
      numItems = 0;
   }
   
   /**
      fill the deck with 52 cards
      note they are not shuffled
   */
   public void fill()
   {
      
      for (rank = 2; rank < 15; rank++)//go through every rank
      {
         for (suit = 1; suit < 5; suit++)//go through every suit
         {
            newCard = new Card(rank, suit);//create card
            add(newCard);//add to the top
                   
         }
      }
    } 
   
   /**
      Shuffle deck and deal into to two hands
      those hands can be accessed with getHand1() and get Hand2() methods
   */ 
   public void deal()
   {
     int deck = 1;//start with player1
     hand1 = new Deck();//player1's hand
     hand2 = new Deck();//player2's hand
     for (int cardsInDeck = 52; cardsInDeck > 0; cardsInDeck--)//go through every card in the deck
     {          
       index = rand.nextInt(cardsInDeck)+1;//randomly choose cards
       if (deck == 1)//deal to player 1
       {
          hand1.add(this.get(index));//add card to hand
          this.remove(index);//remove card from deck
          deck = 2;//now deal to the other player
       }
       else//deal to player 2
       {
          hand2.add(this.get(index));//add card to hand
          this.remove(index);//remove card from deck
          deck = 1;//now deal to the other player
       }
     }   
   }
   
   /**
      returns one of the dealt hands from the deal() method
      @return Deck object with 26 random cards
   */
   public Deck getHand1()
   {
       return hand1;
   }
   
   /**
      returns the other dealt hand from the deal() method
      @return Deck object with 26 random cards 
   */
   public Deck getHand2()
   {
       return hand2;
   }
   
   /**
      check for an empty deck
      @return true if deck is empty, false if it contains 1 or more cards 
   */
   public boolean isEmpty() {
     return numItems == 0;
   }  
   
   /**
      get the number of cards in the deck
      @return (int) number of cards in the deck
   */
   public int size() 
   {
     return numItems;
   }  
   
   /**
      find a card at a specific index
      @param index index of the desired card
      @return card object at the specified index
   */
   private Card find(int index) {
         int currIndex = 1;
      Card curr = head;
      while (currIndex != index)
      {
         curr = curr.getNext();
         currIndex++;
      }
      return curr;
  } // end find
   
  /**
      get the card at the specified index
      @param index index of the desired card
      @return the card obect at the specified index
  */
  public Card get(int index) 
                throws ListIndexOutOfBoundsException {
    if (index >= 1 && index <= numItems) {
      // get reference to card, then data in card
      Card curr = find(index);
      Card currCard = curr.getCard();
      return currCard;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
    } // end if
  } // end get
   
   /**
      add a Card to the front of the deck
      @param newCard card to add to the deck
   */ 
   public void add(Card newCard)
   {
      Card nCard = new Card(newCard, head);
      head = nCard;
      numItems++;
   } 

   /**
      Remove the card at the specified index
      @param index index of the card to remove
   */
   public void remove(int index) throws ListIndexOutOfBoundsException 
   {
    if (index >= 1 && index <= numItems) {
      if (index == 1) {
        // delete the first node from the list
        head = head.getNext();
      } 
      else {
        Card prev = find(index-1);
        // delete the card after the card that prev
        // references, save reference to card
        Card curr = prev.getNext(); 
        prev.setNext(curr.getNext());
      } // end if
      numItems--;
    } // end if
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
    } // end if
  }   // end remove
   
   /**
      remove all cards from the deck
   */
  public void removeAll() 
  {
   head = null;
   numItems = 0;
  } 
  
} 
