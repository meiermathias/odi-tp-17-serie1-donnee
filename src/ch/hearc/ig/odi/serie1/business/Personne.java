package ch.hearc.ig.odi.serie1.business;

import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Personne {

    private String nom;
    private String prenom;
    private Date dateDeNaissance;

    public Personne() {
    }

    public Personne(String prenom, String nom, Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }

    public String sePresenter(){
        return "Bonjour, je m'appelle " + this.prenom + " " + this.nom;
    }

    public long monAge(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dateDeNaissance);

        LocalDate date = 
                         LocalDate.of(calendar.get(Calendar.YEAR),
                                      calendar.get(Calendar.MONTH), 
                                      calendar.get(Calendar.DAY_OF_MONTH));

        LocalDate current = LocalDate.now();
        
        long age = ChronoUnit.YEARS.between(date, current);

        return age; 

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
