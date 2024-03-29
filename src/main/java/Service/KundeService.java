package Service;

import Entity.Kunde;

import java.util.Scanner;

public class KundeService extends Kunde {
    private Kunde kunde = new Kunde();
    private double kontoStand = kunde.getKonto();

    public void einlogen(String iban, String password) {
        int attempt = 0;
        while (attempt < 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Bitte geben Sie ihre IBAN Nummer ein: ");
            iban = scan.next();
            System.out.println("Bitte geben Sie ihr Password ein: ");
            password = scan.next();

            if (!iban.equals(kunde.getIban()) || !password.equals(kunde.getPaassWord())) {
                System.out.println("Leider das Einloggen nicht erfolgreich!");
                if (kunde.getPaassWord().equals(" ") && kunde.getPaassWord().length() < 4);
                System.out.println("Ihr Passwort darf nicht leer Zeichen haben und muss mindestens 4 Zeichen sein!");
                attempt++;
            } else {

                System.out.println("Sie haben erfolgreich eingeloggt!");
                vollBild();
            }
        }
        System.out.println("Sie haben 3-mal mit falschen Daten versucht. Versuchen Sie später nochmals Bitte!");
    }


    public void vollBild() {
        System.out.println("\n Bitte wählen Sie eine Funktion aus" + "\n Geld Einzahlen: 1" + "\n Kontozustand :  2"
                + "\n Geld Auszahlen :  3" + "\n Password Ändern : 4" + "\n Geld Senden: 5" + "\n Exit : 6");
        int nummer = 0;
        Scanner scan = new Scanner(System.in);
        nummer = scan.nextInt();
        switch (nummer) {
            case 1:
                geldEinzahlen();
                break;
            case 2:
                kontostand();
                break;
            case 3:
                geldAuszahlen();
                break;
            case 4:
                passwordAndern();
                break;
            case 5:
                geldSenden();
                break;
            case 6:
                exit();
                break;
            default:
                    System.out.println("Falsche auswahl! Bitte nochmal auswählen");
                vollBild();
        }
    }

    public void geldEinzahlen() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte zahlen Sie ihr Geld ein: ");
        double einzahltGeld = scan.nextDouble();
        kontoStand = einzahltGeld + kunde.getKonto();
        System.out.println("Kontostand ist " + kontoStand + " EUR");
        vollBild();

    }

    public void geldAuszahlen() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viel Geld möchten Sie haben: ");
        double auszahltGeld = scan.nextDouble();
        if (auszahltGeld > kontoStand) {
            System.out.println("Leider Sie haben kein " + auszahltGeld + "eur auf Ihrem Konto.! " +
                    "\nGeben Sie Bitte gültig Betrag ein oder zuerst Geld auf Ihr Konto einzahlen!");
            vollBild();
        } else {

            kontoStand = kontoStand - auszahltGeld;
            System.out.println("Ihr Kontostand ist: " + kontoStand + " EUR");
            vollBild();
        }

    }

    public void kontostand() {
        System.out.println("Ihr Kontostand ist " + kontoStand + " EUR");
        vollBild();
    }

    public void passwordAndern() {
        System.out.println("Geben Sie Bitte ihr password ein!");
        Scanner scan = new Scanner(System.in);
        String passwordKontrol = scan.next();
        if (passwordKontrol.equals(kunde.getPaassWord())) {
            System.out.println("Geben Sie Bitte neu Password ein");
            String nuePassword = scan.next();
            kunde.setPaassWord(nuePassword);

            System.out.println("Ihr Neu Password ist: " + kunde.getPaassWord());
            vollBild();
        }
    }

    public void geldSenden() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viel Geld möchten Sie senden: ");
        while (!scan.hasNextDouble()){
            System.out.println("Leider Falsche Daten eingegeben!");
            vollBild();
        }

        double sendGeld = scan.nextDouble();
        System.out.println("Bitte geben Sie Ihre Iban-Adresse ein: ");
        String ibanEmpänger = scan.next();
        if (sendGeld >kontoStand){
            System.out.println("Leider Sie haben kein "+sendGeld +"eur auf Ihrem Konto! " +
                    "\nGeben Sie Bitte gültig Betrag ein!\n");
            vollBild();
        }else if(sendGeld <= 0 ){
            System.out.println("Ungültige Betrag eingegeben!");
        }else {
            System.out.println("Ihr angegebene Betrag wurde erfolgreich gesendet!");
            kontoStand = kontoStand - sendGeld;
            System.out.println("Ihr Konto stand ist: " + kontoStand + " EUR");
            vollBild();
        }

    }

    public void exit() {
        System.out.println("Sie haben erfolgreich ausgeloggt");
        System.exit(0);

    }

    public static void main(String[] args) {
        KundeService k = new KundeService();
        k.einlogen("DE98765432", "2468");
    }

}