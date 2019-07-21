package com.sdzee.bdd;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequeteYodaApp {


    private List<String> jedis = new ArrayList<>();

    public List<String> listJedis(HttpServletRequest request) throws SQLException, ClassNotFoundException {

        Statement statement = null;
        ResultSet resultat = null;

        // Connexion a SQL
        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.startConnection();

        try {

            statement = connection.createStatement();

            resultat = statement.executeQuery( "SELECT * FROM jedi_masters;" );

            while ( resultat.next() )  {
                //int idUtilisateur = resultat.getInt( "id" );
                String nameJedi = resultat.getString( "name" );
                String surnameJedi = resultat.getString( "surname" );
                jedis.add(nameJedi + " " + surnameJedi);
            }

        } catch ( SQLException e ) {

        }finally {

            // Deconnexion SQL
            ConnectionSQL closeSQL = new ConnectionSQL();
            closeSQL.closeSQL(resultat,statement,connection);
        }

        return jedis;
    }

}
