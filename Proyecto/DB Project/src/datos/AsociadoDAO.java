/*
 * Descripción: Clase que encapsula el acceso a la base de datos para Asociado
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import negocio.Asociado;
import util.CaException;
import util.ServiceLocator;
import java.sql.*;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class AsociadoDAO {

    private Asociado as;

    public AsociadoDAO() {
        as = new Asociado();
    }

    /**
     * Incluye una nueva fila en la tabla asociado.
     *
     * @throws CaException
     */
    public void incluirAsociado() throws CaException {
        try {
            String srtSQL = "INSERT INTO asociado VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(srtSQL);

            //Obtiene las fechas
            String[] f_af = as.getF_afiliacion().split("/");
            Date f_afiliacion = new Date(Integer.parseInt(f_af[0]), Integer.parseInt(f_af[1]), Integer.parseInt(f_af[2]));
            String[] f_nto = as.getF_nto().split("/");
            Date f_nac = new Date(Integer.parseInt(f_nto[0]), Integer.parseInt(f_nto[1]), Integer.parseInt(f_nto[2]));

            prepStmt.setInt(1, as.getO_tel());
            prepStmt.setDate(2, f_afiliacion);
            prepStmt.setDouble(3, as.getV_sueldo());
            prepStmt.setDate(4, f_nac);
            prepStmt.setString(5, as.getK_tipo());
            prepStmt.setInt(6, as.getK_num());
            prepStmt.setString(7, as.getN_nombre1());
            prepStmt.setString(8, as.getN_nombre2());
            prepStmt.setString(9, as.getN_ap1());
            prepStmt.setString(10, as.getN_ap2());
            prepStmt.setString(11, as.getI_genero());
            prepStmt.setString(12, as.getO_calle());
            prepStmt.setString(13, as.getO_num());
            prepStmt.setString(14, as.getO_barrio());
            prepStmt.setString(15, as.getO_ciudad());
            prepStmt.setString(16, as.getO_complemento());
            prepStmt.setString(17, as.getO_email());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("AsociadoDAO", "No se pudo crear el asociado " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarAsociado() {

    }

    public void eliminarAsociado() {

    }

    public void buscarAsociado() throws CaException {
        try {
            String strSQL = "SELECT * FROM asociado WHERE k_tipo = ? AND k_num = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, as.getK_tipo());
            prepStmt.setInt(2, as.getK_num());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                as.setO_tel(rs.getInt(1));
                Date f_af = rs.getDate(2);
                as.setF_afiliacion(f_af.toString());
                as.setV_sueldo(rs.getDouble(3));
                Date f_nac = rs.getDate(4);
                as.setF_nto(f_nac.toString());
                as.setK_tipo(rs.getString(5));
                as.setK_num(rs.getInt(6));
                as.setN_nombre1(rs.getString(7));
                as.setN_nombre2(rs.getString(8));
                as.setN_ap1(rs.getString(9));
                as.setN_ap2(rs.getString(10));
                as.setI_genero(rs.getString(11));
                as.setO_calle(rs.getString(12));
                as.setO_num(rs.getString(13));
                as.setO_barrio(rs.getString(14));
                as.setO_ciudad(rs.getString(15));
                as.setO_complemento(rs.getString(16));
                as.setO_email(rs.getString(17));
            }
        } catch (SQLException e) {
            throw new CaException("AsociadoDAO", "No se pudo obtener el asociado "+e.getMessage());
        }
    }
    
    public void actualizarAsociado(){
        
    }

    public Asociado getAs() {
        return as;
    }

    public void setAs(Asociado as) {
        this.as = as;
    }
    
}
