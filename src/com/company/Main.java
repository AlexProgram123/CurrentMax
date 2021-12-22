package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double Knad=1.2; //Коэффициент надёжности
        double Ksz=0.8;  //Коэффициент самозапуска
        double Kv=0.8;   //Коэффициент возврата

        ArrayList<Busbar> busesnow = new ArrayList<>();
        Busbar buses[] = new Busbar[11];
        Busbar busbarForChange = new Busbar();

        Busbar b1 = new Busbar();
        Busbar b11 = new Busbar();
        Busbar b111 = new Busbar();
        Busbar b112 = new Busbar();
        Busbar b12 = new Busbar();
        Busbar b13 = new Busbar();
        Busbar b131 = new Busbar();
        Busbar b1311 = new Busbar();
        Busbar b1312 = new Busbar();
        Busbar b132 = new Busbar();


        b1.setPosition(1);
        b11.setPosition(11);
        b111.setPosition(111);
        b112.setPosition(112);
        b12.setPosition(12);
        b13.setPosition(13);
        b131.setPosition(131);
        b1311.setPosition(1311);
        b1312.setPosition(1312);
        b132.setPosition(132);

        b1.setMaxCurrent(-1);
        b11.setMaxCurrent(-1);
        b111.setMaxCurrent(3);
        b112.setMaxCurrent(5);
        b12.setMaxCurrent(4);
        b13.setMaxCurrent(-1);
        b131.setMaxCurrent(-1);
        b1311.setMaxCurrent(3);
        b1312.setMaxCurrent(6);
        b132.setMaxCurrent(3);

        buses[0] = b1;
        buses[1] = b11;
        buses[2] = b111;
        buses[3] = b112;
        buses[4] = b12;
        buses[5] = b13;
        buses[6] = b131;
        buses[7] = b1311;
        buses[8] = b1312;
        buses[9] = b132;
        buses[10] = busbarForChange;

        b1.setMaxCurrent(findCurrent(b1, buses));

        for (int i =0; i < buses.length; i++){
            buses[i].setCurrentMTZ(buses[i].getMaxCurrent()*Knad*Ksz/Kv);
        }

        b1.ShowCurrent();
        b11.ShowCurrent();
        b12.ShowCurrent();
        b13.ShowCurrent();
        b131.ShowCurrent();
    }


    public static double findCurrent(Busbar b, Busbar busess[]) {

        double summCuttent = 0;
        ArrayList<Busbar> busesnoww = new ArrayList<>();
        Busbar busbarForChange = busess[10];

        for (int i = 0; i < 10; i++) {
            if (((busess[i].getPosition()/10) == (b.getPosition()))) {
                busesnoww.add(busess[i]);
            }
        }

        for (int i=0; i<busesnoww.size(); i++) {
            busbarForChange=busesnoww.get(i);
            if (busbarForChange.getMaxCurrent() == -1) {
                busbarForChange.setMaxCurrent(findCurrent(busbarForChange, busess));
                busesnoww.set(i, busbarForChange);
            }
        }

        for (int i=0; i<busesnoww.size(); i++){
                summCuttent = summCuttent + busesnoww.get(i).getMaxCurrent();
        }
        return summCuttent;
    }
}
