import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class StoreExpense {

    private String expensesName;
    private double priceOfExpense;
    private Date dateOfPurchase;

    public StoreExpense(String expensesName,double priceOfExpense,Date dateOfPurchase){
        this.expensesName = expensesName;
        this.priceOfExpense = priceOfExpense;
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setExpensesName(){
        this.expensesName = expensesName;
    }

    public void setPriceOfExpense(){
        this.priceOfExpense = priceOfExpense;
    }

    public void setDateOfPurchase(){
        this.dateOfPurchase=dateOfPurchase;
    }

    public  String getExpensesName(){
        return expensesName;
    }

    public double getPriceOfExpense(){
        return priceOfExpense;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String storeData(Connection connection) throws SQLException {
        String query = "INSERT INTO expenses(ExpenseName,Amount,ExpenseDate) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, this.expensesName);
        preparedStatement.setDouble(2, this.priceOfExpense);
        preparedStatement.setObject(3,this.dateOfPurchase);
        int rowInserted = preparedStatement.executeUpdate();
        if (rowInserted > 0){
            return "row created successfully.";
        }
        else{
            return "failed to create row";
        }
    }
}
