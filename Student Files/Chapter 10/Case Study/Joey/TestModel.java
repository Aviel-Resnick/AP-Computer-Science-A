// Case Study 10.1: Tester program for TestScoresModel

public class TestModel{

   public static void main (String[] args){

      // Create and display empty model
      TestScoresModel model = new TestScoresModel();
      System.out.println("This is a model" + model);

      // Display size, current position, and current student
      System.out.println("This is model size" + model.size());
      System.out.println(model.currentPosition());
      System.out.println(model.currentStudent());

      // Add and display 3 students
      for (int i = 1; i <= 3; i++){
         Student s = new Student("S" + i);
         model.add(s);
      }
      System.out.println("This is the new model" + model);

      // Move to first student and display it
      System.out.println("This is the first student " + model.first());

      // Move to next and previous and display them
      System.out.println("This is the next " +model.next());
      System.out.println(model.previous());

      // Move to last and next and display them
      System.out.println(model.last());
      System.out.println(model.next());

      // Display size, current position, and current student
      System.out.println(model.size());
      System.out.println(model.currentPosition());
      System.out.println(model.currentStudent());

      // Replace current student and display the model
      int[] grades = {99, 88, 77};
      Student newStudent = new Student("Beth", grades);
      model.replace(newStudent);
      System.out.println(model);

      // Add more students and display results
      for (int i = 6; i <= 13; i++){
         Student s = new Student("S" + i);
         System.out.println(model.add(s));
      }
   }
}

