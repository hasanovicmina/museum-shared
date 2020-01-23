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
public class ClanskaKarta extends OpstiDomenskiObjekat{
    
    private int clanskaKartaID;
    private String imePrezime;
    private String posebnaKategorija;
    private Date datumVazenja;
    private int zaposleniID;

    public ClanskaKarta() {
    }

    public ClanskaKarta(int clanskaKartaID, String imePrezime, String posebnaKategorija, Date datumVazenja, int zaposleniID) {
        this.clanskaKartaID = clanskaKartaID;
        this.imePrezime = imePrezime;
        this.posebnaKategorija = posebnaKategorija;
        this.datumVazenja = datumVazenja;
        this.zaposleniID = zaposleniID;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    

    public int getClanskaKartaID() {
        return clanskaKartaID;
    }

    public void setClanskaKartaID(int clanskaKartaID) {
        this.clanskaKartaID = clanskaKartaID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getPosebnaKategorija() {
        return posebnaKategorija;
    }

    public void setPosebnaKategorija(String posebnaKategorija) {
        this.posebnaKategorija = posebnaKategorija;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    @Override
    public String vratiNazivTabele() {
        return "clanskakarta";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while(rs.next()){
                int clanskaKartaID = rs.getInt("ClanskaKartaID");
                String imePrezime = rs.getString("ImePrezime");
                String kategorija = rs.getString("PosebnaKategorija");
                Date datumVazenja = rs.getDate("DatumVazenja");
                int zaposleni = rs.getInt("ZaposleniID");
                
                ClanskaKarta ck = new ClanskaKarta(clanskaKartaID, imePrezime, kategorija, datumVazenja, zaposleni);
                
                lista.add(ck);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista; 
    }

    @Override
    public String vratiUslovWhere() {
        if (posebnaKategorija.equals("")) {
            return "WHERE ImePrezime LIKE '%" + imePrezime + "%'";
        } 
        if(imePrezime.equals("")){
            return "WHERE PosebnaKategorija LIKE '%" + posebnaKategorija + "%'";
        }
        if(clanskaKartaID > 0){
            return "WHERE ClanskaKartaID = '"+clanskaKartaID+"' ";
        }
        return "";
    }

    @Override
    public String vratiZaInsert() {
        return "'" + imePrezime + "','" + posebnaKategorija + "','" + new java.sql.Date(datumVazenja.getTime()) + "','" + zaposleniID + "'";
    }

    @Override
    public String vratiZaUpdate() {
        return "ImePrezime='" + imePrezime +"',PosebnaKategorija='"+posebnaKategorija+"',DatumVazenja='"+new java.sql.Date(datumVazenja.getTime())+"',ZaposleniID='"+zaposleniID+"'";
    }

    @Override
    public String vratiKoloneInsert() {
        return " (ImePrezime,PosebnaKategorija,DatumVazenja,ZaposleniID) ";
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
        return "ClanskaKartaID='" + clanskaKartaID + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajJoinRs(ResultSet vratiJoin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
