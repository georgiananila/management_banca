package main;

import clase.*;
import interfete.IBanca;
import interfete.TipCredit;
import interfete.TipDobanda;
import interfete.TipPersoana;

public class MainClass {

    public static void main(String[] args){
        IBanca bcr= new Banca("Banca Comerciala Romana","Strada Stefan cel Mare nr. 20A",(float)4.85,(float)3.91);
        Banca brd= new Banca("Banca Romana de Dezvoltare","Strada Mihai Bravu",(float)4.82,(float)3.87);

        System.out.println("Aici s-a apelat istoricul: ");
        bcr.preluareIstoricCrediteDinBD();
        System.out.println("S-A INCHEIEAT PRELUAREA DIN BAZA DE DATE! ");
        System.out.println( "=====================================================================================================================================================");

        Persoana p1=new Persoana("Nila","Georgiana",22, TipPersoana.PFA,true,"BCR","Analist Tehnic Junior",7800);
        Persoana p2=new Persoana("Manole","Sabina",49, TipPersoana.PFA,true,"Spitalul Boli Infectiose Stefanesti","Bucatar",3000);
        Persoana p3=new Persoana("Paraschiv","Mihaela",65, TipPersoana.ORG,false,null,null,2500);
        Persoana p4=new Persoana("Petrache","Mihai",30, TipPersoana.PFA,true,"Com Divers Auto RO s.a","Paznic",1800);
        Persoana p5=new Persoana("Pop","Ionel",35, TipPersoana.PJ,true,"Harman","Dezvoltator",9000);

        Credit c1=new CreditPrimaCasa(43431,2,(float)2.87, TipDobanda.DOBANDA_FIXA);
        Credit c2=new CreditGaudeamus(654676,6,(float)3.8, TipDobanda.DOBANDA_VARIABILA);
        Credit c3=new CreditImobiliarIpotecar(4347631,15,(float)1.98, TipDobanda.DOBANDA_VARIABILA);
        Credit c4=new CreditIpotecar(4432244,20,(float)2.00, TipDobanda.DOBANDA_FIXA);
        Credit c5=new CreditNevoiPersonale(1131131,25,(float)4.19, TipDobanda.DOBANDA_FIXA);

        //metode din clasa Credit
        System.out.println("Plata in avans s-a putut/nu s-a putut efectua: "+c1.plataAnticipata(5000));
        System.out.println("Plata in avans s-a putut/nu s-a putut efectua: "+c2.plataAnticipata(500));
        System.out.println("Plata in avans s-a putut/nu s-a putut efectua: "+c3.plataAnticipata(2000));
        System.out.println("Plata in avans s-a putut/nu s-a putut efectua: "+c4.plataAnticipata(3300));
        System.out.println("Plata in avans s-a putut/nu s-a putut efectua: "+c5.plataAnticipata(3500));

        System.out.println("Calculare rata: "+c2.calculareRataPerLuna());
        System.out.println("Calculare rata: "+c1.calculareRataPerLuna());
        System.out.println("Calculare rata: "+c3.calculareRataPerLuna());
        System.out.println("Calculare rata: "+c4.calculareRataPerLuna());
        System.out.println("Calculare rata: "+c5.calculareRataPerLuna());

        System.out.println( "=====================================================================================================================================================");

        //Acordarea de credite prin populare Map de lista credite acordate din banci
        Credit acordat=bcr.acordareCredit(80000,10,p2, TipCredit.CREDIT_IPOTECAR_IMOBILIAR);
        if(acordat!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }
        Credit acordat1=bcr.acordareCredit(638312,15,p1, TipCredit.CREDIT_PRIMA_CASA);
        if(acordat1!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }
        Credit acordat2=bcr.acordareCredit(6482374,25,p3, TipCredit.CREDIT_NEVOI_PERSONALE);
        if(acordat2!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }
        Credit acordat4=brd.acordareCredit(42342343,30,p4, TipCredit.CREDIT_GAUDEAMUS);
        if(acordat4!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }
        Credit acordat5=brd.acordareCredit(3231111,10,p5, TipCredit.CREDIT_IPOTECAR);
        if(acordat5!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }

        Credit acordat6=bcr.acordareCredit(80000,p2, TipCredit.CREDIT_IPOTECAR_IMOBILIAR);
        if(acordat!=null){
            System.out.println("Creditul a fost acordat cu succes!");
        }else{
            System.out.println("Creditul nu a fost acordat din cauza unor probleme!");
        }

        //Metode definite in clasa Credit


        System.out.println( "=====================================================================================================================================================");

        //Metode definite in clasa Banca
        System.out.println( brd.toString());
        System.out.println("Se va afisa cursulDolar initial: " +brd.getCursValutarDolar());
        brd.modificaCursDolar((float)1.00);
        System.out.println("Se va afisa cursulDolar modificat(in scadere): " +brd.getCursValutarDolar());
        System.out.println( brd.toString());






    }

}
