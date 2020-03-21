/*
 * Descripción: Clase cntrola para gestiones relaciones con la inscripcion
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
public class GestorInscripcion {

    private InscripcionDAO inscripcionDAO;
    private PagoIDAO pagoIDAO;
    private DetalleInscripcionDAO detalleInscripcionDAO;

    public GestorInscripcion() {
        this.inscripcionDAO = new InscripcionDAO();
        this.pagoIDAO = new PagoIDAO();
        this.detalleInscripcionDAO = new DetalleInscripcionDAO();
    }

    public void incluirInscripcion()throws CaException{
        inscripcionDAO.incluirInscripcion();
    }
    public void incluirPagoI()throws CaException{
        pagoIDAO.incluirPagoI();
    }
    public void incluirDetalleInscripcion()throws CaException{
        detalleInscripcionDAO.incluirDetalleInscripcion();
    }
    public void buscarInscripcion()throws CaException{
        inscripcionDAO.buscarInscripcion();
    }
    public void buscarPagoI()throws CaException{
        pagoIDAO.buscarPagoI();
    }
    public void buscarDetalleInscripcion()throws CaException{
        detalleInscripcionDAO.buscarDetalleInscripcion();
    }
    
    public InscripcionDAO getInscripcionDAO() {
        return inscripcionDAO;
    }

    public void setInscripcionDAO(InscripcionDAO inscripcionDAO) {
        this.inscripcionDAO = inscripcionDAO;
    }

    public PagoIDAO getPagoIDAO() {
        return pagoIDAO;
    }

    public void setPagoIDAO(PagoIDAO pagoIDAO) {
        this.pagoIDAO = pagoIDAO;
    }

    public DetalleInscripcionDAO getDetalleInscripcionDAO() {
        return detalleInscripcionDAO;
    }

    public void setDetalleInscripcionDAO(DetalleInscripcionDAO detalleInscripcionDAO) {
        this.detalleInscripcionDAO = detalleInscripcionDAO;
    }

}
