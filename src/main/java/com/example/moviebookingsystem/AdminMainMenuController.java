package com.example.moviebookingsystem;
import Classes.*;
import DatabaseServices.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import net.sf.jasperreports.engine.*;

public class AdminMainMenuController implements Initializable,IValidate{
    Double totalBalanceSum = 0.0;
    String soldItemsStr = "";
    @FXML
    AnchorPane checkOutPane;
    Meal selectedMeal;
    @FXML
    ComboBox <String> categoryComboBox;
    @FXML
    TextField mealTitle,mealPrice,mealQuantity,soldMealQuantity,loginIdTF,adminPassTF,adminNameTF,adminAgeTF,confirmPassTF;
    @FXML
    Pane dashboardPane,adminsMenuPane,usersMenuPane,ticketsMenuPane,foodMenuPane,addMealPane,mealsTable,sellMealPane,viewUsersReport,viewMealsPane,addAdminPane,viewAllAdminsPane,purchaseHistoryPane,purchaseHistoryPage;
    @FXML
    TextArea mealDescription;
    @FXML
    ListView<String> mealsList;
    @FXML
    TableColumn<Meal,String> MealTitleColumn,MealCategoryColumn,MealDescColumn;
    @FXML
    TableColumn<Meal,Double>MealPriceColumn;
    @FXML
    TableColumn<Meal,Integer>MealQuantityColumn;
    @FXML
    TableColumn<Admin, String> AdminNameColumn;
    @FXML
    TableColumn<Admin, Integer> AdminAgeColumn;
    @FXML
    TableColumn<Admin, Double> AdminLoginIDColumn;
    @FXML
    TableView<Purchase> purchaseHistoryTable;
    @FXML
    TableColumn <Purchase,String> ItemsBoughtColumn,DateOfPurchaseColumn;
    @FXML
    TableColumn<Purchase,Double> AmntPaidColumn;
    @FXML
    Button usersNavLink,dashboardNavLink,adminsNavLink,ticketsNavLink,foodNavLink,addMeal,viewAllMealsButton,sellMeal;
    @FXML
    DatePicker calendar;
    @FXML
    Label errorMessage,totalBalance,availableBalance,welcomeMessage,adminStatusMessage,noOfAdmins,noOfUsers,incomeThisMonth;
    ObservableList <String> categoryComboBoxItems = FXCollections.observableArrayList("Food","Drink");
    @FXML
    TableView<Meal> allMealsTable;
    @FXML
    TableView<Admin> allAdminsTable;
    @FXML
    VBox cartItems;
    @FXML
    public void onSellItems() throws IOException, JRException, SQLException, ParseException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.Connect();
        Date date = new Date();
        PurchaseID ID = new PurchaseID();
        Purchase purchase = new Purchase(soldItemsStr,totalBalanceSum, ID.generateUniqueId());
        PurchaseServices.sell(purchase);
        ReportServices.printInvoice("Blank_Letter.jrxml",purchase.getPurchaseId());
        Counter.getTotalBalance();
        System.out.println(purchase.getPurchaseId());
        Cart.clearCart();
    }
    @FXML
    public void onAnalyzeData() throws JRException, SQLException {
        ReportServices.ConnectReport("purchaseHistoryData.jrxml");

    }
    @FXML
    public void onViewMealsReport() throws JRException, SQLException {
        ReportServices.ConnectReport("Invoice.jrxml");
    }
    @FXML
    public void onUsersReport() throws JRException, SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.Connect();
        ReportServices.ConnectReport("Invoice_4.jrxml");
    }
    @FXML
    public void onHover(){
        Style.changeColorOnHover(dashboardNavLink,"#171717","#0f0f0f","#fff","b9b9b9");
        Style.changeColorOnHover(usersNavLink,"#171717","#0f0f0f","#fff","b9b9b9");
        Style.changeColorOnHover(adminsNavLink,"#171717","#0f0f0f","#fff","b9b9b9");
        Style.changeColorOnHover(ticketsNavLink,"#171717","#0f0f0f","#fff","b9b9b9");
        Style.changeColorOnHover(foodNavLink,"#171717","#0f0f0f","#fff","b9b9b9");
    }
    @FXML
    public void onGoToCheckout() throws SQLException {

        for(Meal element : Cart.getCartItems()){
            soldItemsStr+= element.getMealTitle()+" ";
            double num = element.getPrice()*Integer.parseInt(soldMealQuantity.getText());
            totalBalanceSum+=num;
            MealServices.decrementMealQuantity(element.getMealTitle(),Double.parseDouble(soldMealQuantity.getText()));
            Label label = new Label(element.getMealTitle() + "  x"+soldMealQuantity.getText()+" "+num+"$");
            label.setTextFill(Color.WHITE);
            label.setFont(new Font(30));
            totalBalance.setText(totalBalanceSum+"$");
            cartItems.getChildren().add(label);
        }

        checkOutPane.toFront();
        welcomeMessage.toFront();

    }
    @FXML
    public  void onAddToCart()  {
        if(selectedMeal.getQuantity()<Integer.parseInt(soldMealQuantity.getText()))
        {
            errorMessage.setText("Quantity not available in storage!");
            return;
        }
        else if(Integer.parseInt(soldMealQuantity.getText())<=0)
        {
            errorMessage.setText("Please enter a number greater than 0!");
            return;
        }
        Cart.addToCart(selectedMeal);
        System.out.println(Cart.getCartItems().size());
    }
    @FXML
    public void handleNavLinkClick(ActionEvent e){
        if(e.getSource() == usersNavLink)
            usersMenuPane.toFront();
        if(e.getSource() == dashboardNavLink)
            dashboardPane.toFront();
        if(e.getSource() == adminsNavLink)
            adminsMenuPane.toFront();
        if(e.getSource() == ticketsNavLink)
            ticketsMenuPane.toFront();
        if(e.getSource() == foodNavLink)
            foodMenuPane.toFront();

    }
    @FXML
    public void onViewAllMeals() throws SQLException {
        mealsTable.toFront();
        welcomeMessage.toFront();
        allMealsTable.setItems(MealServices.viewAllMeals());
        MealTitleColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("mealTitle"));
        MealCategoryColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("category"));
        MealPriceColumn.setCellValueFactory(new PropertyValueFactory<Meal,Double>("price"));
        MealQuantityColumn.setCellValueFactory(new PropertyValueFactory<Meal,Integer>("quantity"));
        MealDescColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("description"));

    }
