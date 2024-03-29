package com.sdzee.bdd;

import java.sql.*;

public class ConnectionSQL {


    public Connection startConnection() throws SQLException {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );

        } catch ( ClassNotFoundException e ) {

        }
        

        String url = "jdbc:mysql://localhost:3306/starwars?serverTimezone=GMT";
        String utilisateur = "root";
        String motDePasse = "root";
        Connection connexion = null;

        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

        return connexion;
    }

    public void closeSQL(ResultSet resultat, Statement statement, Connection connexion) throws SQLException{

        if ( resultat != null ) {
            try {
                resultat.close();
            } catch ( SQLException ignore ) {
            }
        }
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            }
        }
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {
            }
        }

    }


}




