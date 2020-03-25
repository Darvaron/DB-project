/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el evento
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Evento;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class EventoDAO {

    private Evento ev;

    public EventoDAO() {
        this.ev = new Evento();
    }

    public void incluirEvento() throws CaException {
        try {
            System.out.println(ev.getF_cancelmax());
            String f = ev.getF_cancelmax();
            java.sql.Date.valueOf(f);
            String strSQL = "INSERT INTO evento VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareCall(strSQL);

            //Fechas
            /*String[] f_can = ev.getF_cancelmax().split("-");
            Date f_cancelmax = new Date(Integer.parseInt(f_can[0]), Integer.parseInt(f_can[1]), Integer.parseInt(f_can[2]));
            String[] f_ini = ev.getF_ini().split("-");
            Date f_inic = new Date(Integer.parseInt(f_ini[0]), Integer.parseInt(f_ini[1]), Integer.parseInt(f_ini[2]));
            String[] f_f = ev.getF_fin().split("-");
            Date f_fin = new Date(Integer.parseInt(f_f[0]), Integer.parseInt(f_f[1]), Integer.parseInt(f_f[2]));
            String[] f_max = ev.getF_maxins().split("-");
            Date f_maxins = new Date(Integer.parseInt(f_max[0]), Integer.parseInt(f_max[1]), Integer.parseInt(f_max[2]));
            String[] f_ci = ev.getF_cierre().split("-");
            Date f_cierre = new Date(Integer.parseInt(f_ci[0]), Integer.parseInt(f_ci[1]), Integer.parseInt(f_ci[2]));
             */
            prepStmt.setString(1, ev.getI_estado());
            prepStmt.setInt(2, ev.getQ_cupo());
            prepStmt.setDouble(3, ev.getV_total());
            prepStmt.setInt(4, ev.getK_code());
            prepStmt.setBoolean(5, ev.isO_tieneins());
            prepStmt.setDate(6, java.sql.Date.valueOf(ev.getF_cancelmax()));
            prepStmt.setString(7, ev.getN_lugar());
            prepStmt.setString(8, ev.getO_descripcion());
            prepStmt.setString(9, ev.getN_nombrev());
            prepStmt.setDate(10, java.sql.Date.valueOf(ev.getF_ini()));
            prepStmt.setDate(11, java.sql.Date.valueOf(ev.getF_fin()));
            prepStmt.setDate(12, java.sql.Date.valueOf(ev.getF_maxins()));
            prepStmt.setString(13, ev.getO_obser());
            prepStmt.setInt(14, ev.getQ_cupodisp());
            prepStmt.setDate(15, java.sql.Date.valueOf(ev.getF_cierre()));
            prepStmt.setBoolean(16, ev.isSobrecupo());
            prepStmt.setInt(17, ev.getK_idt());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo crear el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarEvento() {

    }

    public void eliminarEvento() {

    }

    public void buscarEvento() throws CaException {
        try {
            String strSQL = "SELECT * FROM evento WHERE k_code = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareCall(strSQL);

            prepStmt.setInt(1, ev.getK_code());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                ev.setI_estado(rs.getString(1));
                ev.setQ_cupo(rs.getInt(2));
                ev.setV_total(rs.getDouble(3));
                ev.setK_code(rs.getInt(4));
                ev.setO_tieneins(rs.getBoolean(5));
                Date f_can = rs.getDate(6);
                ev.setF_cancelmax(f_can.toString());
                ev.setN_lugar(rs.getString(7));
                ev.setO_descripcion(rs.getString(8));
                ev.setN_nombrev(rs.getString(9));
                Date f_ini = rs.getDate(10);
                ev.setF_ini(f_ini.toString());
                Date f_fin = rs.getDate(11);
                ev.setF_fin(f_fin.toString());
                Date f_maxins = rs.getDate(12);
                ev.setF_maxins(f_maxins.toString());
                ev.setO_obser(rs.getString(13));
                ev.setQ_cupodisp(rs.getInt(14));
                Date f_cierre = rs.getDate(15);
                ev.setF_cierre(f_cierre.toString());
                ev.setSobrecupo(rs.getBoolean(16));
                ev.setK_idt(rs.getInt(17));
            }

        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo obtener el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarCupo() throws CaException {
        try {
            String strSQL = "UPDATE evento SET q_cupodisp = q_cupodisp-1 WHERE k_code=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, ev.getK_code());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo obtener el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public int buscarCupos() throws CaException {
        try {
            int i = 0;
            String strSQL = "SELECT q_cupodisp FROM evento WHERE k_code = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareCall(strSQL);

            prepStmt.setInt(1, ev.getK_code());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
            return i;
        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo obtener el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void cerrarEvento() throws CaException {
        try {
            String strSQL = "UPDATE evento SET estado = 'C' WHERE k_code = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, ev.getK_code());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo obtener el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public String consultarEstadisticas() throws CaException {
        String fila= "";
        try {
            String strSQL = "SELECT evento.k_code, v_total, q_cupo, (q_cupo-q_cupodisp), ((q_cupo-q_cupodisp)*v_ins) FROM evento, inscripcion "
                    + "WHERE evento.k_code= ? and evento.k_code=inscripcion.k_code ORDER BY evento.k_code" ;
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareCall(strSQL);
            prepStmt.setInt(1, ev.getK_code());
            ResultSet rs = prepStmt.executeQuery();
            rs.first();
            while(rs.next()){
                fila = rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5);
            }
            return fila;
        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se pudo obtener el evento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Evento getEv() {
        return ev;
    }

    public void setEv(Evento ev) {
        this.ev = ev;
    }

}
