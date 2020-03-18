/*
 * Descripción: Clase que encapsula los datos del tipo de evento
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Tipo {

    private int k_idt;
    private String n_nombre;

    public Tipo() {
    }

    public int getK_idt() {
        return k_idt;
    }

    public void setK_idt(int k_idt) {
        this.k_idt = k_idt;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

}
