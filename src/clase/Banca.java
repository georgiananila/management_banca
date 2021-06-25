package clase;

import interfete.IBanca;
import interfete.TipCredit;
import interfete.TipDobanda;
import interfete.TipRating;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banca implements IBanca {

    private HashMap<Persoana,Credit> listaCrediteAcordate;
    private List<Credit> istoricCredite;
    private String denumireBanca;
    private String locatieBanca;
    private float cursValutarEuro;
    private float cursValutarDolar;

    public static Connection ConnectBD(String pUser, String pPassword) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setPassword(pPassword);
        ods.setUser(pUser);
        ods.setURL("jdbc:oracle:thin:@//193.226.34.57:1521/oradb");
        return ods.getConnection();
    }

    public Banca( String denumireBanca, String locatieBanca, float cursValutarEuro, float cursValutarDolar) {
        this.listaCrediteAcordate=new HashMap<>();
        this.istoricCredite=new ArrayList<>();
        this.denumireBanca = denumireBanca;
        this.locatieBanca = locatieBanca;
        this.cursValutarEuro = cursValutarEuro;
        this.cursValutarDolar = cursValutarDolar;
    }

    @Override
    public Credit acordareCredit(float suma, int perioada, Persoana pers, TipCredit tip) {
       Credit c = null;
       TipRating r=this.calculareRatingClient(pers);
       if(r==TipRating.V) {
           switch (tip) {
               case CREDIT_NEVOI_PERSONALE:
                   c = new CreditNevoiPersonale(suma, perioada, (float) 2.87, TipDobanda.DOBANDA_FIXA);
                   break;
               case CREDIT_IPOTECAR:
                   c = new CreditIpotecar(suma, perioada, (float) 3.98, TipDobanda.DOBANDA_VARIABILA);
                   break;
               case CREDIT_PRIMA_CASA:
                   c = new CreditPrimaCasa(suma, perioada, (float) 2.97, TipDobanda.DOBANDA_FIXA);
                   break;
               case CREDIT_IPOTECAR_IMOBILIAR:
                   c = new CreditImobiliarIpotecar(suma, perioada, (float) 3.5, TipDobanda.DOBANDA_VARIABILA);
                   break;
               case CREDIT_GAUDEAMUS:
                   c = new CreditGaudeamus(suma, perioada, (float) 1.67, TipDobanda.DOBANDA_FIXA);
                   break;
               default:
                   System.out.println("Tipul de credit nu exista!");
           }
       }
        if(c!=null){
            this.listaCrediteAcordate.put(pers,c);
        }
        return c;
    }

    //aici se va acorda creditele pe perioada standard de 10 ani
    @Override
    public Credit acordareCredit(float suma, Persoana pers, TipCredit tip) {
        Credit c = null;
        TipRating r=this.calculareRatingClient(pers);
        if(r==TipRating.V) {
            switch (tip) {
                case CREDIT_NEVOI_PERSONALE:
                    c = new CreditNevoiPersonale(suma, 10, (float) 2.87, TipDobanda.DOBANDA_FIXA);
                    break;
                case CREDIT_IPOTECAR:
                    c = new CreditIpotecar(suma, 10, (float) 3.98, TipDobanda.DOBANDA_VARIABILA);
                    break;
                case CREDIT_PRIMA_CASA:
                    c = new CreditPrimaCasa(suma, 10, (float) 2.97, TipDobanda.DOBANDA_FIXA);
                    break;
                case CREDIT_IPOTECAR_IMOBILIAR:
                    c = new CreditImobiliarIpotecar(suma, 10, (float) 3.5, TipDobanda.DOBANDA_VARIABILA);
                    break;
                case CREDIT_GAUDEAMUS:
                    c = new CreditGaudeamus(suma, 10, (float) 1.67, TipDobanda.DOBANDA_FIXA);
                    break;
                default:
                    System.out.println("Tipul de credit nu exista!");
            }
        }
        if(c!=null){
            this.listaCrediteAcordate.put(pers,c);
        }
        return c;
    }

    @Override
    public TipRating calculareRatingClient(Persoana pers) {
        if(pers.isAngajat()==false){
            return TipRating.R;
        }else if(pers.isAngajat()==true&& pers.getSalariu()<2000&& pers.getVarsta()>55) {
            return TipRating.R;
        }else if(pers.isAngajat()==true && pers.getSalariu()<2000){
            return TipRating.A;
        }else if(pers.isAngajat()==true&& pers.getSalariu()>=2000 && pers.getVarsta()>55){
            return TipRating.R;
        }else if(pers.isAngajat()==true&&pers.getSalariu()>=2000&& pers.getVarsta()<55){
            return TipRating.V;
        }
        return TipRating.A;
    }

    @Override
    public HashMap<Persoana, Credit> getListaCrediteAcordate() {
        return this.listaCrediteAcordate;
    }

    @Override
    public void preluareIstoricCrediteDinBD() {
        Connection conn;
        try {
            conn=ConnectBD("BDSA_NILAG","STUD");
            Statement stmtStud = conn.createStatement();
            String queryStudenti = "select id_credit,suma,perioada,dobanda,tipDobanda,tipCredit from istoric_credite";
            ResultSet resultCredite = stmtStud.executeQuery(queryStudenti);

           // LinkedList<Student> listaStudenti = new LinkedList<Student>();
            while (resultCredite.next()){
                int id_credit = resultCredite.getInt("ID_CREDIT");
                float suma = resultCredite.getFloat("SUMA");
                int perioada = resultCredite.getInt("PERIOADA");
                float dobanda = resultCredite.getFloat("DOBANDA");
                String tipDobanda = resultCredite.getString("tipDobanda");
                String tipCredit = resultCredite.getString("tipCredit");
                //System.out.println("ID_CREDIT-> "+id_credit+" SUMA_RAMASA-> "+ suma+ " PERIOADA_RAMASA-> "+ perioada);

                Credit c=null;
                switch (tipCredit) {
                    case "CNP":
                        c = new CreditNevoiPersonale(suma, perioada,  dobanda,TipDobanda.valueOf(tipDobanda) );
                        break;
                    case "CI":
                        c = new CreditIpotecar(suma, perioada, dobanda, TipDobanda.valueOf(tipDobanda));
                        break;
                    case "CPC":
                        c = new CreditPrimaCasa(suma, perioada, dobanda, TipDobanda.valueOf(tipDobanda));
                        break;
                    case "CII":
                        c = new CreditImobiliarIpotecar(suma, perioada, dobanda, TipDobanda.valueOf(tipDobanda));
                        break;
                    case "CG":
                        c = new CreditGaudeamus(suma, perioada, dobanda, TipDobanda.valueOf(tipDobanda));
                        break;
                    default:
                        System.out.println("Tipul de credit nu exista!");
                }
                System.out.println(c);
                if(c!=null){
                    this.istoricCredite.add(c);
                }

            }
        }catch (SQLException ex ){
            ex.printStackTrace();
        }
    }

    public void modificaCursEuro(float valoare){
        cursValutarEuro+=valoare;
    }
    public void modificaCursDolar(float valoare){
        cursValutarDolar+=valoare;
    }

    public String getDenumireBanca() {
        return denumireBanca;
    }

    public void setDenumireBanca(String denumireBanca) {
        this.denumireBanca = denumireBanca;
    }

    public String getLocatieBanca() {
        return locatieBanca;
    }

    public void setLocatieBanca(String locatieBanca) {
        this.locatieBanca = locatieBanca;
    }

    public float getCursValutarEuro() {
        return cursValutarEuro;
    }

    public void setCursValutarEuro(float cursValutarEuro) {
        this.cursValutarEuro = cursValutarEuro;
    }

    public float getCursValutarDolar() {
        return cursValutarDolar;
    }

    public void setCursValutarDolar(float cursValutarDolar) {
        this.cursValutarDolar = cursValutarDolar;
    }

    @Override
    public String toString() {
        return "Banca{" +
                "listaCrediteAcordate=" + listaCrediteAcordate +
                ", istoricCredite=" + istoricCredite +
                ", denumireBanca='" + denumireBanca + '\'' +
                ", locatieBanca='" + locatieBanca + '\'' +
                ", cursValutarEuro=" + cursValutarEuro +
                ", cursValutarDolar=" + cursValutarDolar +
                '}';
    }
}
