package Neuro.abstracts;

import Neuro.elements.Layer;
import Neuro.elements.Neuron;

import java.util.ArrayList;

/**
 * Created by baylrock and Legementario on 11.01.2016.
 */

public interface AbstractLayer {

        public void setNeuronsSet( ArrayList<Neuron> layer_set);
        public ArrayList<Neuron> getNeuronsSet();
        public void insertValue(double value);
        void addNeuron(Neuron neuron);
        void buildLayer(int Neurons);
        void getNeuronWeight(Neuron neuron);
        void getNeuronWeight(int index);
        void setNextLayer(Layer layer);
        Layer getNextLayer();
        void linkOutputsWithLayer(AbstractLayer layer);

}
