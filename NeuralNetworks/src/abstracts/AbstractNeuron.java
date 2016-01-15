package abstracts;


/**
 * Created by baylrock on 11.01.2016.
 */
public interface AbstractNeuron {

    void setValue(float value);
    float getValue(int index);
    void funktion();
    float getWeight();
    void setWeight(float weight);

}
