/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasan
 */
public class Zaposleni extends OpstiDomenskiObjekat{
    private int zaposleniID;
    private String imePrezime;
    private String korisnickoIme;
    private String korisnickaLozinka;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String imePrezime, String korisnickoIme, String korisnickaLozinka) {
        this.zaposleniID = zaposleniID;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaLozinka = korisnickaLozinka;
    }

    public String getKorisnickaLozinka() {
        return korisnickaLozinka;
    }

    public void setKorisnickaLozinka(String korisnickaLozinka) {
        this.korisnickaLozinka = korisnickaLozinka;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return korisnickoIme; //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.korisnickaLozinka, other.korisnickaLozinka)) {
            return false;
        }
        return true;
    }

  
    
    
    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        List<OpstiDomenskiObjekat> listaZaposlenih = new ArrayList<>();
       
            try {
                while(rs.next()){
                int zaposleniID = rs.getInt("ZaposleniID");
                String imePrezime = rs.getString("ImePrezime");
                String korisnickoIme = rs.getString("KorisnickoIme");
                String lozinka = rs.getString("KorisnickaLozinka");
                Zaposleni z = new Zaposleni(zaposleniID, imePrezime, korisnickoIme, lozinka);
                listaZaposlenih.add(z);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Zaposleni.class.getName()).log(Level.SEVERE, null, ex);
            }
        return listaZaposlenih;
    }

    @Override
    public String vratiUslovWhere() {
        return " where KorisnickoIme = '" + korisnickoIme + "' and KorisnickaLozinka = '" + korisnickaLozinka + "'";
    }

    @Override
    public String vratiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
