package abstracts;

import elements.Layer;
import elements.Neuron;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baylrock on 11.01.2016.
 */
public interface AbstractLayer {

        public void setLayer_set(ConcurrentHashMap<Integer,Neuron> layer_set);
        public ConcurrentHashMap<Integer,Neuron> getLayer_set();
        public void insertValue(double value);
        void addNeuron(Neuron neuron);
        void buildLayer(int Neurons);
        void getNeuronWeight(Neuron neuron);
        void getNeuronWeight(int index);
        void setNextLayer(Layer layer);
        Layer getNextLayer();

}
