public class Employee {
  private String firstName;
  private String lastName;
  private String socialSecurityNumber;

  public Employee() {
    this.firstName = "";
    this.lastName = "";
    this.socialSecurityNumber = "";
  }

  public Employee(String firstName, String lastName, String socialSecurityNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getLastName() {
    return lastName;
  }

  public void setSocialSecurityNumber(String socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
  }
  
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

}