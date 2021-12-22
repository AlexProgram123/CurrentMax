package com.company;
import java.util.ArrayList;

public class Busbar{
    private int position;
    private double maxCurrent;
    private double currentMTZ;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setMaxCurrent(double maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public double getMaxCurrent() {
        return maxCurrent;
    }

    public void setCurrentMTZ(double currentMTZ) {
        this.currentMTZ = currentMTZ;
    }

    public double getCurrentMTZ() {
        return currentMTZ;
    }


    public void ShowCurrent() {
        System.out.println("Выключатель №:" + getPosition() + "  Максимальный рабочий ток: " + getMaxCurrent() + " Ампер" + " Ток срабатывания МТЗ: " + getCurrentMTZ() + " Ампер");
    }
}
