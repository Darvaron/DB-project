/*
 * Descripción: Clase que encapsula los datos del proveedor
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Proveedor {

    private int k_idp;
    private String n_nombrep;
    private int o_telp;
    private String n_callep;
    private String n_nump;
    private String n_barriop;
    private String n_ciudadp;
    private String n_compp;
    private int k_code;
    
    public Proveedor() {
    }

    public int getK_idp() {
        return k_idp;
    }

    public void setK_idp(int k_idp) {
        this.k_idp = k_idp;
    }

    public String getN_nombrep() {
        return n_nombrep;
    }

    public void setN_nombrep(String n_nombrep) {
        this.n_nombrep = n_nombrep;
    }

    public int getO_telp() {
        return o_telp;
    }

    public void setO_telp(int o_telp) {
        this.o_telp = o_telp;
    }

    public String getN_callep() {
        return n_callep;
    }

    public void setN_callep(String n_callep) {
        this.n_callep = n_callep;
    }

    public String getN_nump() {
        return n_nump;
    }

    public void setN_nump(String n_nump) {
        this.n_nump = n_nump;
    }

    public String getN_barriop() {
        return n_barriop;
    }

    public void setN_barriop(String n_barriop) {
        this.n_barriop = n_barriop;
    }

    public String getN_ciudadp() {
        return n_ciudadp;
    }

    public void setN_ciudadp(String n_ciudadp) {
        this.n_ciudadp = n_ciudadp;
    }

    public String getN_compp() {
        return n_compp;
    }

    public void setN_compp(String n_compp) {
        this.n_compp = n_compp;
    }

    public int getK_code() {
        return k_code;
    }

    public void setK_code(int k_code) {
        this.k_code = k_code;
    }

}
