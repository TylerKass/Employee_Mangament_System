/*
CSC 205: # 11210 / M 5:20 - 7:00 PM
Program #1
Author: Tyler Kass 36910537
Description: This class, extends employee with a parameterized constructor that stores, name and salary.
We also have a giveRaise method, that gives the software engineer employees a raise.
 */
public class SoftwareEngineer extends Employee {
    public SoftwareEngineer(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.cash = 0;
    }

    public void giveRaise(double percentageRaise) {
        salary = salary + (salary * percentageRaise / 100);
    }
}
