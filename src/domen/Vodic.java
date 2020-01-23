/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasan
 */
public class Vodic extends OpstiDomenskiObjekat {
    private int vodicID;
    private String imePrezime;
    private Date datumVodjenja;
    private int izlozbaID;

    public Vodic() {
    }

    public Vodic(int vodicID, String imePrezime, Date datumVodjenja, int izlozbaID) {
        this.vodicID = vodicID;
        this.imePrezime = imePrezime;
        this.datumVodjenja = datumVodjenja;
        this.izlozbaID = izlozbaID;
    }

   

   

    public Date getDatumVodjenja() {
        return datumVodjenja;
    }

    public void setDatumVodjenja(Date datumVodjenja) {
        this.datumVodjenja = datumVodjenja;
    }

    public int getVodicID() {
        return vodicID;
    }

    public void setVodicID(int vodicID) {
        this.vodicID = vodicID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
    
   
 

    @Override
    public String toString() {
        return imePrezime; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "vodic";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int vodicID = rs.getInt("VodicID");
                String imePrezime = rs.getString("ImePrezime");
                Date datumVodjenja = rs.getDate("DatumVodjenja");
                int izlozbaID = rs.getInt("IzlozbaID");

                Vodic vodic = new Vodic(vodicID, imePrezime, datumVodjenja, izlozbaID);

                lista.add(vodic);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String vratiUslovWhere() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (datumVodjenja != null) {
            String datum = sdf.format(datumVodjenja);
            return "WHERE DatumVodjenja = '" + datum + "' ";
        }
        if (izlozbaID != -1) {
            return "WHERE IzlozbaID = '" + izlozbaID + "' ";
        }

        return "";
    }

    @Override
    public String vratiZaInsert() {
        return "'" + imePrezime + "','" + new java.sql.Date(datumVodjenja.getTime()) + "','" + izlozbaID + "'";
    }

    @Override
    public String vratiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneInsert() {
        return " (ImePrezime,DatumVodjenja,IzlozbaID) ";
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

    public int getIzlozbaID() {
        return izlozbaID;
    }

    public void setIzlozbaID(int izlozbaID) {
        this.izlozbaID = izlozbaID;
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
