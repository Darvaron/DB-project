/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el pago de la inscripción
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import java.sql.*;
import negocio.PagoI;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class PagoIDAO {

    private PagoI pa;

    public PagoIDAO() {
        this.pa = new PagoI();
    }

    public void incluirPagoI() throws CaException {
        try {
            String strSQL = "INSERT INTO pagoi VALUES (?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            //Fechas
            String[] f_pp = pa.getF_pagopi().split("/");
            Date f_pagop = new Date(Integer.parseInt(f_pp[0]), Integer.parseInt(f_pp[1]), Integer.parseInt(f_pp[2]));

            prepStmt.setInt(1, pa.getK_idpi());
            prepStmt.setDate(0, f_pagop);
            prepStmt.setString(3, pa.getO_fpagoi());
            prepStmt.setDouble(4, pa.getV_inspi());
            prepStmt.setDouble(5, pa.getK_ins());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("PagoIDAO", "No se pudo crear el pago de la inscripción" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarPagoI() {

    }

    public void eliminarPagoI() {

    }

    public void buscarPagoI() throws CaException {
        try {
            String strSQL =  "SELECT  * FROM pagoi WHERE k_idpi = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, pa.getK_idpi());
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                pa.setK_idpi(rs.getInt(1));
                Date f_pago = rs.getDate(2);
                pa.setF_pagopi(f_pago.toString());
                pa.setO_fpagoi(rs.getString(3));
                pa.setV_inspi(rs.getDouble(4));
                pa.setK_ins(rs.getInt(1));
            }
                    
        } catch (SQLException e) {
            throw new CaException("PagoIDAO", "No se pudo obtener el pago de la inscripción" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void actualizarPagoI(){
        
    }

    public PagoI getPa() {
        return pa;
    }

    public void setPa(PagoI pa) {
        this.pa = pa;
    }

}
