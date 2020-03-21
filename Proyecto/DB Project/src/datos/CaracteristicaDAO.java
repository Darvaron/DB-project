/*
 * Descripción: Clase que encapsula el acceso a la base de datos para las caracteristicas
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.*;
import negocio.Caracteristica;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class CaracteristicaDAO {

    private Caracteristica car;

    public CaracteristicaDAO() {
        this.car = new Caracteristica();
    }

    /**
     * Incluye una nueva fila en la tabla caracteristica
     *
     * @throws CaException
     */
    public void incluirCaracteristica() throws CaException {
        try {
            String strSQL = "INSERT INTO caracteristica VALUES (?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, car.getK_codev());
            prepStmt.setDouble(2, car.getP_subsidio());
            prepStmt.setString(3, car.getO_tipopag());
            prepStmt.setInt(4, car.getQ_cuotasmax());
            prepStmt.setDouble(5, car.getV_copago());
            prepStmt.setInt(6, car.getK_code());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("CaracteristicaDAO", "No se pudo crear la caracteristica " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarCaracteristica() {

    }

    public void eliminarCaracteristica() {

    }

    public void buscarCaracteristica() throws CaException {
        try {
            String strSQL = "SELECT * FROM caracteristica WHERE k_codev = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();

            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, car.getK_codev());
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                car.setK_codev(rs.getInt(1));
                car.setP_subsidio(rs.getDouble(2));
                car.setO_tipopag(rs.getString(3));
                car.setQ_cuotasmax(rs.getInt(4));
                car.setV_copago(rs.getDouble(5));
                car.setK_code(rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new CaException("CatacteristicaDAO", "No se pudo obtener la caracteristica " + e.getMessage());
        }
    }

    public void actualizarCaracteristica(){

    }

    public Caracteristica getCar() {
        return car;
    }

    public void setCar(Caracteristica car) {
        this.car = car;
    }

}
