package Entity;

import java.math.BigDecimal;

public class Kunde {

    private String iban = "DE98765432";
    private String paassWord = "2468";
    private double konto =  0.0;

    public Kunde() {
    }

    public Kunde(String iban, String paassWord) {
        this.iban = iban;
        this.paassWord = paassWord;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setPaassWord(String paassWord) {
        this.paassWord = paassWord;
    }

    public String getIban() {
        return iban;
    }

    public String getPaassWord() {
        return paassWord;
    }

    public double getKonto() {
        return konto;
    }

}
