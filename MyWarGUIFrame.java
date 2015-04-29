/**
   Cody Leaf
   CS 110
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MyWarGUIFrame extends JFrame 
{
   // create panel containers
   private JPanel p1,p2,p3;
   private JButton playButton;
   private JLabel compHand, compCard, compMessage, playerHand, playerCard,
   playerMessage, genMessage, buttonLabel, playerHeader, playerNum, compHeader, compNum;
   War game = new War();//create instance of game of war

   /**
      Create frame, format, insert panels and insert labels.
      @param s title of the frame
   */
   public MyWarGUIFrame(String s) 
   {
      super (s);
      
      // layout of "this" JFrame
      setLayout(new GridLayout(3,1));//three horizontal sections
       
      ///////////////////////////////////////////// 
      // computer's panel//////////////////////////
      /////////////////////////////////////////////
      p1 = new JPanel();
      p1.setBackground(Color.RED);//red background
      p1.setLayout(new GridLayout(1,3));//three vertical sections
      
      //computer's hand----------------------------
      compHand = new JLabel();
      compHand.setIcon(new ImageIcon("back.jpg"));//show back of a card
      compHand.setHorizontalAlignment(JLabel.CENTER);//align
      p1.add(compHand);
      
      //computer's card----------------------------
      compCard = new JLabel();
      compCard.setHorizontalAlignment(JLabel.CENTER);//align
      p1.add(compCard);

      //computer's message - # of cards in hand----
      compMessage = new JLabel();
      compMessage.setLayout(new GridLayout(2,0));//two horizontal sections
      compHeader = new JLabel();
      compHeader.setText("Cards in computer's hand:");//header
      compHeader.setFont(new Font("Serif", Font.BOLD, 12));//format
      compHeader.setHorizontalAlignment(JLabel.CENTER);//align
      compNum = new JLabel(); 
      compNum.setText(Integer.toString(game.sizePlayersHand()));//display number of cards in hand
      compNum.setFont(new Font("Serif", Font.BOLD, 40));//format
      compNum.setHorizontalAlignment(JLabel.CENTER);//align
      compMessage.add(compHeader);
      compMessage.add(compNum);
      p1.add(compMessage);

      ////////////////////////////////////////
      //divider / play button / message board/
      ////////////////////////////////////////  
      p2 = new JPanel();
      p2.setBackground(Color.WHITE);//white background
      p2.setLayout(new GridLayout(2,0));//two horizontal sections
      //general message board----------------
      genMessage = new JLabel("Game of War");//create label
      genMessage.setHorizontalAlignment(JLabel.CENTER);//align
      genMessage.setFont(new Font("Serif", Font.BOLD, 30));//format
      p2.add(genMessage);
      // create button----------------------- 
      playButton = new JButton("PLAY");//create button
      playButton.setFont(new Font("Serif", Font.BOLD, 30));//format
      p2.add(playButton);
      playButton.addActionListener(new ButtonListener());//add action listener for the button

      /////////////////////////////////////////
      //player's panel/////////////////////////
      /////////////////////////////////////////
      p3 = new JPanel();
      p3.setBackground(Color.BLUE);//blue background
      p3.setLayout(new GridLayout(1,3));//three vertical sections
      //player's message - # of cards in hand--
      playerMessage = new JLabel();
      playerMessage.setLayout(new GridLayout(2,0));//two horizontal sections
      //header---------------------------------
      playerHeader = new JLabel();
      playerHeader.setText("Cards in your hand:");//text for header
      playerHeader.setFont(new Font("Serif", Font.BOLD, 14));//format
      playerHeader.setHorizontalAlignment(JLabel.CENTER);//align
      playerHeader.setForeground(Color.WHITE);//set text color to white
      //actual # in hand-----------------------
      playerNum = new JLabel();
      playerNum.setText(Integer.toString(game.sizePlayersHand()));//set to number of cards in hand
      playerNum.setFont(new Font("Serif", Font.BOLD, 40));//format
      playerNum.setHorizontalAlignment(JLabel.CENTER);//align
      playerNum.setForeground(Color.WHITE);//set text color
      playerMessage.add(playerHeader);
      playerMessage.add(playerNum);
      p3.add(playerMessage);
      //player's card---------------------------
      playerCard = new JLabel();
      playerCard.setHorizontalAlignment(JLabel.CENTER);//align
      p3.add(playerCard);
      //player's deck---------------------------
      playerHand = new JLabel();
      playerHand.setIcon(new ImageIcon("back.jpg"));//set as the back of a card
      playerHand.setHorizontalAlignment(JLabel.CENTER);//align
      p3.add(playerHand);


      // add panels to JFrame              
      add(p1);
      add(p2);
      add(p3);
     
      
   }
   /**
      Universal button
      handles all the input for the GUI
   */
   class ButtonListener implements ActionListener
      {
      /**
         If the button is pressed do the next step
         The next step depends on what the button is currently diplaying and goes from there
      */
      public void actionPerformed (ActionEvent e) 
      {
         if (playButton.getText() == "PLAY" || playButton.getText() == "PLAY NEXT CARD")
         {
            genMessage.setText(game.play());//Tie, You Win!, or The computer won.
         
            compCard.setIcon(new ImageIcon(game.getCompCard()));//set the images of the card 
            playerCard.setIcon(new ImageIcon(game.getPlayerCard()));//set the images of the card
              
            playButton.setText("Okay");//change button to okay
         

         }
         else if (playButton.getText() == "Okay")
         {
            if ((genMessage.getText()).equals("Tie"))
            {
               genMessage.setText("War! Put card face down.");
               compCard.setIcon(new ImageIcon("back.jpg"));//set a new card face down 
               playerCard.setIcon(new ImageIcon("back.jpg"));//set a new card face down 
            }
            else if ((genMessage.getText()).equals("You Won!"))
            {
               genMessage.setText("Cards go to you!");
               compCard.setIcon(null);//move card to pile - remove image of current card
               playerCard.setIcon(null);//move card to pile - remove image of current card
            }
            else 
            {            
               genMessage.setText("Cards go to the computer");
               compCard.setIcon(null);//move card to pile - remove image of current card
               playerCard.setIcon(null);//move card to pile - remove image of current card
            }
            
            
            playButton.setText("PLAY NEXT CARD");//change button to PLAY NEXT CARD
         
            compNum.setText(Integer.toString(game.sizeCompHand()));//update # of cards in deck
            playerNum.setText(Integer.toString(game.sizePlayersHand()));//update # of cards in deck
                     
            if ((game.sizeCompHand()) == 0)//computer ran out of cards
            {
               compHand.setIcon(null);//remove picture of the deck bc it's gone
               genMessage.setText("Congratulations, You Won!");
               playButton.setText("PLAY AGAIN?");
            }
            else if (game.sizePlayersHand() == 0)//you ran out of cards
            {
               playerHand.setIcon(null);//remove picture of your deck bc it's gone
               genMessage.setText("Game Over. You lost.");
               playButton.setText("PLAY AGAIN?");
            }

            
         }
         //RESET
         else//genMessage = PLAY AGAIN?
         {
            //create new game
            game = new War();
            
            //reset texts
            genMessage.setText("Game of War");
            playerNum.setText(Integer.toString(game.sizePlayersHand()));
            compNum.setText(Integer.toString(game.sizePlayersHand()));
            playButton.setText("PLAY");

            //reset cards
            playerHand.setIcon(new ImageIcon("back.jpg"));
            compHand.setIcon(new ImageIcon("back.jpg"));
            
         }
           
      }
   }


}