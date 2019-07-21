package com.sdzee.bdd;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequeteYodaApp {


    private List<String> jedis = new ArrayList<>();

    public List<String> listJedis(HttpServletRequest request) throws SQLException, ClassNotFoundException {


        /*try {
            Class.forName( "com.mysql.jdbc.Driver" );

        } catch ( ClassNotFoundException e ) {

        }

        //Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/starwars?serverTimezone=GMT";
        String utilisateur = "root";
        String motDePasse = "Manzana33!";
        Connection connexion = null;*/
        Statement statement = null;
        ResultSet resultat = null;

        ConnexionSQL connexionSQL = new ConnexionSQL();
        Connection connexion = connexionSQL.connexionSql();

        try {

            //connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            //
            // statement = connexion.createStatement();


            statement = connexion.createStatement();

            resultat = statement.executeQuery( "SELECT * FROM jedi_masters;" );

            while ( resultat.next() )  {
                //int idUtilisateur = resultat.getInt( "id" );
                String nameJedi = resultat.getString( "name" );
                String surnameJedi = resultat.getString( "surname" );
                jedis.add(nameJedi + " surnommé " + surnameJedi);
            }

        } catch ( SQLException e ) {

        } finally {
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

        return jedis;
    }

}
