import java.util.Scanner;
import java.util.Random;

public class PlayTTT{

   public static void main(String[]args){
   	
   	  // Instantiate a keyboard scanner and a board
      Scanner reader = new Scanner(System.in);
      TTTBoard board = new TTTBoard();
      
      // Display the empty board
      System.out.println(board);

      // Randomly decide who goes first
      Random gen = new Random();
      char player;
      if (gen.nextInt(2) == 1)
         player = 'O';
      else
      	 player = 'X';

      // Loop while there is no winner and the board is not full 
      while (board.getWinner() == '-' && !board.full()){
      	
      	 // Prompt the user for a move
         System.out.println(player + "'s turn");
         System.out.print("Enter the row and column[1-3, space, 1-3]: ");
         
         // Read the move
         int row = reader.nextInt();
         int column = reader.nextInt();
         
         // Attempt the move
         // If the move is illegal
         //    display an error message
         // Else
         //    display the board and switch players
         boolean success = board.placeXorO(player, row, column);
         if (!success)
            System.out.println("Error: cell already occupied!");
         else{
            System.out.println(board);
            if (player == 'X')
               player = 'O';
            else            
               player = 'X';
         }

      }
      
      // Display the results 
      char winner = board.getWinner();
      if (winner != '-')
         System.out.println(winner + "s win!");
      else
      	System.out.println("It's a draw!");
   }
} 
