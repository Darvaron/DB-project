/*
 * Descripción: Clase que encapsula los datos del pago al proveedor
 * Autores: David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
package negocio;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares, Jhon
 * Eddi Malagaon Gonzales, Mateo Ardilla Bulla
 */
public class PagoP {

    private int k_idpp;
    private String f_pagop;
    private String o_formapp;
    private int k_idp;

    public PagoP() {
    }

    public int getK_idpp() {
        return k_idpp;
    }

    public void setK_idpp(int k_idpp) {
        this.k_idpp = k_idpp;
    }

    public String getF_pagop() {
        return f_pagop;
    }

    public void setF_pagop(String f_pagop) {
        this.f_pagop = f_pagop;
    }

    public String getO_formapp() {
        return o_formapp;
    }

    public void setO_formapp(String o_formapp) {
        this.o_formapp = o_formapp;
    }

    public int getK_idp() {
        return k_idp;
    }

    public void setK_idp(int k_idp) {
        this.k_idp = k_idp;
    }

}
