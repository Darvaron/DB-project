/*
 * Descripción: Clase cntrola para gestiones relaciones con el evento
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

import datos.*;
import util.CaException;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class GestorEvento {

    private EventoDAO eventoDAO;
    private TipoDAO tipoDAO;
    private ProveedorDAO proveedorDAO;
    private PagoPDAO pagoPDAO;
    private CaracteristicaDAO caracteristicaDAO;

    public GestorEvento() {
        this.eventoDAO = new EventoDAO();
        this.tipoDAO = new TipoDAO();
        this.proveedorDAO = new ProveedorDAO();
        this.pagoPDAO = new PagoPDAO();
        this.caracteristicaDAO = new CaracteristicaDAO();
    }

    public void incluirEvento() throws CaException {
        eventoDAO.incluirEvento();
    }

    public void incluirTipo() throws CaException {
        tipoDAO.incluirTipo();
    }

    public void incluirProveedor() throws CaException {
        proveedorDAO.incluirProveedor();
    }

    public void incluirPagoP() throws CaException {
        pagoPDAO.incluirPagoP();
    }

    public void incluirCaracteristica() throws CaException {
        caracteristicaDAO.incluirCaracteristica();
    }

    public void buscarEvento() throws CaException {
        eventoDAO.buscarEvento();
    }

    public void buscarTipo() throws CaException {
        tipoDAO.buscarTipo();
    }

    public void buscarProveedor() throws CaException {
        proveedorDAO.buscarProveedor();
    }

    public void buscarPagoP() throws CaException {
        pagoPDAO.buscarPagoP();
    }

    public void buscarCaracteristica() throws CaException {
        caracteristicaDAO.buscarCaracteristica();
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public TipoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public ProveedorDAO getProveedorDAO() {
        return proveedorDAO;
    }

    public void setProveedorDAO(ProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }

    public PagoPDAO getPagoPDAO() {
        return pagoPDAO;
    }

    public void setPagoPDAO(PagoPDAO pagoPDAO) {
        this.pagoPDAO = pagoPDAO;
    }

    public CaracteristicaDAO getCaracteristicaDAO() {
        return caracteristicaDAO;
    }

    public void setCaracteristicaDAO(CaracteristicaDAO caracteristicaDAO) {
        this.caracteristicaDAO = caracteristicaDAO;
    }

}
