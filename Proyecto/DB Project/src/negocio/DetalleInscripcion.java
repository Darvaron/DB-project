/*
 * Descripción: Clase que encapsula los datos de los detalles de la inscripción
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardila Bulla
 */
public class DetalleInscripcion {

    private int k_iddi;
    private int k_ins;
    private int k_numidf;
    private String k_tipoidf;

    public DetalleInscripcion() {
    }

    public int getK_iddi() {
        return k_iddi;
    }

    public void setK_iddi(int k_iddi) {
        this.k_iddi = k_iddi;
    }

    public int getK_ins() {
        return k_ins;
    }

    public void setK_ins(int k_ins) {
        this.k_ins = k_ins;
    }

    public int getK_numidf() {
        return k_numidf;
    }

    public void setK_numidf(int k_numidf) {
        this.k_numidf = k_numidf;
    }

    public String getK_tipoidf() {
        return k_tipoidf;
    }

    public void setK_tipoidf(String k_tipoidf) {
        this.k_tipoidf = k_tipoidf;
    }

}
