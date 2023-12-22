package com.cyr.smartchecking.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "person_table")
public class Person {
 // @ColumnInfo(name = "person_id")
  @PrimaryKey(autoGenerate = true)
  public int id;
  @ColumnInfo(name = "name")
  public String name;
  @ColumnInfo(name = "sname")
  public String sname;
  @ColumnInfo(name = "status")
  public String status;
  @ColumnInfo(name = "scan")
  public String scan;
  @ColumnInfo(name = "motif")
  public String motif;
  @ColumnInfo(name = "carte")
  public String carte;
  @ColumnInfo(name = "hentre")
  public String hentre;
  @ColumnInfo(name = "hsortie")
  public String hsortie;
  @ColumnInfo(name = "photo")
  public int photo;
  @ColumnInfo(name = "nbrPersonne")
  public String nbrPersonne;
  @ColumnInfo(name = "organisation")
  public String organisation;
  @ColumnInfo(name = "datelivr")
  public String datelivr;
  @ColumnInfo(name = "datexpir")
  public String datexpir;
  public Person() {
  }
  public Person(int id, String name, String sname, String status,
                String scan, String motif, String carte, String hentre,
                String hsortie, int photo, String nbrPersonne,
                String organisation, String datelivr, String datexpir) {
        this.id = id;
        this.name = name;
        this.sname = sname;
        this.status = status;
        this.scan = scan;
        this.motif = motif;
        this.carte = carte;
        this.hentre = hentre;
        this.hsortie = hsortie;
        this.photo = photo;
        this.nbrPersonne = nbrPersonne;
        this.organisation = organisation;
        this.datelivr = datelivr;
        this.datexpir = datexpir;
  }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public String getHentre() {
        return hentre;
    }

    public void setHentre(String hentre) {
        this.hentre = hentre;
    }

    public String getHsortie() {
        return hsortie;
    }

    public void setHsortie(String hsortie) {
        this.hsortie = hsortie;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNbrPersonne() {
        return nbrPersonne;
    }

    public void setNbrPersonne(String nbrPersonne) {
        this.nbrPersonne = nbrPersonne;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getDatelivr() {
        return datelivr;
    }

    public void setDatelivr(String datelivr) {
        this.datelivr = datelivr;
    }

    public String getDatexpir() {
        return datexpir;
    }

    public void setDatexpir(String datexpir) {
        this.datexpir = datexpir;
    }
}
