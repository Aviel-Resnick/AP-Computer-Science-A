public class TTTBoard{

   private char[][] board;   // The tic-tac-toe board
   
   // Instantiate an empty board
   public TTTBoard(){
      board = new char[3][3];
      reset();
   }
   
   // Reset the board to empty
   public void reset(){
      for (int row = 0; row < 3; row++)
         for (int column = 0; column < 3; column++)
            board[row][column] = '-';
   }   
   	
   // Return a string representation of the board
   public String toString(){
      String result = "\n";
      for (int row = 0; row < 3; row++){
         for (int column = 0; column < 3; column++)
            result += board[row][column] + " ";
         result += "\n";
      }
      return result;
   }
   
   // If the move is legal, make it and return true, else return false
   public boolean placeXorO(char s, int row, int column){
      if (board[row - 1][column - 1] == '-'){
         board[row - 1][column - 1] = s;
         return true;
      }else
         return false;
   }
         
   // Return true if the board is full else return false
   public boolean full(){
      for (int row = 0; row < 3; row++)
      	for (int column = 0; column < 3; column++)
      		if (board[row][column] == '-')
      			return false;
      return true;
   }

   // Return '-' if there is no winner, else return 'X' or 'O'
   public char getWinner(){
   	
   	  // Each triple represents the current content of a row,
   	  // column, or diagonal
      String[] triples = new String[8];     
                                             
      // Obtain the current content of the three rows                                     
      for (int column = 0; column < 3; column ++)
         triples[column] = getColumn(column);
         
      // Add in the content of the three columns
      for (int row = 0; row < 3; row ++)
         triples[3 + row] = getRow(row);
         
      // Add in the two diagonals
      triples[6] = getDiagonal(0);
      triples[7] = getDiagonal(2);
      
      // If any triple equal "XXX", then
      //    return 'X'
      // Else if any triple equals "OOO" then 
      //    return 'O'
      // Else
      //    return '-'
      for (int i = 0; i < 8; i++)
         if ("XXX".equals(triples[i]))
            return 'X';
         else if ("OOO".equals(triples[i]))
         	return 'O';
      return '-';
   }
   
   // Return the content of a column
   private String getColumn(int column){
      String result = "";
      for (int row = 0; row < 3; row++)
         result += board[row][column];
      return result;
   }
   
   // Return the content of a row
   private String getRow(int row){
      String result = "";
      for (int column = 0; column < 3; column++)
         result += board[row][column];
      return result;
   }
   
   // Return the content of a diagonal
   private String getDiagonal(int startRow){
      String result = "";
      if (startRow == 0)
         for (int i = 0; i < 3; i++)
            result += board[i][i];
      else
         for (int i = 0; i < 3; i++)
            result += board[2 - i][i];
      return result;
   }   
}
         
      
   
   
      
      