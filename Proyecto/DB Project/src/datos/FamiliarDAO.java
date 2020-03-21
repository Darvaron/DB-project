/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el familiar
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Familiar;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class FamiliarDAO {

    private Familiar f;

    public FamiliarDAO() {
        this.f = new Familiar();
    }

    public void incluirFamiliar() throws CaException {
        try {
            String strSQL = "INSERT INTO famliar VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareCall(strSQL);

            //Fechas
            String[] f_n = f.getF_ntof().split("/");
            Date f_ntof = new Date(Integer.parseInt(f_n[0]), Integer.parseInt(f_n[1]), Integer.parseInt(f_n[2]));

            prepStmt.setDate(1, f_ntof);
            prepStmt.setInt(2, f.getK_numidf());
            prepStmt.setString(3, f.getK_tipoidf());
            prepStmt.setString(4, f.getN_nombre1f());
            prepStmt.setString(5, f.getN_nombre2f());
            prepStmt.setString(6, f.getN_ap1f());
            prepStmt.setString(7, f.getN_ap2f());
            prepStmt.setString(8, f.getO_parentesco());
            prepStmt.setString(9, f.getK_tipo());
            prepStmt.setInt(10, f.getK_num());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("FamiliarDAO", "No se pudo crear el familiar " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarFamiliar() {

    }

    public void eliminarFamiliar() {

    }

    public void buscarFamiliar() throws CaException {
        try {
            String strSQL = "SELECT *  FROM familiar WHERE k_numidf = ? AND k_tipoidf = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStrm = conexion.prepareStatement(strSQL);

            prepStrm.setInt(1, f.getK_numidf());
            prepStrm.setString(2, f.getK_tipoidf());
            ResultSet rs = prepStrm.executeQuery();
            while (rs.next()) {
                Date f_nto = rs.getDate(1);
                f.setF_ntof(f_nto.toString());
                f.setK_numidf(rs.getInt(2));
                f.setK_tipoidf(rs.getString(3));
                f.setN_nombre1f(rs.getString(4));
                f.setN_nombre2f(rs.getString(5));
                f.setN_ap1f(rs.getString(6));
                f.setN_ap2f(rs.getString(7));
                f.setO_parentesco(rs.getString(8));
                f.setK_tipo(rs.getString(9));
                f.setK_num(rs.getInt(10));
            }
        } catch (SQLException e) {
            throw new CaException("FamiliarDAO", "No se pudo obtener el familiar " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarFamiliar() {

    }

    public Familiar getF() {
        return f;
    }

    public void setF(Familiar f) {
        this.f = f;
    }

}
