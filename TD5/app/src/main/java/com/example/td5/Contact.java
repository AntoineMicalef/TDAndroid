package com.example.td5;

public class Contact {
    private String nom;
    private String prenom;
    private String URLImage;

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getURLImage() {
        return URLImage;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }

    public Contact(String nom, String prenom, String URL){
        this.nom=nom;
        this.prenom=prenom;
        this.URLImage=URL;
    }
}
