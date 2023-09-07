/*
CSC 205: # 11210 / M 5:20 - 7:00 PM
Program #1
Author: Tyler Kass 36910537
Description: We start with three global variables, and then three getters for name, salary, and cash. We also have
two methods one abstract that we need to implement. The other one is getPaid.
 */
public abstract class Employee {
    // Variables
     double salary, cash;
     String name;

    // Getters
    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    public double getCash() {
        return cash;
    }

    // Methods
    public void getPaid() {
       cash = cash + (salary / 26);
    }

    public abstract void giveRaise(double raisePercentage);

}

