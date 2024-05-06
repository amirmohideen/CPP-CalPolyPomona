public class Main {
  public static void main(String[] args) {

    SalariedEmployee employee1 = new SalariedEmployee();
    employee1.setFirstName("Joe");
    employee1.setLastName("Jones");
    employee1.setSocialSecurityNumber("111-11-1111");
    employee1.setWeeklySalary(2500);

    HourlyEmployee employee2 = new HourlyEmployee();
    employee2.setFirstName("Stephanie");
    employee2.setLastName("Smith");
    employee2.setSocialSecurityNumber("222-22-2222");
    employee2.setWage(25);
    employee2.setHoursWorked(32);

    HourlyEmployee employee3 = new HourlyEmployee();
    employee3.setFirstName("Mary");
    employee3.setLastName("Quinn");
    employee3.setSocialSecurityNumber("333-33-3333");
    employee3.setWage(19);
    employee3.setHoursWorked(47);

    CommissionEmployee employee4 = new CommissionEmployee();
    employee4.setFirstName("Nicole");
    employee4.setLastName("Dior");
    employee4.setSocialSecurityNumber("444-44-4444");
    employee4.setCommissionRate(15);
    employee4.setGrossSales(50000);

    SalariedEmployee employee5 = new SalariedEmployee();
    employee5.setFirstName("Renwa");
    employee5.setLastName("Chanel");
    employee5.setSocialSecurityNumber("555-55-5555");
    employee5.setWeeklySalary(1700);

    BaseEmployee employee6 = new BaseEmployee();
    employee6.setFirstName("Mike");
    employee6.setLastName("Davenport");
    employee6.setSocialSecurityNumber("666-66-6666");
    employee6.setBaseSalary(95000);

    CommissionEmployee employee7 = new CommissionEmployee();
    employee7.setFirstName("Mahnaz");
    employee7.setLastName("Vaziri");
    employee7.setSocialSecurityNumber("777-77-7777");
    employee7.setCommissionRate(22);
    employee7.setGrossSales(40000);

    System.out.println("\nEmployee 1: " + employee1.getFirstName() + " " + employee1.getLastName() + " \nSSN: "
        + employee1.getSocialSecurityNumber() + " \nWeekly Salary: $" + employee1.getWeeklySalary());

    System.out.println("\nEmployee 2: " + employee2.getFirstName() + " " + employee2.getLastName() + " \nSSN: "
        + employee2.getSocialSecurityNumber() + " \nWage: $" + employee2.getWage() + " \nHours Worked: "
        + employee2.getHoursWorked());

    System.out.println("\nEmployee 3: " + employee3.getFirstName() + " " + employee3.getLastName() + " \nSSN: "
        + employee3.getSocialSecurityNumber() + " \nWage: $" + employee3.getWage() + " \nHours Worked: "
        + employee3.getHoursWorked());

    System.out.println("\nEmployee 4: " + employee4.getFirstName() + " " + employee4.getLastName() + " \nSSN: "
        + employee4.getSocialSecurityNumber() + " \nCommission Rate: %" + employee4.getCommissionRate()
        + " \nGross Sales: $" + employee4.getGrossSales());

    System.out.println("\nEmployee 5: " + employee5.getFirstName() + " " + employee5.getLastName() + " \nSSN: "
        + employee5.getSocialSecurityNumber() + " \nWeekly Salary: $" + employee5.getWeeklySalary());

    System.out.println("\nEmployee 6: " + employee6.getFirstName() + " " + employee6.getLastName() + " \nSSN: "
        + employee6.getSocialSecurityNumber() + " \nBase Salary: $" + employee6.getBaseSalary());

    System.out.println("\nEmployee 7: " + employee7.getFirstName() + " " + employee7.getLastName() + " \nSSN: "
        + employee7.getSocialSecurityNumber() + " \nCommission Rate: %" + employee7.getCommissionRate()
        + " \nGross Sales: $" + employee7.getGrossSales());
  }
}
