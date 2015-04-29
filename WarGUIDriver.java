/**
   Cody Leaf
   CS 110
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WarGUIDriver
{
   public static void main(String [] args) 
   {
      JFrame frame = new MyFrame("War");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

   }
}
