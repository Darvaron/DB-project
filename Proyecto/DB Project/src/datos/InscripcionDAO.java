/*
 * Descripción: Clase que encapsula el acceso a la base de datos para la inscripcion
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import java.util.ArrayList;
import negocio.Familiar;
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

            prepStmt.setInt(1, ins.getK_ins());
            prepStmt.setString(2, ins.getI_estadoi());
            prepStmt.setDouble(3, ins.getV_ins());
            prepStmt.setBoolean(4, ins.getO_asiste());
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

    public ArrayList<String[]> buscarFamiliarInscrito() throws CaException {
        try {
            ArrayList<String[]> familiares = new ArrayList();
            String strSQL = "SELECT k_ins, n_nombre1f, n_ap1f, familiar.k_numidf FROM familiar,detalleinscripcion WHERE detalleinscripcion.k_numidf = familiar.k_numidf AND k_ins = ? ";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStrm = conexion.prepareStatement(strSQL);

            prepStrm.setInt(1, ins.getK_ins());
            ResultSet rs = prepStrm.executeQuery();
            int aux = 0;
            while (rs.next()) {
                familiares.add(new String[4]);
                familiares.get(aux)[0] = ("" + rs.getString(1));
                familiares.get(aux)[1] = ("" + rs.getString(2));
                familiares.get(aux)[2] = (rs.getString(3));
                familiares.get(aux)[3] = ("" + rs.getString(4));
                aux++;
            }
            return familiares;
        } catch (SQLException e) {
            throw new CaException("FamiliarDAO", "No se pudo obtener el familiar " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public ArrayList<Inscripcion> buscarInscripcionAso() throws CaException {
        try {
            String strSQL = "SELECT * FROM inscripcion WHERE k_code = ? AND k_num= ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, ins.getK_code());
            prepStmt.setInt(2, ins.getK_num());
            ResultSet rs = prepStmt.executeQuery();
            ArrayList<Inscripcion> insc = new ArrayList();
            int aux = 0;

            while (rs.next()) {
                insc.add(new Inscripcion());
                insc.get(aux).setK_ins(rs.getInt(1));
                insc.get(aux).setI_estadoi(rs.getString(2));
                insc.get(aux).setV_ins(rs.getDouble(3));
                Date f_ins = rs.getDate(4);
                insc.get(aux).setF_inscrip(f_ins.toString());
                insc.get(aux).setO_asiste(rs.getBoolean(5));
                insc.get(aux).setK_tipo(rs.getString(6));
                insc.get(aux).setK_num(rs.getInt(7));
                insc.get(aux).setK_code(rs.getInt(8));
                aux++;
            }
            return insc;
        } catch (SQLException e) {
            throw new CaException("InscripcionDAO", "No se pudo obtener la inscripcion " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public ArrayList<Inscripcion> buscarInscripcion() throws CaException {
        try {
            String strSQL = "SELECT * FROM inscripcion WHERE k_code = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, ins.getK_code());
            ResultSet rs = prepStmt.executeQuery();
            ArrayList<Inscripcion> insc = new ArrayList();
            int aux = 0;

            while (rs.next()) {
                insc.add(new Inscripcion());
                insc.get(aux).setK_ins(rs.getInt(1));
                insc.get(aux).setI_estadoi(rs.getString(2));
                insc.get(aux).setV_ins(rs.getDouble(3));
                Date f_ins = rs.getDate(4);
                insc.get(aux).setF_inscrip(f_ins.toString());
                insc.get(aux).setO_asiste(rs.getBoolean(5));
                insc.get(aux).setK_tipo(rs.getString(6));
                insc.get(aux).setK_num(rs.getInt(7));
                insc.get(aux).setK_code(rs.getInt(8));
                aux++;
            }
            return insc;
        } catch (SQLException e) {
            throw new CaException("InscripcionDAO", "No se pudo obtener la inscripcion " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarInscripcionPrincipal() throws CaException {
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

    public void actualizarPagoInscripcion() throws CaException {
        try {
            String strSQL = "UPDATE inscripcion SET v_ins = v_ins + ? WHERE k_ins = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setDouble(1, ins.getV_ins());
            prepStmt.setInt(2, ins.getK_ins());
            

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("InscripcionDAO", "No se pudo crear la inscripción " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Inscripcion getIns() {
        return ins;
    }

    public void setIns(Inscripcion ins) {
        this.ins = ins;
    }

}
