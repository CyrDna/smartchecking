package com.cyr.smartchecking;

public class Person {
  private String name;
  private String status;
  private String scan;
  private String motif;
  private String carte;
  private String hentre;
  private String hsortie;
  private int photo;
  private String nbrPersonne;
  private String organisation;



  public Person(String name, String status, String scan, String motif,
                String carte, String hentre, String hsortie, int photo,
                String nbrPersonne, String organisation) {
    this.name = name;
    this.status = status;
    this.scan = scan;
    this.motif = motif;
    this.carte = carte;
    this.hentre = hentre;
    this.hsortie = hsortie;
    this.photo = photo;
    this.nbrPersonne = nbrPersonne;
    this.organisation = organisation;
  }

  public String getName() {
    return name;
  }
  public String getStatus() {
    return status;
  }
  public String getScan() {
    return scan;
  }
  public String getMotif() {
    return motif;
  }
  public String getCarte() {
    return carte;
  }
  public String getHentre() {
    return hentre;
  }
  public String getHsortie() {
    return hsortie;
  }
  public int getPhoto() {
    return photo;
  }
  public String getNbrPersonne() {
    return nbrPersonne;
  }
  public String getOrganisation() {
    return organisation;
  }

}
