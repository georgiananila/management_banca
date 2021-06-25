package clase;

import interfete.TipDobanda;

public final class CreditGaudeamus extends Credit{

    private float DAE;
     private static String numeCredit="Credit Gaudeamus";
    public CreditGaudeamus(float sumaRamasa, int perioadaRamasa, float dobanda, TipDobanda tipDobanda) {
        super(sumaRamasa, perioadaRamasa, dobanda, tipDobanda);
        DAE=dobanda+(float)12.38;
    }

    public float getDAE() {
        return DAE;
    }

    public void setDAE(float DAE) {
        this.DAE = DAE;
    }

    @Override
    public String toString() {
        return "CreditGaudeamus{" +
                "DAE=" + DAE +
                '}';
    }

    @Override
    public boolean plataAnticipata(float sumaPlatitaInAvans) {
        if(sumaPlatitaInAvans<10000){
            return false;//nu se poate efectua
        }
        return true;
    }

    @Override
    public float calculareRataPerLuna() {
        float rata;
        if(this.perioadaRamasa<=5){
            return rata=(this.sumaRamasa/this.perioadaRamasa)-100;
        }else if(this.perioadaRamasa<=2)
            return rata=(this.sumaRamasa/this.perioadaRamasa)-50;
        return rata=this.sumaRamasa/this.perioadaRamasa;
    }
}
