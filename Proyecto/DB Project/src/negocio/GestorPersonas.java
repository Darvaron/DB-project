/*
 * Descripción: Clase cntrola para gestiones relaciones con las "personas"
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
public class GestorPersonas {

    private UsuarioDAO usuarioDAO;
    private AsociadoDAO asociadoDAO;
    private FamiliarDAO familiarDAO;

    public GestorPersonas() {
        this.usuarioDAO = new UsuarioDAO();
        this.asociadoDAO = new AsociadoDAO();
        this.familiarDAO = new FamiliarDAO();
    }

    public void incluirAsociado() throws CaException {
        asociadoDAO.incluirAsociado();
    }

    public void incluirFamiliar() throws CaException {
        familiarDAO.incluirFamiliar();
    }

    public void buscarUsuario() throws CaException {
        usuarioDAO.buscarUsuario();
    }

    public void buscarAsociado() throws CaException {
        asociadoDAO.buscarAsociado();
    }

    public void buscarFamiliar() throws CaException {
        familiarDAO.buscarFamiliar();
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public AsociadoDAO getAsociadoDAO() {
        return asociadoDAO;
    }

    public void setAsociadoDAO(AsociadoDAO asociadoDAO) {
        this.asociadoDAO = asociadoDAO;
    }

    public FamiliarDAO getFamiliarDAO() {
        return familiarDAO;
    }

    public void setFamiliarDAO(FamiliarDAO familiarDAO) {
        this.familiarDAO = familiarDAO;
    }

}
