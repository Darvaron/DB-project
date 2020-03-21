/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el pago del proveedor
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.PagoP;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class PagoPDAO {

    private PagoP pg;

    public PagoPDAO() {
        this.pg = new PagoP();
    }

    public void incluirPagoP() throws CaException {
        try {
            String strSQL = "INSER INTO pagop VALUES (?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            //Fecha
            String[] f_pago = pg.getF_pagop().split("/");
            Date f_pagop = new Date(Integer.parseInt(f_pago[0]), Integer.parseInt(f_pago[1]), Integer.parseInt(f_pago[2]));

            prepStmt.setInt(1, pg.getK_idpp());
            prepStmt.setDate(2, f_pagop);
            prepStmt.setString(3, pg.getO_formapp());
            prepStmt.setInt(4, pg.getK_idp());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PagoPDAO", "No se pudo crear el pago al proveedor" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarPagoP() {

    }

    public void eliminarPagoP() {

    }

    public void buscarPagoP() throws CaException {
        try {
            String strSQL = "SELECT * FROM pagop WHERE k_idpp = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, pg.getK_idpp());
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                pg.setK_idpp(rs.getInt(1));
                Date f_pago = rs.getDate(2);
                pg.setF_pagop(f_pago.toString());
                pg.setO_formapp(rs.getString(3));
                pg.setK_idp(rs.getInt(4));
            }
            
        } catch (SQLException e) {
            throw new CaException("PagoPDAO", "No se pudo obtener el pago al proveedor" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void actualizarPagoP(){
        
    }

    public PagoP getPg() {
        return pg;
    }

    public void setPg(PagoP pg) {
        this.pg = pg;
    }
    
}
