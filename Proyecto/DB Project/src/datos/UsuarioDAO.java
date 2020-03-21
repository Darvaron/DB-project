/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el usuario (Simulación de seguridad)
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Usuario;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class UsuarioDAO {

    private Usuario u;

    public UsuarioDAO() {
        this.u = new Usuario();
    }

    public void buscarUsuario() throws CaException {
        try {
            String strSQL = "SELECT * FROM usuario WHERE k_idu = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, u.getK_idu());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                u.setK_idu(rs.getInt(1));
                u.setO_rol(rs.getString(2));
                u.setO_pass(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new CaException("UsuarioDAO", "No se pudo obtener el usuario " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    
    

}
