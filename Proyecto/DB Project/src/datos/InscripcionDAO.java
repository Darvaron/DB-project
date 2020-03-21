/*
 * Descripción: Clase que encapsula el acceso a la base de datos para la inscripcion
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Inscripcion;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class InscripcionDAO {

    private Inscripcion ins;

    public InscripcionDAO() {
        this.ins = new Inscripcion();
    }

    public void incluirInscripcion() throws CaException {
        try {
            String strSQL = "INSERT INTO inscripcion VALUES (?, ?, ?, CURRENT_DATE, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            //Fecha
            String[] f_i = ins.getF_inscrip().split("/");
            Date f_ins = new Date(Integer.parseInt(f_i[0]), Integer.parseInt(f_i[1]), Integer.parseInt(f_i[2]));

            prepStmt.setInt(1, ins.getK_ins());
            prepStmt.setString(2, ins.getI_estadoi());
            prepStmt.setDouble(3, ins.getV_ins());
            prepStmt.setBoolean(4, ins.isO_asiste());
            prepStmt.setString(5, ins.getK_tipo());
            prepStmt.setInt(6, ins.getK_num());
            prepStmt.setInt(7, ins.getK_code());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("InscripcionDAO", "No se pudo crear la inscripción " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarInscripcion() {

    }

    public void eliminarInscripcion() {

    }

    public void buscarInscripcion() throws CaException {
        try {
            String strSQL = "SELECT * FROM inscripcion WHERE k_ins = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, ins.getK_ins());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                ins.setK_ins(rs.getInt(1));
                ins.setI_estadoi(rs.getString(2));
                ins.setV_ins(rs.getDouble(3));
                Date f_ins = rs.getDate(4);
                ins.setF_inscrip(f_ins.toString());
                ins.setO_asiste(rs.getBoolean(5));
                ins.setK_tipo(rs.getString(6));
                ins.setK_num(rs.getInt(7));
                ins.setK_code(rs.getInt(8));
            }

        } catch (SQLException e) {
            throw new CaException("InscripcionDAO", "No se pudo obtener la inscripcion " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarInscripcion() {

    }

    public Inscripcion getIns() {
        return ins;
    }

    public void setIns(Inscripcion ins) {
        this.ins = ins;
    }

}
