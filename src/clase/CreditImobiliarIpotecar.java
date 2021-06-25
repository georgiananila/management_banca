package clase;

import interfete.TipDobanda;
import interfete.TipImobil;

public final class CreditImobiliarIpotecar extends CreditIpotecar {

    private static String numeCredit="Credit Imobiliar Ipotecar";
    private float valoareImobil;
    private TipImobil tipImobil;


    public CreditImobiliarIpotecar(float sumaRamasa, int perioadaRamasa, float dobanda, TipDobanda tipDobanda) {
        super(sumaRamasa, perioadaRamasa, dobanda, tipDobanda);
        valoareImobil=1000000;
        tipImobil=TipImobil.Casa;
    }

    public static String getNumeCredit() {
        return numeCredit;
    }

    public static void setNumeCredit(String numeCredit) {
        CreditImobiliarIpotecar.numeCredit = numeCredit;
    }

    public float getValoareImobil() {
        return valoareImobil;
    }

    public void setValoareImobil(float valoareImobil) {
        this.valoareImobil = valoareImobil;
    }

    public TipImobil getTipImobil() {
        return tipImobil;
    }

    public void setTipImobil(TipImobil tipImobil) {
        this.tipImobil = tipImobil;
    }


    @Override
    public String toString() {
        return "CreditImobiliarIpotecar{" +
                "valoareImobil=" + valoareImobil +
                ", tipImobil=" + tipImobil +
                '}';
    }
}
