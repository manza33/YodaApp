package com.sdzee.bdd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "ServletYodaApp" , urlPatterns = "/yoda_app")
public class ServletYodaApp extends HttpServlet {

    public static final String LIST_JEDIS = "listJedis";
    public static final String VUE          = "/yoda_jedis_list.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        RequeteYodaApp requeteYodaApp = new RequeteYodaApp();
        List<String> listJedis = null;

        try {
            listJedis = requeteYodaApp.listJedis( request );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute( LIST_JEDIS, listJedis );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        /*PrintWriter out = response.getWriter();
        for (String j : listJedis){
            out.println(j);
        }*/
    }

}
