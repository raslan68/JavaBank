package Entity;

public class Kunde {

    private String iban = "DE9876543";
    private String paassWord = "2468";
    private Double konto = (double) 0;

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

    public Double getKonto() {
        return konto;
    }

}
