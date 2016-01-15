package elements;

import abstracts.AbstractNeuron;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Baylrock and Legementario on 11.01.2016.
 */

public class Neuron implements AbstractNeuron, Serializable {
    private float WEIGHT;  // вес нейрона
    private float step; //коэффициент предохраняющий от слишком значительных изменений весов
    private int index;  // порядковый номер нейронна
    private ArrayList<Float> set;  //массив входящих значений


    //TODO насколько я понимаю мы должны ещё описать функцию "ошибки" и влияние её на вес 

    public Neuron() {
        WEIGHT = (float)(1 / (new Random().nextInt(5) + 3));
        step = (float) 0.001;  // коэффициент будем изменять в зависимости от обучаемости сети
    }

    public Neuron(float WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    /**
     * добавить одно значение в массив
     * @param value
     */
    @Override
    public void setValue(float value) {
        set.add(value);
    }

    /**
     * добавить все значения в массив
     * @param value
     */
    @Override
    public void setValue(ArrayList<Float> value) {
        set.addAll(value);
    }

    @Override
    public float getValue(int index) {
        return set.get(index);
    }

    /**
     * метод меняющий вес нейрона
     */
    @Override
    public void funktion() {
        WEIGHT = summSet();
        //TODO ТУТ НУЖНА ФУНКЦИЯ КОТОРАЯ ИЗМЕНЯЕТ ВЕС НЕЙРОНА ОТНОСИТЕЛЬНО ВХОДЯЩИХ СИГНАЛОВ `SET - ARRAYLIST` | ПОКА ЭТО ИХ СУММА
    }

    @Override
    public float getWeight() {
        return WEIGHT;
    }

    /**
     * установить вес нейрона
     * @param weight
     */
    @Override
    public void setWeight(float weight) {
        WEIGHT = weight;
    }

    /**
     * метод подсчёта входных значений влияющих на вес нейронна
     * @return
     */
    private float summSet(){
        float summ = 0;
        for (float value:set){
            summ+=value;
        }
        summ = (2*summ-1)*step; //эксперементальная строка + регулировка значения весов

        if (summ>1){
            return 1;
        } else if (summ<0){
            return 0;
        } else{
            return summ;
        }
    }
}
