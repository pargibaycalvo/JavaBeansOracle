/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavabeans;

import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class AppJavaBeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Metodos m = new Metodos();
        m.conexion();
//        m.consultaPro("Select * from productos");
//        m.consultaPed("Select * from pedidos");
//        m.consultaVen("Select * from ventas");
        m.obterUltimoID("productos");
//        m.inxerirVenta(null); -
        m.cerrarCon();
    }
    
}
