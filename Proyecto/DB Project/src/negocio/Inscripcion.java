/*
 * Descripción: Clase que encapsula los datos de la inscripción
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Inscripcion {

    private int k_ins;
    private String i_estadoi;
    private double v_ins;
    private String f_inscrip;
    private boolean o_asiste;
    private String k_tipo;
    private int k_num;
    private int k_code;
    
    public Inscripcion() {
    }

    
    
    public int getK_ins() {
        return k_ins;
    }

    public void setK_ins(int k_ins) {
        this.k_ins = k_ins;
    }

    public String getI_estadoi() {
        return i_estadoi;
    }

    public void setI_estadoi(String i_estadoi) {
        this.i_estadoi = i_estadoi;
    }

    public double getV_ins() {
        return v_ins;
    }

    public void setV_ins(double v_ins) {
        this.v_ins = v_ins;
    }

    public String getF_inscrip() {
        return f_inscrip;
    }

    public void setF_inscrip(String f_inscrip) {
        this.f_inscrip = f_inscrip;
    }

    public void setO_asiste(boolean o_asiste) {
        this.o_asiste = o_asiste;
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
    
    public boolean getO_asiste(){
        return o_asiste;
    }

    public void setK_num(int k_num) {
        this.k_num = k_num;
    }

    public int getK_code() {
        return k_code;
    }

    public void setK_code(int k_code) {
        this.k_code = k_code;
    }
    
}
