
/******************************************************************
* CS21 - Java Programming
* Author: Alex Soto
* Assignment: Project 2
* Instructor: Prof. Kyle Muldrow
*
* Name of class: replace with actual name of class
*******************************************************************
*/

import java.util.Scanner;
public class projectTwo
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current temperature (F): ");
        double temperature = scanner.nextDouble();

        int maxWindSpeed = getVelocity(scanner);

        System.out.println("\nCurrent Temp\tWind Speed\tWind Chill Factor\tFeels Like");
        System.out.println("--------------------------------------------------------------------");

        for (int windSpeed = 1; windSpeed <= maxWindSpeed; windSpeed++) { 
            double windChill = calculateWindChill(temperature, windSpeed);
            int feelsLikeTemperature = (int) Math.round(windChill);
            System.out.printf("%6.1f F\t%4d MPH\t%16.2f\t%8d F\n", temperature, windSpeed, windChill, feelsLikeTemperature);
        }
    }

    public static int getVelocity(Scanner scanner) {
        int windVelocity;
        do {
            System.out.print("Enter the maximum wind velocity (speed) between 1 and 50 (MPH): ");
            windVelocity = scanner.nextInt();
            if (windVelocity < 1 || windVelocity > 50) {
                System.out.println("Invalid value. Please try again.");
            }
        } while (windVelocity < 1 || windVelocity > 50);

        return windVelocity;
    }

    public static double calculateWindChill(double temperature, int windSpeed) {
        return 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
    }

}