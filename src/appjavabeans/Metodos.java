/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavabeans;

import beans.Pedido;
import beans.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Metodos {

    Connection conn;
    ResultSet resul;

    //conexion a la base
    public void conexion() {
        try {
            String driver = "jdbc:oracle:thin:";
            String host = "localhost.localdomain";
            String porto = "1521";
            String sid = "orcl";
            String usuario = "hr";
            String password = "hr";
            String url = driver + usuario
                    + "/" + password + "@" + host
                    + ":" + porto + ":" + sid;
            conn = DriverManager.getConnection(url);
            System.out.println("Base de datos operativa. Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //consulta de productos
    public ArrayList<Producto> consultaPro(String consulta) throws SQLException {
        try {
            PreparedStatement con = conn.prepareStatement(consulta);
            resul = con.executeQuery();
            while (resul.next()) {
                System.out.println("Id: " + resul.getInt("id"));
                System.out.println("Descripción: " + resul.getString("descripcion"));
                System.out.println("StockActual: " + resul.getString("stockactual"));
                System.out.println("StockMínimo: " + resul.getString("stockminimo"));
                System.out.println("PVP: " + resul.getFloat("pvp"));
            }
        } catch (SQLException ex) {
            System.out.println("Error, verificar que la base este conectada " + ex.getMessage());
        }
        return null;

    }

    //consulta de pedidos
    public ArrayList<Pedido> consultaPed(String consulta) {
        try {
            PreparedStatement con = conn.prepareStatement(consulta);
            resul = con.executeQuery();
            while (resul.next()) {
                System.out.println("Id: " + resul.getInt("id"));
                System.out.println("IdProducto: " + resul.getInt("idproducto"));
                System.out.println("FechaPedido: " + resul.getDate("fechapedido"));
                System.out.println("Cantidad: " + resul.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            System.out.println("Error, verificar que la base este conectada " + ex.getMessage());
        }
        return null;

    }

    //consulta de ventas
    public ArrayList<Venta> consultaVen(String consulta) {
        try {
            PreparedStatement con = conn.prepareStatement(consulta);
            resul = con.executeQuery();
            while (resul.next()) {
                System.out.println("IdProducto: " + resul.getInt("idproducto"));
                System.out.println("FechaPVenta: " + resul.getDate("fechaventa"));
                System.out.println("Cantidad: " + resul.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            System.out.println("Error, verificar que la base este conectada " + ex.getMessage());
        }
        return null;

    }

    //ultimo id de la tabla 
    public int obterUltimoID(String taboa) {
        int id = -1;
        try {
            Statement st = conn.createStatement();
            resul = st.executeQuery("select max(id) from " + taboa);
            while (resul.next()) {
                id = resul.getInt(1);
                System.out.println("IdMax: " + id);
            }
        } catch (SQLException ex) {
            System.out.println("Error, verificar que la base este conectada " + ex.getMessage());
        }
        return id;

    }
}
