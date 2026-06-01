package stocktradingplatform;

import java.util.Scanner;

// Stock Class
class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// User Class
class User {
    double balance;
    int tataShares;
    int infyShares;

    User(double balance) {
        this.balance = balance;
        this.tataShares = 0;
        this.infyShares = 0;
    }
}

// Main Class
public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock tata = new Stock("TATA", 3500);
        Stock infy = new Stock("INFY", 1600);

        User user = new User(50000);

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy TATA Stock");
            System.out.println("3. Sell TATA Stock");
            System.out.println("4. Buy INFY Stock");
            System.out.println("5. Sell INFY Stock");
            System.out.println("6. View Portfolio");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n----- Market Data -----");
                    System.out.println("TATA  Price : ₹" + tata.price);
                    System.out.println("INFY  Price : ₹" + infy.price);
                    break;

                case 2:

                    System.out.print("Enter Quantity: ");
                    int buyTata = sc.nextInt();

                    double tataCost = buyTata * tata.price;

                    if (tataCost <= user.balance) {

                        user.balance -= tataCost;
                        user.tataShares += buyTata;

                        System.out.println("TATA Stock Purchased Successfully!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:

                    System.out.print("Enter Quantity: ");
                    int sellTata = sc.nextInt();

                    if (sellTata <= user.tataShares) {

                        user.balance += sellTata * tata.price;
                        user.tataShares -= sellTata;

                        System.out.println("TATA Stock Sold Successfully!");
                    } else {
                        System.out.println("Not Enough TATA Shares!");
                    }
                    break;

                case 4:

                    System.out.print("Enter Quantity: ");
                    int buyInfy = sc.nextInt();

                    double infyCost = buyInfy * infy.price;

                    if (infyCost <= user.balance) {

                        user.balance -= infyCost;
                        user.infyShares += buyInfy;

                        System.out.println("INFY Stock Purchased Successfully!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 5:

                    System.out.print("Enter Quantity: ");
                    int sellInfy = sc.nextInt();

                    if (sellInfy <= user.infyShares) {

                        user.balance += sellInfy * infy.price;
                        user.infyShares -= sellInfy;

                        System.out.println("INFY Stock Sold Successfully!");
                    } else {
                        System.out.println("Not Enough INFY Shares!");
                    }
                    break;

                case 6:

                    System.out.println("\n----- Portfolio -----");
                    System.out.println("Available Balance : ₹" + user.balance);
                    System.out.println("TATA Shares       : " + user.tataShares);
                    System.out.println("INFY Shares       : " + user.infyShares);

                    double portfolioValue =
                            (user.tataShares * tata.price)
                            + (user.infyShares * infy.price);

                    System.out.println("Portfolio Value   : ₹" + portfolioValue);

                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}