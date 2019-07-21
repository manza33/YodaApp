package com.sdzee.bdd;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

import java.sql.*;

public class ConnexionSQL {

    public Connection connexionSql() throws SQLException {


        try {
            Class.forName( "com.mysql.jdbc.Driver" );

        } catch ( ClassNotFoundException e ) {

        }

        //Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/starwars?serverTimezone=GMT";
        String utilisateur = "root";
        String motDePasse = "Manzana33!";
        Connection connexion = null;

        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

        return connexion;
    }


}




