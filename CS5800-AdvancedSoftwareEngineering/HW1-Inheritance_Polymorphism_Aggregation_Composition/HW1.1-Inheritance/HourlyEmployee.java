public class HourlyEmployee extends Employee {
  private int wage;
  private int hoursWorked;

  public HourlyEmployee() {
    super();
    this.wage = 0;
    this.hoursWorked = 0;
  }

  public void setWage(int wage) {
    this.wage = wage;
  }

  public int getWage() {
    return wage;
  }

  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  public int getHoursWorked() {
    return hoursWorked;
  }
}