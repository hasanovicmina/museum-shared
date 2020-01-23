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
public class Ulaznica extends OpstiDomenskiObjekat{
    private int ulaznicaID;
    private Date datum;
    private Double cena;
    private Zaposleni zaposleni;
    private Izlozba izlozba;

    public Ulaznica() {
    }

    public Ulaznica(int ulaznicaID, Date datum, Double cena, Zaposleni zaposleni, Izlozba izlozba) {
        this.ulaznicaID = ulaznicaID;
        this.datum = datum;
        this.cena = cena;
        this.zaposleni = zaposleni;
        this.izlozba = izlozba;
    }

    public Izlozba getIzlozba() {
        return izlozba;
    }

    public void setIzlozba(Izlozba izlozba) {
        this.izlozba = izlozba;
    }

    public int getUlaznicaID() {
        return ulaznicaID;
    }

    public void setUlaznicaID(int ulaznicaID) {
        this.ulaznicaID = ulaznicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    @Override
    public String vratiNazivTabele() {
       return "ulaznica";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int ulaznicaID = rs.getInt("UlaznicaID");
                Date datum = rs.getDate("Datum");
                Double cena = rs.getDouble("Cena");
                int zaposleniID = rs.getInt("ZaposleniID");
                int izlozbaID = rs.getInt("IzlozbaID");
             
                Zaposleni z = new Zaposleni();
                z.setZaposleniID(zaposleniID);
                Izlozba i = new Izlozba();
                i.setIzlozbaID(izlozbaID);
                
                Ulaznica ulaznica = new Ulaznica(ulaznicaID, datum, cena, z, i);
                
                lista.add(ulaznica);

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
        return "'" + new java.sql.Date(datum.getTime()) + "','" + cena + "','" + zaposleni.getZaposleniID() + "','" + izlozba.getIzlozbaID() + "'";
      
    }

    @Override
    public String vratiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneInsert() {
        return " (Datum,Cena,ZaposleniID,IzlozbaID) ";
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
