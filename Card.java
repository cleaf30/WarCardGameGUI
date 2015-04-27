/**
   Cody Leaf
   CS 110
   
*/

public class Card
{
   //SUITS
   public final static int SPADES = 1;
   public final static int HEARTS = 2;
   public final static int DIAMONDS=3;
   public final static int CLUBS =  4;
   //RANKS
   public final static int ACE = 14;
   public final static int KING =13;
   public final static int QUEEN=12;
   public final static int JACK =11;
   public final static int TEN =  10;
   public final static int NINE = 9;
   public final static int EIGHT =8;
   public final static int SEVEN =7;
   public final static int SIX =  6;
   public final static int FIVE = 5;
   public final static int FOUR = 4;
   public final static int THREE =3;
   public final static int TWO =  2;
   //declare variables
   private int suit;
   private int rank;
   Card next;
   
   /**
      Constructor
      @param rank rank ex. queen
      @param suit suit ex. clubs
   */
   public Card(int rank, int suit)
   {
      this.suit = suit;
      this.rank = rank;
      next = null;
   }
   
   /**
      Constructor
      @param playingCard Card object to copy
      @param nextCard Card object to set as the next in line 
   */
   public Card(Card playingCard, Card nextCard)
   {
      this.suit = playingCard.suit;
      this.rank = playingCard.rank;
      next = nextCard;
   }
   
   /**
      get card's suit
      @return suit
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
      get card's rank
      @return rank
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
      get String representation of the card 
      @return "Card's rank" of "card's suit" ex. Ace of Spades
   */
   public String toString()
   {
      return rankToString(this.rank)+" of "+suitToString(this.suit);
   }
   
   /**
      convert rank as an int to rank as a String
      @param rank rank in int form
      @return rank in String form
   */
   public String rankToString(int rank)
   {
      switch (rank)
      {
         case (ACE):
            return "Ace";
         case (KING):
            return "King";
         case (QUEEN):
            return "Queen";
         case (JACK):
            return "Jack";
         case (TEN):
            return "Ten";
         case (NINE):
            return "Nine";
         case (EIGHT):
            return "Eight";
         case (SEVEN):
            return "Seven";
         case (SIX):
            return "Six";
         case (FIVE):
            return "Five";
         case (FOUR):
            return "Four";
         case (THREE):
            return "Three";
         case (TWO):
            return "Two";
         default:
            return null;
      }
   }
   
   /**
      Convert suit as an int to suit as a String
      @param suit suit in int form
      @return suit in String form
   */
   public String suitToString(int suit)
   {
      switch (suit)
      {
         case (SPADES):
            return "Spades";
         case (CLUBS):
            return "Clubs";
         case (HEARTS):
            return "Hearts";
         case (DIAMONDS):
            return "Diamonds";
         default:
            return null;
      }
   }
   
   /**
      Compare rank
      @param otherCard Card object to compare rank to
      @return int representing difference in rank (this card rank - other card rank)
   */
   public int compareTo(Card otherCard)
   {
      return (this.getRank() - otherCard.getRank());
      
   }

   /**
      set the next card in the line
      @param nextCard to set as the next in line 
   */
   public void setNext(Card nextCard) 
   {
    next = nextCard;
   } 

  /** 
      get the next card in the deck    
      @return next card in deck
  */
  public Card getNext() 
  {
    return next;
  }
  
  /**
      get card 
      @return this Card object
  */
  public Card getCard() 
  {
    return this;
  }
   
   /**
      get .jpg file of the card
      @return file name ex. "10d.jpg"
   */  
   public String getCardPic()
   {
     
      switch (rank)
      {
         case (14):
            switch (suit)
            {
               case(1):
                  return "aces.jpg";
               case(2):
                  return "aceh.jpg";
               case(3):
                  return "aced.jpg";
               case(4):
                  return "acec.jpg";
            }
         case (13):
            switch (suit)
            {
               case(1):
                  return "kings.jpg";
               case(2):
                  return "kingh.jpg";
               case(3):
                  return "kingd.jpg";
               case(4):
                  return "kingc.jpg";
             }
         case (12):
            switch (suit)
            {
               case(1):
                  return "queens.jpg";
               case(2):
                  return "queenh.jpg";
               case(3):
                  return "queend.jpg";
               case(4):
                  return "queenc.jpg";
             }
         case (11):
            switch (suit)
            {
               case(1):
                  return "jacks.jpg";
               case(2):
                  return "jackh.jpg";
               case(3):
                  return "jackd.jpg";
               case(4):
                  return "jackc.jpg";
             }
         case (10):
            switch (suit)
            {
               case(1):
                  return "10s.jpg";
               case(2):
                  return "10h.jpg";
               case(3):
                  return "10d.jpg";
               case(4):
                  return "10c.jpg";
             }
         case (9):
            switch (suit)
            {
               case(1):
                  return "9s.jpg";
               case(2):
                  return "9h.jpg";
               case(3):
                  return "9d.jpg";
               case(4):
                  return "9c.jpg";
             }
         case (8):
            switch (suit)
            {
               case(1):
                  return "8s.jpg";
               case(2):
                  return "8h.jpg";
               case(3):
                  return "8d.jpg";
               case(4):
                  return "8c.jpg";
             }
         case (7):
            switch (suit)
            {
               case(1):
                  return "7s.jpg";
               case(2):
                  return "7h.jpg";
               case(3):
                  return "7d.jpg";
               case(4):
                  return "7c.jpg";
             }
         case (6):
            switch (suit)
            {
               case(1):
                  return "6s.jpg";
               case(2):
                  return "6h.jpg";
               case(3):
                  return "6d.jpg";
               case(4):
                  return "6c.jpg";
             }
         case (5):
            switch (suit)
            {
               case(1):
                  return "5s.jpg";
               case(2):
                  return "5h.jpg";
               case(3):
                  return "5d.jpg";
               case(4):
                  return "5c.jpg";
             }
         case (4):
            switch (suit)
            {
               case(1):
                  return "4s.jpg";
               case(2):
                  return "4h.jpg";
               case(3):
                  return "4d.jpg";
               case(4):
                  return "4c.jpg";
             }
         case (3):
            switch (suit)
            {
               case(1):
                  return "3s.jpg";
               case(2):
                  return "3h.jpg";
               case(3):
                  return "3d.jpg";
               case(4):
                  return "3c.jpg";
             }
         case (2):
            switch (suit)
            {
               case(1):
                  return "2s.jpg";
               case(2):
                  return "2h.jpg";
               case(3):
                  return "2d.jpg";
               case(4):
                  return "2c.jpg";
             }
         default:
            return null;
   }
   } 

}