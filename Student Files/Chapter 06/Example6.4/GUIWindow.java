// Example 6.4: Tracks position of the mouse in a panel

import javax.swing.*;
import java.awt.*;

public class GUIWindow{

   public static void main(String[] args){
      JFrame theGUI = new JFrame();
      theGUI.setTitle("GUI Program");
      theGUI.setSize(300, 200);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ColorPanel panel = new ColorPanel(Color.white);
      Container pane = theGUI.getContentPane();
      pane.add(panel);
      theGUI.setVisible(true);
   }
}