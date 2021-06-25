package clase;

import interfete.TipDobanda;

public final class CreditPrimaCasa extends Credit {

    private float DAE;
    private int maximLuniNeplata;
    private static String numeCredit="Credit Prima Casa";

    public CreditPrimaCasa(float sumaRamasa, int perioadaRamasa, float dobanda, TipDobanda tipDobanda) {
        super(sumaRamasa, perioadaRamasa, dobanda, tipDobanda);
        DAE=dobanda+(float)3.94;
        maximLuniNeplata=6;

    }

    public float getDAE() {
        return DAE;
    }

    public void setDAE(float DAE) {
        this.DAE = DAE;
    }

    public int getMaximLuniNeplata() {
        return maximLuniNeplata;
    }

    public void setMaximLuniNeplata(int maximLuniNeplata) {
        this.maximLuniNeplata = maximLuniNeplata;
    }

    @Override
    public String toString() {
        return "CreditPrimaCasa{" +
                "DAE=" + DAE +
                ", maximLuniNeplata=" + maximLuniNeplata +
                '}';
    }

    @Override
    public boolean plataAnticipata(float sumaPlatitaInAvans) {
        if(sumaPlatitaInAvans<15000){
            return false;//nu se poate efectua
        }
        return true;
    }

    @Override
    public float calculareRataPerLuna() {
        float rata;
        if(this.perioadaRamasa<=20){
            return rata=(this.sumaRamasa/this.perioadaRamasa)-10000;
        }else if(this.perioadaRamasa<=15){
            return rata=(this.sumaRamasa/this.perioadaRamasa)-5000;
        }else if(this.perioadaRamasa<=10)
            return rata=(this.sumaRamasa/this.perioadaRamasa)-1500;
        return rata=this.sumaRamasa/this.perioadaRamasa;
    }
}
