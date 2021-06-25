package clase;

import interfete.TipDobanda;

public final class CreditNevoiPersonale extends Credit {

    private float DAE;
    private static String numeCredit="Credit Nevoi Personale";

    public CreditNevoiPersonale(float sumaRamasa, int perioadaRamasa, float dobanda, TipDobanda tipDobanda) {
        super(sumaRamasa, perioadaRamasa, dobanda, tipDobanda);
        DAE=dobanda+(float)7.61;
    }

    public float getDAE() {
        return DAE;
    }

    public void setDAE(float DAE) {
        this.DAE = DAE;
    }

    @Override
    public String toString() {
        return "CreditNevoiPersonale{" +
                "DAE=" + DAE +
                '}';
    }

    @Override
    public boolean plataAnticipata(float sumaPlatitaInAvans) {
        if(sumaPlatitaInAvans<5000){
            return false;//nu se poate efectua
        }
        return true;

    }

    @Override
    public float calculareRataPerLuna() {
        float rata;
       if(this.perioadaRamasa<=5){
           return rata=(this.sumaRamasa/this.perioadaRamasa)-100;
       }
       return rata=this.sumaRamasa/this.perioadaRamasa;
    }
}
