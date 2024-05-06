public class SalariedEmployee extends Employee {
  private int weeklySalary;

  public SalariedEmployee() {
    super();
    this.weeklySalary = 0;
  }

  public void setWeeklySalary(int weeklySalary) {
    this.weeklySalary = weeklySalary;
  }

  public int getWeeklySalary() {
    return weeklySalary;
  }
}