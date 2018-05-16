
import java.util.Scanner;
import java.io.*;

public class Sudoku {

    private int[][] matrix;
        // The puzzle is stored in a 9x9 matrix.
        // Zeros indicate cells that don't yet have a value
        
    //////////////////////////////////////////////////////////////////////////////////////////
    // Read the puzzle from a text file
    public Sudoku(String fileName) throws IOException {
        Scanner fileReader = new Scanner(new File(fileName));
        
        // Read the puzzle
        matrix = new int[9][9];
        for (int i = 0; i < 9; i++)                   // 9 rows
            for (int j = 0; j < 9; j++)               // 9 columns per row
                matrix[i][j] = fileReader.nextInt();
                
        fileReader.close();
    }
      
    //////////////////////////////////////////////////////////////////////////////////////////
    // Return a string representation of the puzzle.
    // Use spaces rather than zeros.
    public String toString(){
    	String str = "\n";
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (matrix[i][j] != 0)
                	str += matrix[i][j] + " ";
                else
                    str += "  ";
                if (j == 2 || j == 5)
                	str += "| ";
            }
            str += "\n";
            if (i == 2 || i == 5)
            	str += "---------------------\n";
        }
        str += "\n";
        return str;    	
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    // Return the number of unfilled cells, i.e., those that contain zero
    public int countNumberOfZeros(){
    	
    	int count = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) 
                 if (matrix[i][j] == 0) 
                 	count++;
        return count;
        
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // Rule 1: 
    //   Fill in all blank entries that admit of a single possibility.
    //   Repeat until there are no further changes
    public void rule1(){
    	
        // Apply this rule until there is a complete pass through the matrix
        // without changing any of the cells.
        boolean done = false;
        while (!done){
            done = true;
            
            // Traverse the puzzle row by row and column by column
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){ 
                	
                	// If a cell hasn't been resolved (contains zero), then set it to the unique value
                	// that goes in the cell. If there is more than one value possible, don't
                	// change the cell.
                    if (matrix[i][j] == 0){
                        int value = findUniqueValueFor(i, j);
                        if (value != 0){
                            matrix[i][j] = value;
                            done = false;
                        } 
                    }
                }
            }
        }  	
	    
    }
    
    // Return  the unique value that satisfies cell [i][j] or 0 if there is none.
    private  int findUniqueValueFor(int i, int j){
    
        int value = 0;
        
        // Try each of the candidate values
        for (int v = 1; v <= 9; v++){
        	
            if (probeIsOkay(v, i, j)){ // If the value doesn't causes a conflict then
                if (value == 0)        //   If this is the first value that works,
                    value = v;         //     use it.
                else                   //   Else there is more than one possible value
                    return 0;          //     so return 0
            }
        }
        return value;                  // Return the unique value
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    // Rule 2:
    //   Consider each row.
    //     Consider each number missing from the row.
    //       If the number can go in only one place within the row, put it there.
    //   Repeat until there are no further changes
    public void rule2(){
    	
        // Apply this rule until there is a complete pass through the matrix
        // without changing any of the cells.
        boolean done = false;
        while (!done){
            done = true;
            
            // For each row try each of the candidate values
            for (int i = 0; i < 9; i++){
                for (int v = 1; v <= 9; v++){
                	// If the value can be placed in exactly one cell in the row,    
                	// then use it
                    int j = findUniqueEmptyColumnFor(v, i);
                    if (j != -1){
                        matrix[i][j] = v;
                        done = false;
                    }
                }
            }	
        }
        
	}

    // Find the unique cell in a row that can be set to the probe value (if there is one)
    private  int findUniqueEmptyColumnFor(int probe, int i){
    
        int col = -1;
        for (int j = 0; j < 9; j++){
            if (probe == matrix[i][j])
                return -1;
            if (matrix[i][j] != 0)
            	continue;
            if (probeIsOkay(probe, i, j))
                if (col == -1)
                    col = j;
                else
                    return -1;
        }
        return col;
        
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // Rule 3:
    //   Consider each column.
    //     Consider each number missing from the column.
    //       If the number can go in only one place within the column, put it there.
    //   Repeat until there are no further changes
    public void rule3(){
        boolean done = false;
        while (!done){
            done = true;
            for (int j = 0; j < 9; j++){
                for (int v = 1; v <= 9; v++){
                    int i = findUniqueEmptyRowFor(v, j);
                    if (i != -1){
                        matrix[i][j] = v;
                        done = false;
                    }
                }
            }	
        }
	}

    private  int findUniqueEmptyRowFor(int probe, int j){
        int row = -1;
        for (int i = 0; i < 9; i++){
            if (probe == matrix[i][j])
                return -1;
            if (matrix[i][j] != 0)
            	continue;
            if (probeIsOkay(probe, i, j))
                if (row == -1)
                    row = i;
                else
                    return -1;
        }
        return row;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // Rule 4
    //   Consider each box.
    //     Consider each number missing from the box.
    //       If the number can go in only one place within the box, put it there.
    //   Repeat until there are no further changes
    public void rule4(){
        boolean done = false;
        while (!done){
            done = true;
            for (int bi = 0; bi < 3; bi++)
            	for (int bj = 0; bj < 3; bj++)
            		for (int v = 1; v <= 9; v++){
            			int[] ijLocation = findUniqueEmptyCellFor(v, bi, bj);
            			if (ijLocation[0] != -1){
            				matrix[ijLocation[0]][ijLocation[1]] = v;
            				done = false;
            			}
            		}
        }
	}

    private  int[] findUniqueEmptyCellFor(int probe, int bi, int bj){
    	int[] location = {-1, -1};
    	for (int i = bi * 3; i < bi * 3 + 3; i++)
    		for (int j = bj * 3; j < bj * 3 + 3; j++){
    			if (probe == matrix[i][j]){
    				location[0] = -1;
    				location[1] = -1;
    				return location;
    			}
    			if (matrix[i][j] != 0)
    				continue;
    		    if (probeIsOkay(probe, i, j))
    		    	if (location[0] == -1){
    		    		location[0] = i;
    		    		location[1] = j;
    		    	}else{
    				    location[0] = -1;
    				    location[1] = -1;
    				    return location;
    		    	}
    				
    		}
    	return location;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // Determine if a particular value can be placed in a particular cell
    private  boolean probeIsOkay(int probe, int i, int j){
    // Pre     -- none
    // Post    -- no change
    // Returns -- true if matrix[i][j] can be set to probe else false
    
        // Check row i for conflicts
        for (int jj = 0; jj < 9; jj++)
            if (jj != j){
                if (probe == matrix[i][jj])
                    return false;
            }
        
        // Check column j for conflicts
        for (int ii = 0; ii < 9; ii++)
            if (ii != i){
                if (probe == matrix[ii][j])
                    return false;
            }
        
        // Check box containing [i][j] for conflicts
        int topLeftRow = i - i%3;
        int topLeftColumn = j - j%3;
        for (int ii = topLeftRow; ii < topLeftRow + 3; ii++)
            for (int jj = topLeftColumn; jj < topLeftColumn + 3; jj++)
                if (ii != i || jj != j){
                    if (probe == matrix[ii][jj])
                        return false;
                }
                
        // There are no conflicts
        return true;
    }   
}