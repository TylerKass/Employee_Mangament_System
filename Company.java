/*
Author: Tyler Kass
Description: We start off with a menu method that prints out the menu. We then go into main to use all of our
other classes. We go to a do while loop like in MiniLab 2. Which then through all of our options. Option A adds an employee.
If you go above 5 employees the entire program quits and throws an exception because you've added to many employees.
b. Lists the employees along with the salary or hourly wage along with what kind of employee they are. C gives
whatever employee you choose a raise. d gives paychecks to all employees. e you can change the hours of the hourly employees.
If you choose a non-hourly employee it will say no employee found. g quits along with a print message saying bye!
 */

import java.util.*;

public class Company {

    public static void menu() {
        System.out.println("What do you want to do?");
        System.out.println("a. Add an Employee ");
        System.out.println("b. List all Employees ");
        System.out.println("c. Give an Employee a raise");
        System.out.println("d. Give Paychecks ");
        System.out.println("e. Change someone’s hours ");
        System.out.println("f. Fire an Employee ");
        System.out.println("g. Quit ");
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Company.menu();
        char userInput = scnr.next().toLowerCase().charAt(0);

        // Employee array + number of employees to start
        Employee[] employee = new Employee[5];
        int countEmployees = 0;

        // Hourly array uses Administrative because the objects are implemented by hourly and extends Employee
        AdministrativeAssistant[] hourly = new AdministrativeAssistant[5];
        int countHourly = 0;

        do {
            if (userInput == 'a' || userInput == 'A') {
                // Checks to see if the array is already full
                if (countEmployees >= 5) {
                    throw new IllegalArgumentException("Maximum number of employees hired");
                }

                // Grabbing userName
                System.out.println("What is their name?");
                scnr.nextLine();
                String userName = scnr.nextLine();

                // Seeing if they are yearly or hourly
                System.out.println("What is their salary (yearly or hourly)");
                double salary = scnr.nextDouble();
                System.out.println("Are they an hourly worker? (Y/N)");
                char empHourly = scnr.next().charAt(0);

                // Conditional for the Y/N
                if (empHourly == 'Y' || empHourly == 'y') {
                    System.out.println("How many hours per week do they work?");
                    int hoursPer = scnr.nextInt();

                    // Storing the data into the parametrized constructor objects employee1 and AdministrativeAssistant object while upping the count.
                    Employee employee1 = new AdministrativeAssistant(hoursPer, salary, userName);
                    AdministrativeAssistant administrativeAssistant = new AdministrativeAssistant(hoursPer, salary, userName);
                    hourly[countHourly++] = administrativeAssistant;
                    employee[countEmployees++] = employee1;
                    System.out.println(userName + " was hired!");

                }
                // storing the data into a parameterized constructor object and then upping the count
                if (empHourly == 'N' || empHourly == 'n') {
                    Employee employee1 = new SoftwareEngineer(userName, salary);
                    employee[countEmployees++] = employee1;
                    System.out.println(userName + " was hired!");

                }
            }

            if (userInput == 'b' || userInput == 'B') {

                if (countEmployees == 0) {
                    throw new IllegalArgumentException("Nobody works here!");
                } else {
                    // For loop with the Employee class to use the elements in the employee array
                    for (int i = 0; i < countEmployees; i++) {
                        Employee employee1 = employee[i];
                        if (employee1 == null) break;
                        // Conditional to differentiate between the Software Engineer Class VS Administrative Assistant Class using instanceOf
                        if (employee1 instanceof SoftwareEngineer) {
                            System.out.println(employee1.getName() + " Salary: " + employee1.getSalary() + " Cash: " + employee1.getCash() + " Software Engineer");
                        }
                        if (employee1 instanceof AdministrativeAssistant) {
                            System.out.println(employee1.getName() + " Hourly Wage: " + employee1.getSalary() + " Cash: " + employee1.getCash() + " Administrative Assistant");
                        }
                    }
                }
            } else if (userInput == 'c' || userInput == 'C') {
                if (countEmployees == 0) {
                    throw new IllegalArgumentException("Nobody works here!");
                }
                // Input for whom to give the raise to
                System.out.println("Who do you want to give a raise to?");
                scnr.nextLine();
                String userName = scnr.nextLine();

                // boolean to make sure that the name has a match if not it stays false and prints the else if statement
                boolean match = false;

                // For loop to traverse the number of employees, and then an if statement to check if the name given is in the array
                //Then you would add the raise into the giveRaise method, with the input and then print the name is happy.
                for (int i = 0; i < countEmployees; i++) {

                    Employee employee1 = employee[i];

                    if (employee1 != null && employee1.getName().equals(userName)) {
                        match = true;
                        System.out.println("What raise do you want to give them?");
                        double raiseAmount = scnr.nextDouble();

                        employee1.giveRaise(raiseAmount);

                        System.out.println(employee1.getName() + " is happy!");
                    }
                }
                if (!match) {
                    System.out.println("No employee with name: " + userName + " is found!");
                }

            } else if (userInput == 'd' || userInput == 'D') {
                if (countEmployees == 0) {
                    throw new IllegalArgumentException("Nobody works here!");
                }
                // Traverse the array and give each of them a raise
                for (int i = 0; i < countEmployees; i++) {
                    Employee employee1 = employee[i];
                    if (employee1 == null)
                        break;
                    employee1.getPaid();
                }
                System.out.println("Hooray for money!");
            } else if (userInput == 'e' || userInput == 'E') {
                if (countEmployees == 0) {
                    throw new IllegalArgumentException("Nobody works here!");
                }
                // Initial questions + input for name
                System.out.println("Change hours for who?");
                scnr.nextLine();
                String userName = scnr.nextLine();

                boolean match = false;
                // for loop for the array hourly and then a conditional to check if the username equals any of the employees in the array.
                // It will then get the hours per week currently and then ask what you would like to change it to and then print out the change
                for (int i = 0; i < countHourly; i++) {
                    // using the hourly array and administrative object for the conditionals.
                    AdministrativeAssistant administrativeAssistant = hourly[i];


                    if (administrativeAssistant != null && userName.equals(administrativeAssistant.getName())) {
                        match = true;
                        System.out.println(userName + " currently works " + administrativeAssistant.getHoursPer() + " per week. What would you like to change it to?");
                        int hoursChanged = scnr.nextInt();
                        administrativeAssistant.setHoursPer(hoursChanged);
                        System.out.println(userName + " will now work for " + hoursChanged + " hours per week");
                    }
                    if (!match) {
                        System.out.println("No employee with the name inputted is hourly!");
                    }
                }
            }

            else if (userInput == 'f' || userInput == 'F') {
                if (countEmployees == 0) {
                    throw new IllegalArgumentException("Nobody works here!");
                }
                // Initial question + the input for name
                System.out.println("Who would you like to fire?");
                scnr.nextLine();
                String userName = scnr.nextLine();

                boolean match = false;
                for (int i = 0; i < countEmployees; i++) {
                    Employee employee1 = employee[i];
                    AdministrativeAssistant administrativeAssistant = hourly[i];
                    if (employee1 != null && employee1.getName().equalsIgnoreCase(userName)) {
                        match = true;
                        System.out.println("What is the reason you'd like to fire this employee? ");
                        String reason = scnr.nextLine();

                        for (int j = 1; j < countEmployees - 1; j++) {
                            employee[j] = employee[j + 1];
                        }
                        countEmployees--;

                        System.out.println(employee1.getName() + " has been fired. Reason: " + reason);
                        break;
                    }
                    else if (administrativeAssistant != null && administrativeAssistant.getName().equalsIgnoreCase(userName)) {
                        match = true;
                        System.out.println("What is the reason you'd like to fire this administrative assistant? ");
                        String reason = scnr.nextLine();

                        for (int j = 1; j < countHourly - 1; j++) {
                            hourly[j] = hourly[j + 1];
                        }
                        countHourly--;

                        System.out.println(administrativeAssistant.getName() + " has been fired. Reason: " + reason);
                        break;
                    }
                }
                if (!match) {
                    System.out.println("No employee with name: " + userName + " is found!");
                }
            }
            // Bottom two cases where it prints bye if g is chosen, and if no correct inputs are chose then invalid option appears
            if (userInput == 'g' || userInput == 'G') {

            }
            // makes sure that any other option can not be used
            if (userInput != 'a' && userInput != 'b' && userInput != 'c' && userInput != 'd' && userInput != 'e' && userInput != 'f' && userInput != 'g') {
                System.out.println("Invalid option");
            }
            menu();
            userInput = scnr.next().toLowerCase().charAt(0);
        } while (userInput != 'g' || userInput != 'G');
        System.out.println("Bye!");
    }
}
