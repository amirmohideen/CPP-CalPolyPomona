import java.util.ArrayList;
import java.util.List;

public class Course {
  private String courseName;
  private ArrayList<Instructor> instructors = new ArrayList<>();
  private ArrayList<Textbook> textbooks = new ArrayList<>();

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setInstructor(ArrayList<Instructor> instructors) {
    this.instructors = instructors;
  }

  public ArrayList<Instructor> getInstructors() {
    return instructors;
  }

  public void addInstructor(Instructor instructor) {
    this.instructors.add(instructor);
  }

  public void setTextbook(ArrayList<Textbook> textbooks) {
    this.textbooks = textbooks;
  }

  public ArrayList<Textbook> getTextbooks() {
    return textbooks;
  }

  public void addTextbook(Textbook textbook) {
    this.textbooks.add(textbook);
  }

  public void printCourseInfo() {
    System.out.println("\nCourse Name: " + this.courseName);

    instructors.forEach(instructor -> {
      System.out.println("\nInstructor Name: " + instructor.getInstructorFirstName() + " " + instructor.getInstructorLastName());
      System.out.println("Office Number: " + instructor.getOfficeNumber());
    });

    textbooks.forEach(textbook -> {
      System.out.println("\nTextBook Title: " + textbook.getTitle());
      System.out.println(" Author: " + textbook.getAuthor());
      System.out.println(" Publisher: " + textbook.getPublisher());
    });
  }

}