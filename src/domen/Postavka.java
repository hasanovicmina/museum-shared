/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasan
 */
public class Postavka extends OpstiDomenskiObjekat{
    
    private Izlozba izlozba;
    private Delo delo;
    private String opis;
    private int sala;
    private int sprat;

    public Postavka() {
    }

    public Postavka(Izlozba izlozba, Delo delo, String opis, int sala, int sprat) {
        this.izlozba = izlozba;
        this.delo = delo;
        this.opis = opis;
        this.sala = sala;
        this.sprat = sprat;
    }

 

   

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Izlozba getIzlozba() {
        return izlozba;
    }

    public void setIzlozba(Izlozba izlozba) {
        this.izlozba = izlozba;
    }

    public Delo getDelo() {
        return delo;
    }

    public void setDelo(Delo delo) {
        this.delo = delo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

       public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }
    

    @Override
    public String vratiNazivTabele() {
       return "postavka";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int izlozbaID = rs.getInt("IzlozbaID");
                int delo = rs.getInt("DeloID");
                String opis = rs.getString("Opis");
                int sprat = rs.getInt("Sprat");
                int sala = rs.getInt("Sala");
               
                Izlozba i = new Izlozba();
                i.setIzlozbaID(izlozbaID);
                Delo d = new Delo();
                d.setDeloID(delo);

                Postavka p = new Postavka(i, d, opis, sala, sprat);
                
                lista.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String vratiUslovWhere() {
        return "WHERE IzlozbaID = '"+izlozba.getIzlozbaID()+"'";
    }

    @Override
    public String vratiZaInsert() {
         return "'" + izlozba.getIzlozbaID() + "','" + delo.getDeloID() + "','" + opis + "','" + sala + "','" + sprat + "'";
       
    }

    @Override
    public String vratiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneInsert() {
        return " (IzlozbaID,DeloID,Opis,Sala,Sprat) ";
    }

    @Override
    public String uzmiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajJoinRs(ResultSet vratiJoin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
