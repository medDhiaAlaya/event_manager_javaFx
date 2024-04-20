package com.esprit.autismo.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataBase {
    private static MyDataBase instance;
    private final String URL="jdbc:mysql://127.0.0.1:3306/pidb";
    private final String USERNAME ="root";
    private final String PASSWORD ="";
    private Connection cnx ;

    private MyDataBase (){
        try{
            cnx= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("bd connected ... done");

        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("bd connection ... failed");
        }
    }

    public static MyDataBase getInstance() {
        if (instance == null)
            instance = new MyDataBase();
        return instance;
    }
    public Connection getCnx(){
            return cnx;
        }
}
