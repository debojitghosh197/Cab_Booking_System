/*
 * Cab-Booking system by Debojit...
 */

import java.util.Scanner;

import java.util.HashSet;

import java.util.Random;

interface TxiModel {
    void BookTaxi(int x);

    void MyDetails(String name, Long num, String address);

    void BookingStatus(int y);
}

class Taxi implements TxiModel {
    // Data members
    private String[] name = new String[100000];
    private String[][] pickupDropPoint = new String[100000][2];
    private double[][] distAmt = new double[100000][2];
    private int[] person = new int[100000];

    // Member methods

    /*
     * main-menu
     */
    @Override
    public void BookTaxi(int x) {
        System.out.println("Book a taxi");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char letter = (char) (random.nextInt(26) + 'a'); // 'a' to 'z'
        int bookingId = random.nextInt(1000, 9999);

        System.out.println("Enter your name: ");
        name[x] = sc.nextLine();
        System.out.println("Your booking ID is: " + letter + bookingId);
        System.out.println("Pickup point: ");
        pickupDropPoint[x][0] = sc.nextLine();
        System.out.println("Drop point: ");
        pickupDropPoint[x][1] = sc.nextLine();
        System.out.println("Enter the distance in (KM): ");
        distAmt[x][0] = sc.nextDouble();
        System.out.println("Enter the number of persons: ");
        person[x] = sc.nextInt();

        if (distAmt[x][0] <= 5) {
            distAmt[x][1] = 100;
        } else if (distAmt[x][0] <= 15) {
            distAmt[x][1] = 100 + 10.5 * (distAmt[x][0] - 5);
        } else if (distAmt[x][0] <= 25) {
            distAmt[x][1] = 100 + 100 + 8.5 * (distAmt[x][0] - 15);
        } else if (distAmt[x][0] > 25) {
            distAmt[x][1] = 100 + 100 + 80 + 5.5 * (distAmt[x][0] - 25);
        }
    }

    /*
     * view-status
     */

    @Override
    public void MyDetails(String name, Long num, String address) {
        System.out.println("************View my details**********");
        System.out.println(" Name: " + name);
        System.out.println(" Phone number: " + num);
        System.out.println(" Address: " + address);
        System.out.println("*************************************");
    }

    @Override
    public void BookingStatus(int y) {
        System.out.println("========= View booking status ======");
        System.out.println("-----------Name: " + name[y] + "------------");
        System.out.println("|                                  |");
        System.out.println("-------Pickup point: " + pickupDropPoint[y][0] + "----------");
        System.out.println("|                                  |");
        System.out.println("------Drop point: " + pickupDropPoint[y][1] + "-------------");
        System.out.println("|                                  |");
        System.out.println("----------Distance: " + distAmt[y][0] + "---------");
        System.out.println("|                                  |");
        System.out.println("------No. of person: " + person[y] + "------------");
        System.out.println("|                                  |");
        System.out.println("-----------Amount: " + distAmt[y][1] + "-------------");
        System.out.println("====================================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Taxi menu = new Taxi();

        System.out.print("Press 'Enter' to Log In: ");
        sc.nextLine();

        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        System.out.print("Enter your phone number: ");
        Long phNum = sc.nextLong();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter your address: ");
        String address = sc.nextLine();

        boolean cond = true;
        while (cond) {
            int randomNumber = random.nextInt(100000);
            boolean containsElement = hashSet.contains(randomNumber);

            if (containsElement == false) {
                hashSet.add(randomNumber);

                System.out.println();
                System.out.println("************ Welcome To Our Cab-app ************");
                System.out.println("*                                              *");
                System.out.println("**************** 1. Main Menu ******************");
                System.out.println("*                                              *");
                System.out.println("**************** 2. View Status ****************");
                System.out.println("*                                              *");
                System.out.println("**************** 3. Exit ***********************");
                System.out.println("*                                              *");
                System.out.println("************************************************");

                System.out.print("Enter your choice--> ");

                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Your unique ID is: " + randomNumber);
                    System.out.println("Warnning: You must enter this number while you are checking your status.");
                    System.out.println();
                    System.out.println("************ Main Menu ************");
                    System.out.println("*                                 *");
                    System.out.println("********* 1. Book a Taxi **********");
                    System.out.println("*                                 *");
                    System.out.println("********** 2. Back ****************");
                    System.out.println("*                                 *");
                    System.out.println("***********************************");
                    System.out.println();

                    System.out.print("Enter your choice--> ");

                    int mainMenuChoice = sc.nextInt();
                    switch (mainMenuChoice) {
                        case 1:
                            menu.BookTaxi(randomNumber);
                            break;
                        case 2:
                            // Go back to the main menu
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } else if (choice == 2) {
                    System.out.println();
                    System.out.println("************ View Status ************");
                    System.out.println("*                                   *");
                    System.out.println("******** 1. My Details *************");
                    System.out.println("*                                   *");
                    System.out.println("******** 2. Booking Status *********");
                    System.out.println("*                                   *");
                    System.out.println("******** 3. Back ********************");
                    System.out.println("*                                   *");
                    System.out.println("*************************************");
                    System.out.println();

                    System.out.print("Enter your choice--> ");

                    int viewChoice = sc.nextInt();
                    switch (viewChoice) {
                        case 1:
                            menu.MyDetails(userName, phNum, address);
                            break;
                        case 2:
                            System.out.print("Enter your unique ID: ");
                            int id = sc.nextInt();
                            menu.BookingStatus(id);
                            break;
                        case 3:
                            // Go back to the main menu
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    cond = false; // Set the condition to false to exit the loop
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}