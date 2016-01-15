package abstracts;


import java.util.ArrayList;

/**
 * Created by baylrock and Legementario on 11.01.2016.
 */

public interface AbstractNeuron {

    void setValue(float value);
    float getValue(int index);
    void funktion();
    float getWeight();
    void setWeight(float weight);
    public void setValue(ArrayList<Float> value);

}
