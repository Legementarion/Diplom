package elements;

import abstracts.AbstractNeuron;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by baylrock on 11.01.2016.
 */
public class Neuron implements AbstractNeuron, Serializable {
    private float WEIGHT;
    private int index;
    private ArrayList<Float> set;

    @Override
    public void setValue(float value) {
        set.add(value);
    }

    @Override
    public float getValue(int index) {
        return set.get(index);
    }

    @Override
    public void funktion() {
        WEIGHT = summSet();
    }

    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public void setWeight(float weight) {
        WEIGHT = weight;
    }

    private float summSet(){
        float summ = 0;
        for (float value:set){
            summ+=value;
        }
        return summ;
    }
}
