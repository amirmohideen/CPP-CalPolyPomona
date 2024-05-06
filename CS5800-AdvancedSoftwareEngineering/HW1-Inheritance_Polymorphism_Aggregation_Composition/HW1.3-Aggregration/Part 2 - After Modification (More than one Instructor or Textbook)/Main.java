public class Main {
  public static void main(String[] args) {

    Instructor instructor1 = new Instructor();
    instructor1.setInstructorFirstName("Nima");
    instructor1.setInstructorLastName("Davarpanah");    
    instructor1.setOfficeNumber("3-2636");

    Instructor instructor2 = new Instructor();
    instructor2.setInstructorFirstName("Amir");
    instructor2.setInstructorLastName("Mohideen");    
    instructor2.setOfficeNumber("1-1111");
    
    Textbook textbook1 = new Textbook();
    textbook1.setTitle("Clean Code");
    textbook1.setAuthor("Robert Martin");
    textbook1.setPublisher("Prentice Hall");

    Textbook textbook2 = new Textbook();
    textbook2.setTitle("History of CPP");
    textbook2.setAuthor("ASI");
    textbook2.setPublisher("CPP");

    Course course = new Course();
    course.setCourseName("Advanced Software Engineering");
    
    course.addInstructor(instructor1);
    course.addInstructor(instructor2);
    course.addTextbook(textbook1);
    course.addTextbook(textbook2);
    course.printCourseInfo();

  }
}