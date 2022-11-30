package fr.collection.primefacescollection.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

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
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setServerName("127.0.0.1");
                // ds.setServerName("db");
                ds.setPortNumber(1401);
                ds.setDatabaseName("COLLECTION");
                ds.setIntegratedSecurity(false);
                ds.setEncrypt(false);
                ds.setUser("sa");
                ds.setPassword("azerty@123456");
                connexion = ds.getConnection();

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
