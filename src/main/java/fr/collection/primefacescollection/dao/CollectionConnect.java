package fr.collection.primefacescollection.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CollectionConnect {
    // Declare the JDBC objects.
    private static Connection connexion;

    private CollectionConnect() {

    }

    public static Connection getInstance() {
        if (connexion == null) {
            System.out.println("Tentative de connexion bdd");
            try {
                String dbURL = "jdbc:sqlserver://localhost:1401;databaseName=COLLECTION;encrypt=false";
                String user = "sa";
                String pass = "azerty@123456";
                connexion = DriverManager.getConnection(dbURL, user, pass);
                System.out.println("Connexion reussie");
            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connexion echouee");
            }
        }
        return connexion;
    }
}
