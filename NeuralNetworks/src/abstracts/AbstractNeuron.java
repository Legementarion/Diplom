package abstracts;


import java.util.ArrayList;

/**
 * Created by baylrock and Legementario on 11.01.2016.
 */

public interface AbstractNeuron {

    void setInputWeight( float value);
    float getValue(int index);
    void funktion();
    float getWeight();
    void setWeight(float weight);
    public void setInputWeight( ArrayList<Float> value);
    void addLink(AbstractNeuron neuron);
    void think();
    void sendWeights();

}