//    @FXML
//    public void handleListClick(ActionEvent event){
////        System.out.println(mealsList.getSelectionModel().getSelectedItem());
//        System.out.println("hi");
//    }
    @FXML
    public void handleAdminMenuClick(ActionEvent e) throws SQLException {
        ObservableList<String> mealsListObsv = FXCollections.observableArrayList();
        if(e.getSource() == addMeal)
            addMealPane.toFront();
        if(e.getSource() == sellMeal)
        {
            sellMealPane.toFront();
            for(Meal element : MealServices.viewAllMeals()){
                mealsListObsv.add(element.getMealTitle());
            }
            mealsList.setItems(mealsListObsv);
            mealsList.setOnMouseClicked(event->{
                try {
                    for(Meal element:MealServices.viewAllMeals())
                    {
                        if(element.getMealTitle().equals(mealsList.getSelectionModel().getSelectedItem()))
                            selectedMeal = element;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    @FXML
    private void onSubmitMealForm() throws SQLException, FileNotFoundException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.Connect();
        MealServices.addMeal(mealTitle.getText(),mealDescription.getText(),categoryComboBox.getValue(),Double.parseDouble(mealPrice.getText()),Integer.parseInt(mealQuantity.getText()));
    }
    @FXML
    public void onViewAllUsers() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("UsersTable.fxml","Users Table");
    }
    @FXML
    public void onSearchUsers() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("SearchUsers.fxml","Search Users");
    }
    @FXML
    private void onDeleteUser() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("deleteUserForm.fxml","Delete User");
    }
    @FXML
    public void onGenerateAutoID() throws UnknownHostException {
        AdminID adminID = new AdminID();
        loginIdTF.setText(adminID.generateUniqueId());
    }
    public boolean comparePasswords(String firstPassword,String secondPassword){
        if(!firstPassword.equals(secondPassword))
        {
            adminStatusMessage.setText("Passwords must match!");
            return false;
        }
        return true;
    }
    @FXML
    public void onAddAdminButton() throws SQLException {
        System.out.println(validatePassword(adminPassTF.getText()));
        System.out.println(adminPassTF.getText());
        if(comparePasswords(adminPassTF.getText(),confirmPassTF.getText()) && validatePassword(adminPassTF.getText()))
        {
            adminStatusMessage.setText(adminNameTF.getText()+" was added as an admin.");
            adminStatusMessage.setTextFill(Color.GREEN);
            AdminServices.addAdmin(adminNameTF.getText(),Integer.parseInt(adminAgeTF.getText()),loginIdTF.getText(),adminPassTF.getText());
        }
    }
    @FXML
    public void onAddAdmin(){
        addAdminPane.toFront();
        welcomeMessage.toFront();
    }
    @FXML
    public void onDeleteAdmin(){

    }
    @FXML
    public void onViewAllAdmins() throws SQLException {
        allAdminsTable.setItems(AdminServices.viewAllAdmins());
        AdminNameColumn.setCellValueFactory(new PropertyValueFactory<Admin,String>("name"));
        AdminAgeColumn.setCellValueFactory(new PropertyValueFactory<Admin,Integer>("age"));
        AdminLoginIDColumn.setCellValueFactory(new PropertyValueFactory<Admin,Double>("adminLoginId"));
        viewAllAdminsPane.toFront();
        welcomeMessage.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentMonth = cal.get(Calendar.MONTH)+1;
        int currentYear = cal.get(Calendar.YEAR);
        System.out.println(currentYear);
        try {
            if (Counter.getIncome(currentMonth-1,2022)>=Counter.getIncome(currentMonth,currentYear))
                incomeThisMonth.setTextFill(Color.RED);
            else
                incomeThisMonth.setTextFill(Color.GREEN);
            incomeThisMonth.setText(String.valueOf("$"+Counter.getIncome(currentMonth,currentYear)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        calendar.setValue(LocalDate.now());
        try {
            noOfAdmins.setText(String.valueOf(Counter.noOfAdmins()));
            noOfUsers.setText(String.valueOf(Counter.noOfUsers()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Context ctx  = Context.getInstance();
        welcomeMessage.setText("Hello, "+ctx.getInstance().getCurrentAdmin().getName());
        Style.transition(viewUsersReport,2000.0);
        Style.transition(viewMealsPane,2000.0);
        Style.transition(purchaseHistoryPane,2000.0);
        Style.changeColorOnHover(viewUsersReport,"#000","#1e1e1e");
        Style.changeColorOnHover(viewMealsPane,"#000","#1e1e1e");
        Style.changeColorOnHover(purchaseHistoryPane,"#000","#1e1e1e");
        viewMealsPane.setOnMouseClicked(e->{
            try {
                onViewMealsReport();
            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        viewUsersReport.setOnMouseClicked(event->{
            try {
                onUsersReport();
            } catch (JRException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        purchaseHistoryPane.setOnMouseClicked(event->{
            try {
                System.out.println(PurchaseServices.getPurchaseHistory().size());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                purchaseHistoryTable.setItems(PurchaseServices.getPurchaseHistory());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ItemsBoughtColumn.setCellValueFactory(new PropertyValueFactory<Purchase,String>("itemName"));
            AmntPaidColumn.setCellValueFactory(new PropertyValueFactory<Purchase,Double>("amountPaid"));
            DateOfPurchaseColumn.setCellValueFactory(new PropertyValueFactory<Purchase,String>("dateOfPurchase"));
            purchaseHistoryPage.toFront();
        });

        try {
            System.out.println(Counter.getTotalBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        categoryComboBox.setItems(categoryComboBoxItems);
        try {
            availableBalance.setText("$"+Counter.getTotalBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkNumeric(String numAttempt) {
        return numAttempt.matches("[0-9]");
    }

    @Override
    public boolean validatePassword(String passwordAttempt) {
        System.out.println("pass attempt = "+passwordAttempt);
        Pattern pattern = Pattern.compile(".*[A-Z].*");

            if (pattern.matcher(passwordAttempt).matches())
            return true;
            else adminStatusMessage.setText("Password must contain at least 1 uppercase letter");
        return false;
    }

    @Override
    public boolean validateEmail(String emailAttempt) {
        return false;
    }
}
