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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasan
 */
public class Delo extends OpstiDomenskiObjekat{
    private int deloID;
    private String naziv;
    private String autor;
    private String tip;

    public Delo() {
    }

    public Delo(int deloID, String naziv, String autor, String tip) {
        this.deloID = deloID;
        this.naziv = naziv;
        this.autor = autor;
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDeloID() {
        return deloID;
    }

    public void setDeloID(int deloID) {
        this.deloID = deloID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return naziv + ", "+tip; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "delo";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> listaDela = new ArrayList<>();
        try {
            while(rs.next()){
                int deloID = rs.getInt("DeloID");
                String naziv = rs.getString("Naziv");
                String autor = rs.getString("Autor");
                String tip =  rs.getString("Tip");
                
                Delo delo = new Delo(deloID, naziv, autor, tip);
                listaDela.add(delo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Delo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska u Result Set-u za ucitavanje liste dela.");
        }
        return listaDela;
    }

    @Override
    public String vratiUslovWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
