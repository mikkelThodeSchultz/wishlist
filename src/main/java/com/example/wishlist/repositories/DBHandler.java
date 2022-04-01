package com.example.wishlist.repositories;

import com.example.wishlist.models.Account;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.WishList;
import com.example.wishlist.repositories.utility.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBHandler {

    private DBConnector dbc = new DBConnector();
    private Connection con = dbc.connectDB();

    //TODO Virker ikke før vi kan hente Account_ID.
    public void insertWishListToDB(WishList wishList) {
        String wishListName = wishList.getWishListName();
        try {
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO wishlist (`wishlist_name`) VALUES (?);");
            preparedStatement.setString(1, wishListName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //TODO Virker ikke før vi kan hente wishlist_ID
    public void insertWishToDB(Wish wish) {
        String wishName = wish.getName();
        String wishDescription = wish.getDescription();
        String wishURL = wish.getURL();
        double wishPrice = wish.getPrice();
        try {                           // Måske skal der være reservationStatus også?
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO wish (`wish_name`, `wish_description`, `wish_price`, `wish_url`) VALUES (?,?,?,?);");
            preparedStatement.setString(1, wishName);
            preparedStatement.setString(2, wishDescription);
            preparedStatement.setDouble(3, wishPrice);
            preparedStatement.setString(4, wishURL);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertAccountToDB(Account account) {
        String accountName = account.getAccountName();
        String password = account.getPassword();
        String email = account.getEmail();
        try {
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO account (`account_name`, `account_email`, `account_password`) VALUES (?,?,?);");
            preparedStatement.setString(1,accountName);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
