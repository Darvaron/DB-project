/*
 * Descripción: Clase que encapsula los datos del familiar
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Familiar {

    private String f_ntof;
    private String k_tipoidf;
    private String n_nombre1f;
    private String n_nombre2f;
    private String n_ap1f;
    private String n_ap2f;
    private String o_parentesco;
    private String k_tipo;
    private int k_num;
    private int k_numidf;
    
    public Familiar() {
    }

    public int getK_numidf() {
        return k_numidf;
    }

    public void setK_numidf(int k_numidf) {
        this.k_numidf = k_numidf;
    }
    
    public String getF_ntof() {
        return f_ntof;
    }

    public void setF_ntof(String f_ntof) {
        this.f_ntof = f_ntof;
    }

    public String getK_tipoidf() {
        return k_tipoidf;
    }

    public void setK_tipoidf(String k_tipoidf) {
        this.k_tipoidf = k_tipoidf;
    }

    public String getN_nombre1f() {
        return n_nombre1f;
    }

    public void setN_nombre1f(String n_nombre1f) {
        this.n_nombre1f = n_nombre1f;
    }

    public String getN_nombre2f() {
        return n_nombre2f;
    }

    public void setN_nombre2f(String n_nombre2f) {
        this.n_nombre2f = n_nombre2f;
    }

    public String getN_ap1f() {
        return n_ap1f;
    }

    public void setN_ap1f(String n_ap1f) {
        this.n_ap1f = n_ap1f;
    }

    public String getN_ap2f() {
        return n_ap2f;
    }

    public void setN_ap2f(String n_ap2f) {
        this.n_ap2f = n_ap2f;
    }

    public String getO_parentesco() {
        return o_parentesco;
    }

    public void setO_parentesco(String o_parentesco) {
        this.o_parentesco = o_parentesco;
    }

    public String getK_tipo() {
        return k_tipo;
    }

    public void setK_tipo(String k_tipo) {
        this.k_tipo = k_tipo;
    }

    public int getK_num() {
        return k_num;
    }

    public void setK_num(int k_num) {
        this.k_num = k_num;
    }
    
}
