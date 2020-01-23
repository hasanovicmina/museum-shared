/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author hasan
 */
public abstract class OpstiDomenskiObjekat implements Serializable{
    public abstract String vratiNazivTabele();
    public abstract List<OpstiDomenskiObjekat> ucitajRS(ResultSet rs);
    public abstract String vratiUslovWhere();
    public abstract String vratiZaInsert();
    public abstract String vratiZaUpdate();
    public abstract String vratiKoloneInsert();
    public abstract String uzmiID();
    public abstract String vratiUslovZaID();
    public abstract int vratiSlobodanID(ResultSet rs);
    public abstract String vratiPK();
    public abstract List<OpstiDomenskiObjekat> ucitajJoinRs(ResultSet vratiJoin);
    
    
    
}
