package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URl = "jdbc:sqlserver://localhost:1433;databaseName=practicaDesarrollo;encrypt=false";
    private static final String User = "practicaDesarrollo";
    private static final String Password = "practica123";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URl,User,Password);
        } catch (SQLException e ){
            System.out.println("error to connect data base" + e.getMessage());
            return null;
        }
    }
}
