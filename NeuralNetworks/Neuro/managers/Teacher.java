package Neuro.managers;

import java.io.Serializable;

/**
 * Created by baylrock on 11.06.2016.
 */
public class Teacher implements Serializable {

    public static Teacher instance;
    private NeuroManager manager;
    private static boolean IN_PROCESS=false;


    private Teacher(){}

    public static synchronized Teacher getInstance() {
        return instance==null?new Teacher():instance;
    }

    public void teach(NeuroManager manager) {

    }


    public void saveNet(NeuroManager manager) {}

    public NeuroManager loadNet() {
        return NeuroManager.getInstance();
    }

    private void initBackProp() {

    }

    public void loadInputs(float[] inputs) {

    }
}
