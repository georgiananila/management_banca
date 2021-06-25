package clase;

import interfete.ICredit;
import interfete.TipDobanda;

public abstract class  Credit implements ICredit {
    protected float sumaRamasa;
    protected int perioadaRamasa;
    protected float dobanda;
    protected TipDobanda tipDobanda;

    public Credit(float sumaRamasa, int perioadaRamasa, float dobanda, TipDobanda tipDobanda) {
        this.sumaRamasa = sumaRamasa;
        this.perioadaRamasa = perioadaRamasa;
        this.dobanda = dobanda;
        this.tipDobanda = tipDobanda;
    }

    public  boolean plataAnticipata(float sumaPlatitaInAvans){
        if(sumaPlatitaInAvans<=sumaRamasa){
            sumaRamasa-=sumaPlatitaInAvans;
        }
        else
        {
            sumaRamasa=0;
        }
        return true;
    }

    public float getSumaRamasa() {
        return sumaRamasa;
    }

    public void setSumaRamasa(float sumaRamasa) {
        this.sumaRamasa = sumaRamasa;
    }

    public int getPerioadaRamasa() {
        return perioadaRamasa;
    }

    public void setPerioadaRamasa(int perioadaRamasa) {
        this.perioadaRamasa = perioadaRamasa;
    }

    public float getDobanda() {
        return dobanda;
    }

    public void setDobanda(float dobanda) {
        this.dobanda = dobanda;
    }

    public TipDobanda getTipDobanda() {
        return tipDobanda;
    }

    public void setTipDobanda(TipDobanda tipDobanda) {
        this.tipDobanda = tipDobanda;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "sumaRamasa=" + sumaRamasa +
                ", perioadaRamasa=" + perioadaRamasa +
                ", dobanda=" + dobanda +
                ", tipDobanda=" + tipDobanda +
                '}';
    }
}
