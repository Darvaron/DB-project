/*
 * Descripción: Clase que encapsula los datos del usuario (Simulación de seguridad)
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Usuario {

    private int k_idu;
    private String o_rol;
    private String o_pass;
    
    public Usuario() {
    }

    public int getK_idu() {
        return k_idu;
    }

    public void setK_idu(int k_idu) {
        this.k_idu = k_idu;
    }

    public String getO_rol() {
        return o_rol;
    }

    public void setO_rol(String o_rol) {
        this.o_rol = o_rol;
    }

    public String getO_pass() {
        return o_pass;
    }

    public void setO_pass(String o_pass) {
        this.o_pass = o_pass;
    }

}
