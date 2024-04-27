import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        StoreExpense storeExpense;
        String expensesName;
        double priceOfExpense;
        Date dateOfPurchase;
        DBConnection dbConnection = new DBConnection();
        Connection connection = null;
            try {
                connection = dbConnection.getConnection();
                System.out.println("Databse connected successfully");
            } catch (Exception ex) {
                ex.getStackTrace();
                System.out.println(ex.getMessage());
            }


        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to Expenses management system!");
            System.out.println("Menu Options:");
            System.out.println("1. Store Information");
            System.out.println("2. Play With Data");
            System.out.print("Enter your Choice: ");
            String userInput = scanner.nextLine();
            int inputChoice = Integer.parseInt(userInput);

            switch (inputChoice){
                case 1:
                    try {
                        System.out.print("Enter the type of Expenditure: ");
                        expensesName = scanner.nextLine();
                        if (expensesName == null || expensesName.equals(null)){
                            System.out.println("Expenses name can't be empty!");
                        }
                        System.out.print("Enter the Price of Purchase: ");
                        priceOfExpense = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the date of purchase(dd-MM-yyyy): ");
                        String dateInput = scanner.nextLine();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        dateOfPurchase = dateFormat.parse(dateInput);

                        storeExpense = new StoreExpense(expensesName,priceOfExpense,dateOfPurchase);
                        String result = storeExpense.storeData(connection);
                        System.out.println(result);
                    }catch (ParseException | SQLException exception){
                        exception.printStackTrace();
                        System.out.println("Failed to add a row to database");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            //scanner.close();
        }while (true);

    }
}
