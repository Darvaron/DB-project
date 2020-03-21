/*
 * Descripción: Clase que encapsula los datos del evento
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class Evento {

    private String i_estado;
    private int q_cupo;
    private double v_total;
    private int k_code;
    private boolean o_tieneins;
    private String f_cancelmax;
    private String n_lugar;
    private String o_descripcion;
    private String n_nombrev;
    private String f_ini;
    private String f_fin;
    private String f_maxins;
    private String o_obser;
    private int q_cupodisp;
    private String f_cierre;
    private boolean sobrecupo;
    private int k_idt;
    private String vscp;
    private String tcopag;

    public Evento() {
    }

    public String getI_estado() {
        return i_estado;
    }

    public void setI_estado(String i_estado) {
        this.i_estado = i_estado;
    }

    public int getQ_cupo() {
        return q_cupo;
    }

    public void setQ_cupo(int q_cupo) {
        this.q_cupo = q_cupo;
    }

    public double getV_total() {
        return v_total;
    }

    public void setV_total(double v_total) {
        this.v_total = v_total;
    }

    public int getK_code() {
        return k_code;
    }

    public void setK_code(int k_code) {
        this.k_code = k_code;
    }

    public boolean isO_tieneins() {
        return o_tieneins;
    }

    public void setO_tieneins(boolean o_tieneins) {
        this.o_tieneins = o_tieneins;
    }

    public String getF_cancelmax() {
        return f_cancelmax;
    }

    public void setF_cancelmax(String f_cancelmax) {
        this.f_cancelmax = f_cancelmax;
    }

    public String getN_lugar() {
        return n_lugar;
    }

    public void setN_lugar(String n_lugar) {
        this.n_lugar = n_lugar;
    }

    public String getO_descripcion() {
        return o_descripcion;
    }

    public void setO_descripcion(String o_descripcion) {
        this.o_descripcion = o_descripcion;
    }

    public String getN_nombrev() {
        return n_nombrev;
    }

    public void setN_nombrev(String n_nombrev) {
        this.n_nombrev = n_nombrev;
    }

    public String getF_ini() {
        return f_ini;
    }

    public void setF_ini(String f_ini) {
        this.f_ini = f_ini;
    }

    public String getF_fin() {
        return f_fin;
    }

    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    public String getF_maxins() {
        return f_maxins;
    }

    public void setF_maxins(String f_maxins) {
        this.f_maxins = f_maxins;
    }

    public String getO_obser() {
        return o_obser;
    }

    public void setO_obser(String o_obser) {
        this.o_obser = o_obser;
    }

    public int getQ_cupodisp() {
        return q_cupodisp;
    }

    public void setQ_cupodisp(int q_cupodisp) {
        this.q_cupodisp = q_cupodisp;
    }

    public String getF_cierre() {
        return f_cierre;
    }

    public void setF_cierre(String f_cierre) {
        this.f_cierre = f_cierre;
    }

    public boolean isSobrecupo() {
        return sobrecupo;
    }

    public void setSobrecupo(boolean sobrecupo) {
        this.sobrecupo = sobrecupo;
    }

    public int getK_idt() {
        return k_idt;
    }

    public void setK_idt(int k_idt) {
        this.k_idt = k_idt;
    }

    public String getVscp() {
        if(isSobrecupo()==true){
            this.vscp="Si";
        }else{
            this.vscp="No";
        } 
        return vscp;
    }

    public void setVscp(String vscp) {
        this.vscp = vscp;
    }

    public String getTcopag() {
        if(isO_tieneins()==true){
            this.tcopag="Si";
        }else{
            this.tcopag="No";
        } 
        return tcopag;
    }

    public void setTcopag(String tcopag) {
        this.tcopag = tcopag;
    }
    
    
    
    
}
