/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el tipo de evento
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Tipo;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class TipoDAO {

    private Tipo t;

    public TipoDAO() {
        this.t = new Tipo();
    }

    public void incluirTipo() throws CaException {
        try {
            String strSQL = "INSERT INTO tipo VALUES (?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, t.getK_idt());
            prepStmt.setString(2, t.getN_nombre());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("tipoDAO", "No se pudo crear el tipo de evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarTipo() {

    }

    public void elimitarTipo() {

    }

    public void buscarTipo() throws CaException {
        try {
            String strSQL = "SELECT * FROM tipo WHERE k_idt = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, t.getK_idt());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {              
                t.setK_idt(rs.getInt(1));
                t.setN_nombre(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new CaException("tipoDAO", "No se pudo obtener el tipo de evento"+e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarTipo() {

    }

    public Tipo getT() {
        return t;
    }

    public void setT(Tipo t) {
        this.t = t;
    }

}
