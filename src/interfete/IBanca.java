package interfete;

import clase.Credit;
import clase.Persoana;

import java.util.HashMap;
import java.util.List;

public interface IBanca {

    public Credit acordareCredit(float suma, int perioada, Persoana pers,TipCredit tip);

    public Credit acordareCredit(float suma, Persoana pers,TipCredit tip);

    public TipRating calculareRatingClient(Persoana pers);

    public HashMap<Persoana,Credit> getListaCrediteAcordate();

    public void preluareIstoricCrediteDinBD();


}
