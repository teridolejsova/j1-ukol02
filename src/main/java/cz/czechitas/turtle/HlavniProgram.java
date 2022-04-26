package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {

        Turtle zofka;
        zofka = new Turtle();

        zofka.setLocation(1000, 400);

        namalujMasinku(zofka);
        namalujZmrzlinku(zofka);
        namalujSnehulaka(zofka);
    }

    private void namalujKoleckoSPolomerem3 (Turtle turtle,double polomer) {

        double zadanyUhel = 12;
        double zadanyloop = 360.0 / 12.0;
        double delkaKratkeStrany = (2 * (Math.PI)*polomer)/zadanyloop;
        for (int i = 0; i <zadanyloop ; i++) {
            turtle.move(delkaKratkeStrany);
            turtle.turnRight(zadanyUhel);

        }
    }
    private void namalujPravouhlyTrojuhelnik (Turtle turtle,double delkaStranyA){
        double delkaStranyB = delkaStranyA;

        turtle.turnRight(90);
        turtle.move(delkaStranyA);
        turtle.turnLeft(90);
        turtle.move(delkaStranyB);
        turtle.turnLeft(135);
        double stranaC = Math.sqrt(Math.pow(delkaStranyA, 2) + Math.pow(delkaStranyB, 2));
        turtle.move(stranaC);
        turtle.turnLeft(135);


    }

    private void namalujMasinku(Turtle zofka) {
        Color fialova = new Color(102,100,255);
        namalujObdelnik(zofka, 200, 100, fialova,false);
        zofka.turnRight(90);
        namalujObdelnik(zofka, 200, 130, fialova,false);
        zofka.turnLeft(90);
        namalujKoleckoSPolomerem(zofka,(130/2),false);
        zofka.setLocation(850,400);
        zofka.turnRight(90);
        namalujKoleckoSPolomerem(zofka,20,false);
        zofka.setLocation(950,400);
        namalujKoleckoSPolomerem(zofka,20,false);
        zofka.setLocation(700,430);
        zofka.turnLeft(118);
        namalujPravouhlyTrojuhelnik(zofka,100);
        zofka.turnLeft(90);
    }

    private void namalujSnehulaka(Turtle zofka) {
        zofka.setLocation(500, 120);
        zofka.turnLeft(195);
        Color modra = new Color(0x1367A1);
        zofka.setPenColor(modra);
        //hlava
        namalujKoleckoSPolomerem(zofka, 30,false);
        zofkoKdeJsi(zofka);

        zofka.setLocation(zofka.getX(), zofka.getY() + 100);
        //druhé kolečko
        namalujKoleckoSPolomerem(zofka, 50,true);

        zofkoKdeJsi(zofka);
        zofka.setLocation(zofka.getX(), zofka.getY() + 140);
        //poslední největší kolečko
        namalujKoleckoSPolomerem(zofka, 70,false);

        /*zofka.setLocation(440, 170);
        zofka.turnLeft(90);
        namalujRucicku(zofka);
        zofka.setLocation(540, 170);
        zofka.turnLeft(180);
        namalujRucicku(zofka);*/
    }

    private void namalujZmrzlinku(Turtle zofka) {
        zofka.setLocation(140, 94);
        Color zuzova = new Color(0x9B006F);
        namalujKolecko(zofka, zuzova, 38, 10);
        zofka.setLocation(141, 103);
        zofka.turnRight(90);
        Color oranzova = new Color(152, 91, 45, 255);
        namalujTrojuhelnik(zofka, 120, oranzova, true);
    }

    private void namalujRucicku(Turtle turtle) {
        namalujKoleckoSPolomerem(turtle, 20,false);
    }

    private void zofkoKdeJsi(Turtle turtle) {
        System.out.println("Pozice X = " + turtle.getX() + "  Y je= " + turtle.getY());
    }

    private void namalujKoleckoSPolomerem(Turtle turtle, double polomer,boolean malujiProstredniKolecko) {
        double stranaA = 10;
        //double stranaC = Math.sqrt((polomer*polomer)+(stranaA*stranaA));
        double stranaC = Math.sqrt(Math.pow(polomer, 2) + Math.pow(stranaA, 2));
        //System.out.println("strana C= "+stranaC);
        double uhel = Math.toDegrees(Math.sin(stranaA / stranaC));

        for (int i = 0; i < 360 / uhel; i++) {
            // System.out.println("Uhel je= "+uhel);
            //System.out.println("i je= " + i);
            malujRUcickuUvnitrCyklu(turtle, malujiProstredniKolecko, i);
            turtle.move(10);
            turtle.turnRight(uhel);
            //if (i==8 ||i==24){
            //   zofkoKdeJsi(turtle);
        }

    }


    private void malujRUcickuUvnitrCyklu(Turtle turtle, boolean malujiProstredniKolecko, int i) {
        if((i ==8 || i ==24) && malujiProstredniKolecko){
            turtle.turnLeft(180);
            namalujKoleckoSPolomerem3(turtle,20);
            turtle.turnLeft(180);
        }
    }


    private void mnohoUhelnik(Turtle turtle, double delkaStrany, double pocetStran) {

        double uhel = 360 / pocetStran;
        for (int i = 0; i < pocetStran; i++) {
            turtle.turnRight(uhel);
            turtle.move(delkaStrany);

        }


    }

    private void namalujKolecko(Turtle turtle, Color barvicka, double pocetStran, double delkaStran) {
        turtle.setPenColor(barvicka);
        double uhel = 360 / pocetStran;
        for (int i = 0; i < pocetStran; i++) {
            turtle.move(delkaStran);
            turtle.turnRight(uhel);


        }


    }

    private void namalujObdelnik(Turtle turtle, double stranaA, double stranaB, Color barvicka, boolean zatoceniVpravo) {
        turtle.setPenColor(barvicka);
        for (int i = 0; i < 2; i++) {
            turtle.move(stranaB);
            if (zatoceniVpravo) {
                turtle.turnRight(90);
            } else {
                turtle.turnLeft(90);
            }
            turtle.move(stranaA);

            if (zatoceniVpravo) {
                turtle.turnRight(90);
            } else {
                turtle.turnLeft(90);

            }
        }
    }

    private void namalujCtverec (Turtle turtle,double delkaStranyCtverce, Color barvicka){
        turtle.setPenColor(barvicka);
        for (int i = 0; i < 4; i++) {


            turtle.move(delkaStranyCtverce);
            turtle.turnLeft(90);
        }
    }


    private void namalujTrojuhelnik (Turtle turtle,double delkaStrany, Color barvicka,boolean zatoceniVpravo){
        turtle.setPenColor(barvicka);
        for (int i = 0; i < 3; i++) {
            turtle.move(delkaStrany);
            if (zatoceniVpravo) {
                turtle.turnRight(120);
            } else {
                turtle.turnLeft(120);
            }
        }
    }

}











