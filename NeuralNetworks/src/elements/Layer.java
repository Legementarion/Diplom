package elements;

import abstracts.AbstractLayer;
import enums.LayerName;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baylrock on 11.01.2016.
 */
public class Layer implements AbstractLayer,Serializable {
    private LayerName name;
    private ConcurrentHashMap<Integer,Neuron> layer_set;
    private Layer next_layer;

    public Layer(int size, LayerName name) {
        this.name = name;
        buildLayer(size);
    }

    @Override
    public void setLayer_set(ConcurrentHashMap<Integer, Neuron> layer_set) {
        this.layer_set = layer_set;
    }

    @Override
    public ConcurrentHashMap<Integer, Neuron> getLayer_set() {
        return layer_set;
    }

    @Override
    public void insertValue(double value) {
        //TODO ЧТО ОНО ДОЛЖНО ДЕЛАТЬ?
    }

    @Override
    public void addNeuron(Neuron neuron) {
        layer_set.put(layer_set.size(),neuron);
    }

    @Override
    public void buildLayer(int Neurons) {
        for (int i = 0; i<Neurons;i++) {
            addNeuron(new Neuron());
        }
    }

    @Override
    public void getNeuronWeight(Neuron neuron) {
        //TODO  НУЖНА ЛИ ЭТА ЕРЕСЬ?
    }

    @Override
    public void getNeuronWeight(int index) {

    }

    @Override
    public void setNextLayer(Layer layer) {
        this.next_layer = layer;
    }

    @Override
    public Layer getNextLayer() {
        return next_layer;
    }

    public Layer getInstance() {
        return this;
    }
}
