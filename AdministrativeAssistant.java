/*
Author: Tyler Kass 36910537
Description: Administrative class has a parameterized constructor to store hours, salary, and name. It sets hoursper week
gets the hours as well as pays out the Administrative Assistant Employees. We have three methods, which give a raise,
as well as settings hoursper to hours changed.
 */
public class AdministrativeAssistant extends Employee implements Hourly
{
    int hoursPer;

    AdministrativeAssistant(int hours, double salary, String name) {
        this.name = name;
        this.salary = salary;
        hoursPer = hours;
    }

    // Getters / Setters
    public void setHoursPer(int hoursPer) {
        this.hoursPer = hoursPer;
    }

    public int getHoursPer() {
        return hoursPer;
    }
    @Override
    public void getPaid() {
        cash = cash + salary * 2 * hoursPer;
    }


    // Methods
    @Override
    public int hoursWorked() {
        return 0;
    }

    public void hoursChanged(int hours) {
        this.hoursPer = hours;
    }
    @Override
    public void giveRaise(double raisePercentage) {
        salary = salary + raisePercentage;
    }
}
