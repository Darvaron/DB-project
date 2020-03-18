/*
 * Descripción: Clase que encapsula los datos de la caracteristica
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardila Bulla
 */
public class Caracteristica {

    private int k_codev;
    private double p_subsidio;
    private char o_tipopag;
    private int q_cuotasmax;
    private double v_copago;
    private int k_code;

    public Caracteristica() {
    }

    public int getK_codev() {
        return k_codev;
    }

    public void setK_codev(int k_codev) {
        this.k_codev = k_codev;
    }

    public double getP_subsidio() {
        return p_subsidio;
    }

    public void setP_subsidio(double p_subsidio) {
        this.p_subsidio = p_subsidio;
    }

    public char getO_tipopag() {
        return o_tipopag;
    }

    public void setO_tipopag(char o_tipopag) {
        this.o_tipopag = o_tipopag;
    }

    public int getQ_cuotasmax() {
        return q_cuotasmax;
    }

    public void setQ_cuotasmax(int q_cuotasmax) {
        this.q_cuotasmax = q_cuotasmax;
    }

    public double getV_copago() {
        return v_copago;
    }

    public void setV_copago(double v_copago) {
        this.v_copago = v_copago;
    }

    public int getK_code() {
        return k_code;
    }

    public void setK_code(int k_code) {
        this.k_code = k_code;
    }

}
