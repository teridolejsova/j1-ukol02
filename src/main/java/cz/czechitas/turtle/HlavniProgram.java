package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    Turtle zofka;

    public void main(String[] args) {

        Turtle zofka;
        zofka = new Turtle();

        zofka.setLocation(1000, 400);

        namalujMasinku(zofka);
        namalujZmrzlinku(zofka);
        namalujSnehulaka(zofka);
    }

    private void namalujMasinku(Turtle zofka) {
        namalujObdelnik(zofka, 200, 100, Color.BLACK,false);
        zofka.turnRight(90);
        namalujObdelnik(zofka, 200, 130, Color.BLACK,false);
        zofka.turnLeft(90);
        namalujKoleckoSPolomerem(zofka,(130/2));
        zofka.setLocation(850,400);
        zofka.turnRight(90);
        namalujKoleckoSPolomerem(zofka,20);
        zofka.setLocation(950,400);
        namalujKoleckoSPolomerem(zofka,20);
        zofka.setLocation(800,320);
        zofka.turnRight(100);
        zofka.move(150);
        zofka.turnLeft(128);
        zofka.move(94);
        zofka.turnLeft(90);
        zofka.move(90);
    }

    private void namalujSnehulaka(Turtle zofka) {
        zofka.setLocation(500, 120);
        zofka.turnLeft(195);

        namalujKoleckoSPolomerem(zofka, 30);
        zofkoKdeJsi(zofka);

        zofka.setLocation(zofka.getX(), zofka.getY() + 100);
        namalujKoleckoSPolomerem(zofka, 50);

        zofkoKdeJsi(zofka);
        zofka.setLocation(zofka.getX(), zofka.getY() + 140);
        namalujKoleckoSPolomerem(zofka, 70);

        zofka.setLocation(440, 170);
        zofka.turnLeft(90);
        namalujRucicku(zofka);
        zofka.setLocation(540, 170);
        zofka.turnLeft(180);
        namalujRucicku(zofka);
    }

    private void namalujZmrzlinku(Turtle zofka) {
        zofka.setLocation(140, 94);
        namalujKolecko(zofka, Color.cyan, 38, 10);
        zofka.setLocation(141, 103);
        zofka.turnRight(90);
        namalujTrojuhelnik(zofka, 120, Color.yellow, true);
    }

    private void namalujRucicku(Turtle turtle) {
        namalujKoleckoSPolomerem(turtle, 20);
    }

    private void zofkoKdeJsi(Turtle turtle) {
        System.out.println("Pozice X = " + turtle.getX() + "  Y je= " + turtle.getY());
    }

    private void namalujKoleckoSPolomerem(Turtle turtle, double polomer) {
        double stranaA = 10;
        //double stranaC = Math.sqrt((polomer*polomer)+(stranaA*stranaA));
        double stranaC = Math.sqrt(Math.pow(polomer, 2) + Math.pow(stranaA, 2));
        //System.out.println("strana C= "+stranaC);
        double uhel = Math.toDegrees(Math.sin(stranaA / stranaC));

        for (int i = 0; i < 360 / uhel; i++) {
            // System.out.println("Uhel je= "+uhel);
            System.out.println("i je= " + i);
            turtle.move(10);
            turtle.turnRight(uhel);
            //if (i==8 ||i==24){
            //   zofkoKdeJsi(turtle);
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











