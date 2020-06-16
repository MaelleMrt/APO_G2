package princetonPlainsboro;

public class Date implements Comparable {
    private int jour;
    private int mois;
    private int annee;
    private int heure; 
    private int minutes; 
    
    public Date(int jour, int mois, int annee, int heure, int minutes) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure= heure; 
        this.minutes=minutes; 
        }
    
    public String toString() {
        return jour + "/" + mois + "/" + annee + " à "+ heure +":"+minutes;
        }
    
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date)o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour)&& (heure == d.heure)&&(minutes==d.minutes);
            }
        else
            return false;
        }
    
    // precondition : 'o' est une instance de 'Date' :
    public int compareTo(Object o) {
        Date d = (Date)o;
        if (annee != d.annee)
            return annee - d.annee;
        // ici on a forcement annee == d.annee :
        if (mois != d.mois)
            return mois  - d.mois;
        // ici on a forcement annee == d.annee et mois == d.mois :
        if (heure != d.heure)
            return heure - d.heure; 
        // ici on a forcement heure == d.heure, idem pour année et mois
        if (minutes != d.minutes)
            return minutes - d.minutes; 
        // ici on a forcement minute == d.minute idem pour heure, année et mois
        
        return jour - d.jour;
        }
    
    }
