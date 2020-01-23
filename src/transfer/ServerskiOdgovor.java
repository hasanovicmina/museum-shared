/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author hasan
 */
public class ServerskiOdgovor implements Serializable{
    private int operacija;
    private Object parametar;
    private String poruka;
    private boolean uspesno;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int operacija, Object parametar, String poruka, boolean uspesno) {
        this.operacija = operacija;
        this.parametar = parametar;
        this.poruka = poruka;
        this.uspesno = uspesno;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
}
