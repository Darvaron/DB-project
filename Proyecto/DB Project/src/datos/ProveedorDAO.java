/*
 * Descripción: Clase que encapsula el acceso a la base de datos para el proveedor
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Proveedor;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class ProveedorDAO {

    private Proveedor pr;

    public ProveedorDAO() {
        this.pr = new Proveedor();
    }

    public void incluirProveedor()throws CaException{
        try {
            String strSQL = "INSERT INTO proveedor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, pr.getK_idp());
            prepStmt.setString(2, pr.getN_nombrep());
            prepStmt.setInt(3, pr.getO_telp());
            prepStmt.setString(4, pr.getN_callep());
            prepStmt.setString(5, pr.getN_nump());
            prepStmt.setString(6, pr.getN_barriop());
            prepStmt.setString(7, pr.getN_ciudadp());
            prepStmt.setString(8, pr.getN_compp());
            prepStmt.setInt(9, pr.getK_code());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("ProveedorDAO", "No se pudo crear el proveedor " +e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void modificarProveedor(){
        
    }
    
    public void eliminarProveedor(){
        
    }
    
    public void buscarProveedor()throws CaException{
        try {
            String strSQL = "SELECT * FROM proveedor WHERE = k_idp = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, pr.getK_idp());
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                pr.setK_idp(rs.getInt(1));
                pr.setN_nombrep(rs.getString(2));
                pr.setO_telp(rs.getInt(3));
                pr.setN_callep(rs.getString(4));
                pr.setN_nump(rs.getString(5));
                pr.setN_barriop(rs.getString(6));
                pr.setN_ciudadp(rs.getString(7));
                pr.setN_compp(rs.getString(8));
                pr.setK_code(rs.getInt(9));
            }
        } catch (SQLException e) {
            throw new CaException("ProveedorDAO", "No se pudo obtener el proveedor " + e.getMessage());
        }
    }
    
    public void actualizarProveedor(){
        
    }

    public Proveedor getPr() {
        return pr;
    }

    public void setPr(Proveedor pr) {
        this.pr = pr;
    }

}
