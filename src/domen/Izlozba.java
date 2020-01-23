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
public class Izlozba extends OpstiDomenskiObjekat{
    
    private int izlozbaID;
    private String naziv;
    private String tip;
    private Date datumOd;
    private Date datumDo;
    private ArrayList<Postavka> listaPostavki;

    public Izlozba() {
    }

    public Izlozba(int izlozbaID, String naziv, String tip, Date datumOd, Date datumDo) {
        this.izlozbaID = izlozbaID;
        this.naziv = naziv;
        this.tip = tip;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public ArrayList<Postavka> getListaPostavki() {
        return listaPostavki;
    }

    public void setListaPostavki(ArrayList<Postavka> listaPostavki) {
        this.listaPostavki = listaPostavki;
    }

 
    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public int getIzlozbaID() {
        return izlozbaID;
    }

    public void setIzlozbaID(int izlozbaID) {
        this.izlozbaID = izlozbaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }
    
    
    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "izlozba";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
          ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while(rs.next()){
                int izlozbaID = rs.getInt("IzlozbaID");
                String naziv = rs.getString("Naziv");
                String tip = rs.getString("Tip");
                Date datumOd = rs.getDate("DatumOd");
                Date datumDo = rs.getDate("DatumDo");
                
                Izlozba i = new Izlozba(izlozbaID, naziv, tip, datumOd, datumDo);
                
                lista.add(i);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista; 
    }

    @Override
    public String vratiUslovWhere() {
         if(!naziv.isEmpty() && izlozbaID<0){
            return "where Naziv LIKE '%"+naziv+"%'";
        }
        if (izlozbaID  < 0 && !tip.isEmpty()) {
            return "where Tip LIKE '%" + tip + "%'";
        }
        if (izlozbaID > 0) {
            return " where IzlozbaID = '" +izlozbaID + "'";
        }

        return ""; 
    }

    @Override
    public String vratiZaInsert() {
        if (tip.equals("privremena")) {
            return "'" + naziv + "','" + tip + "','" + new java.sql.Date(datumOd.getTime()) + "','" + new java.sql.Date(datumDo.getTime()) + "'";
        } else if(tip.equals("stalna")) {
            return "'" + naziv + "','" + tip + "',NULL,NULL";
        }
        return "";
        
    }

    @Override
    public String vratiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneInsert() {
        return " (Naziv,Tip,DatumOd,DatumDo) ";
    }

    @Override
    public String uzmiID() {
        return "IzlozbaID";
    }

    @Override
    public String vratiUslovZaID() {
        return "";
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        int id = 0;
        try {
            /*   int slobodanID = 0;
            List<Integer> listaID = new ArrayList<>();
            
            try {
            while (rs.next()) {
            int id = rs.getInt("IzlozbaID");
            listaID.add(id);
            }
            } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (listaID.size() == 0) {
            return 1;
            }
            for (int i = 0; i <listaID.size(); i++) {
            if ((i + 1) == listaID.size()) {
            return listaID.get(i) + 1;
            } else if ((listaID.get(i) + 1) < listaID.get(i + 1)) {
            return listaID.get(i) + 1;
            }
            }
            return slobodanID;*/
            
            while (rs.next()) {
                id = rs.getInt("auto_increment");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Izlozba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiPK() {
        return "IzlozbaID = '"+izlozbaID+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajJoinRs(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> listaDela = new ArrayList<>();
        try {
            while(rs.next()){
                int deloID = rs.getInt("ID");
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

  
    
    
}
