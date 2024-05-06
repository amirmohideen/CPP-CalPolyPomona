public class Course {
  private String courseName;
  private Instructor instructor;
  private Textbook textbook;

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setTextbook(Textbook textbook) {
    this.textbook = textbook;
  }

  public Textbook getTextbook() {
    return textbook;
  }

  public void printCourseInfo() {
    System.out.println("\nCourse Name: " + courseName);
    System.out.println("\nInstructor Name: " + instructor.getInstructorFirstName() + " " + instructor.getInstructorLastName());
    System.out.println("Office Number: " + instructor.getOfficeNumber());
    System.out.println("\nTextbook Title: " + textbook.getTitle());
    System.out.println("Author: " + textbook.getAuthor());
    System.out.println("Publisher: " + textbook.getPublisher());
  }

}