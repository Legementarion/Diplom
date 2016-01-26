package elements;

import abstracts.AbstractLayer;
import enums.LayerName;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Baylrock and Legementario on 11.01.2016.
 */

public class Layer implements AbstractLayer,Serializable {
    private LayerName name;
    private ConcurrentHashMap<Integer,Neuron> layer_set; // массив нейронов в слое
    private Layer next_layer;

    /**
     * конструктор слоя
     * @param size количество нейронов в слое
     * @param name имя слоя
     */

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

    /**
     * добавить нейрон в конец слоя
     * @param neuron
     */
    @Override
    public void addNeuron(Neuron neuron) {
        layer_set.put(layer_set.size(),neuron);
    }

    /**
     * создать N-ное количествой нейронов
     * @param Neurons
     */
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
