/*
 * Descripción: Clase que encapsula el acceso a la base de datos para los detalles de la inscripción
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.DetalleInscripcion;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class DetalleInscripcionDAO {

    private DetalleInscripcion det;

    public DetalleInscripcionDAO() {
        this.det = new DetalleInscripcion();
    }

    public void incluirDetalleInscripcion() throws CaException {
        try {
            String strSQL = "INSERT INTO detalleinscripcion VALUES (?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, det.getK_iddi());
            prepStmt.setInt(2, det.getK_ins());
            prepStmt.setInt(3, det.getK_numidf());
            prepStmt.setString(4, det.getK_tipoidf());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("DetalleInscripcionDAO", "No se pudo crear el detalle de la inscripción " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarDetalleInscripcion() {

    }

    public void eliminarDetalleInscripcion() {

    }

    public void buscarDetalleInscripcion() throws CaException {
        try {
            String strSQL = "SELECT * FROM detalleinscripcion WHERE k_iddi = ? AND k_ins = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, det.getK_iddi());
            prepStmt.setInt(2, det.getK_ins());
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                det.setK_iddi(rs.getInt(1));
                det.setK_ins(rs.getInt(2));
                det.setK_numidf(rs.getInt(3));
                det.setK_tipoidf(rs.getString(4));
            }

        } catch (SQLException e) {
            throw new CaException("DetalleInscripcionDAO", "No se pudo obtener el detalle de inscripción " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarDetalleInscripcion() {

    }

    public DetalleInscripcion getDet() {
        return det;
    }

    public void setDet(DetalleInscripcion det) {
        this.det = det;
    }

}
