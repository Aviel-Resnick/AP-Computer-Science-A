import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;



public class Test {

	 private static FileInputStream inFile;
	 private static InputStreamReader inReader;
	 private static  BufferedReader reader;

	 private static Random rand = new Random();

	 private static List<Student> classroom = new ArrayList<Student>(); // ArrayList to store the classroom.

		  public static void main (String args[]) throws IOException
		  {
		    initFile();
		    getData();
		    //System.out.print(classroom);  //output of the complete class.

			Scanner reader = new Scanner(System.in);
			System.out.print("Enter 1 for Quick Sort; 2 for Merge Sort: ");
			int sortingAlgorithm = reader.nextInt();

		    if (sortingAlgorithm == 1) {
				quickSort(classroom); // sorts the classroom
			}

			else if (sortingAlgorithm == 2) {
				mergeSort(classroom);
			}
			//System.out.println("------------------------------------------------");
		    System.out.print(classroom); //output after sorting.
		    inFile.close();

		  }

		 // preparing the file for input

		  public static void initFile() throws IOException
		  {
		    inFile = new FileInputStream ("./truefalse.txt");
		    inReader = new InputStreamReader(inFile);
		    reader = new BufferedReader(inReader);
		  }


		  //  Separate the id from the answers and store the answers in an array.

		  public static void getData() throws IOException
		  {
		    String line = reader.readLine();  //Seed

		    String[] answerkey = new String[10];  //Store the answer key from the first line of the txt file.

		    for(int i=0; i<answerkey.length; i++){ // take that line and place each answer in an array.

		    	answerkey[i]=line.substring(i,i+1);
		    }

		    line = reader.readLine();    // read the following line of the txt file.


		    while(line != null)   // Read and create a student for each line.
		    {
		      String[] answers = new String[10];
		      StringTokenizer strTkn = new StringTokenizer(line);
		      String id = strTkn.nextToken();
		      String answerline = strTkn.nextToken();


		      for(int i=0; i<answers.length; i++){

		    	  answers[i]=answerline.substring(i, i+1);

		      }

		      Student stu = new Student(id,answers);

		      stu.grade(answerkey, answers);

		      classroom.add(stu);




		      line = reader.readLine();   //updating what is being read

		    }

		  }


		  // In this method you should sort the classroom using quickSort
		  public static List<Student> quickSort(List<Student> stu){

			  // Of course check if stu is more than just one element (else its already sorted)
			  if (stu.size() <= 1) {
				  return stu;
			  }

			  // Pick a random pivot point
			  int pivot = rand.nextInt(stu.size());
			  Student rotation = stu.get(pivot);
			  stu.remove(pivot);

			  // Split the array into a temp left and right half
			  List<Student> lower = new ArrayList<Student>();
			  List<Student> higher = new ArrayList<Student>();

			  // Comparison of elements
			  for (int i = 0; i < stu.size(); i++) {
				  if (stu.get(i).getScore() <= rotation.getScore())
					  lower.add(stu.get(i));
				  else
					  higher.add(stu.get(i));

			  }

			  // who said recursion isn't used in sorting
			  quickSort(lower);
			  quickSort(higher);

			  // Recreate the array
			  stu.clear();
			  stu.addAll(lower);
			  stu.add(rotation);
			  stu.addAll(higher);

			  return stu;

		}

		// In this method you should sort the classroom using mergeSort
		public static List<Student> mergeSort(List<Student> stu) {
		    List<Student> left = new ArrayList<Student>();
		    List<Student> right = new ArrayList<Student>();
		    int center;

		    if (stu.size() == 1) {
		        return stu;
		    }

			else {
				// Split into two halves
				center = stu.size() / 2;

		        // Create the left half
		        for (int i = 0; i < center; i++) {
					left.add(stu.get(i));
		        }

		        // Create the right half
		        for (int i=center; i<stu.size(); i++) {
					right.add(stu.get(i));
		        }

		        // Sort the left and right halves <-- recursion
		        left  = mergeSort(left);
		        right = mergeSort(right);

		        // Merge the parts back.
		        merge(left, right, stu);
		    }
		    return stu;
		}

		private static void merge(List<Student> left, List<Student> right, List<Student> stu) {
		    int leftIndex = 0;
		    int rightIndex = 0;
		    int stuIndex = 0;

		    // Keep chunking each part, and then put them together

		    while (leftIndex < left.size() && rightIndex < right.size()) {
		        if (left.get(leftIndex).getScore() < right.get(rightIndex).getScore()) {
		            stu.set(stuIndex, left.get(leftIndex));
		            leftIndex++;
		        }

				else {
		            stu.set(stuIndex, right.get(rightIndex));
		            rightIndex++;
		        }
		        stuIndex++;
		    }

		    List<Student> remaining;
		    int remainingIndex;

		    if (leftIndex >= left.size()) {
		        // The left half is done
		        remaining = right;
		        remainingIndex = rightIndex;
		    }

			else {
		        // The right half is done
		        remaining = left;
		        remainingIndex = leftIndex;
		    }

		    // Copy the remaining half
		    for (int i = remainingIndex; i < remaining.size(); i++) {
		        stu.set(stuIndex, remaining.get(i));
		        stuIndex++;
		    }
		}
}
