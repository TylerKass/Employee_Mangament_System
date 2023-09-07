/*
Author: Tyler Kass
Description: We have three abstract methods that we need to implement.
 */
public interface Hourly {
    public int hoursWorked();

    public void hoursChanged(int hours);

    public void giveRaise(double increasePay);
}
