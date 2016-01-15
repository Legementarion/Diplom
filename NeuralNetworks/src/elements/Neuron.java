package elements;

import abstracts.AbstractNeuron;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by baylrock on 11.01.2016.
 */
public class Neuron implements AbstractNeuron, Serializable {
    private float WEIGHT;
    private int index;
    private ArrayList<Float> set;

    public Neuron() {
        WEIGHT = (float)(1 / (new Random().nextInt(5) + 3));
    }

    public Neuron(float WEIGHT) {
        this.WEIGHT = WEIGHT;
    }



    @Override
    public void setValue(float value) {
        set.add(value);
    }

    @Override
    public void setValue(ArrayList<Float> value) {
        set.addAll(value);
    }

    @Override
    public float getValue(int index) {
        return set.get(index);
    }

    @Override
    public void funktion() {
        WEIGHT = summSet();
        //TODO ТУТ НУЖНА ФУНКЦИЯ КОТОРАЯ ИЗМЕНЯЕТ ВЕС НЕЙРОНА ОТНОСИТЕЛЬНО ВХОДЯЩИХ СИГНАЛОВ `SET - ARRAYLIST` | ПОКА ЭТО ИХ СУММА

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
