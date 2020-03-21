/*
 * Descripción: Clase que encapsula los datos del pago de la inscripción
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class PagoI {

    private int k_idpi;
    private String f_pagopi;
    private String o_fpagoi;
    private double v_inspi;
    private int k_ins;

    public PagoI() {
    }

    public int getK_idpi() {
        return k_idpi;
    }

    public void setK_idpi(int k_idpi) {
        this.k_idpi = k_idpi;
    }

    public String getF_pagopi() {
        return f_pagopi;
    }

    public void setF_pagopi(String f_pagopi) {
        this.f_pagopi = f_pagopi;
    }

    public String getO_fpagoi() {
        return o_fpagoi;
    }

    public void setO_fpagoi(String o_fpagoi) {
        this.o_fpagoi = o_fpagoi;
    }

    public double getV_inspi() {
        return v_inspi;
    }

    public void setV_inspi(double v_inspi) {
        this.v_inspi = v_inspi;
    }

    public int getK_ins() {
        return k_ins;
    }

    public void setK_ins(int k_ins) {
        this.k_ins = k_ins;
    }

}
