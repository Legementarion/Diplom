package Neuro.elements;

import Neuro.abstracts.AbstractLayer;
import Neuro.abstracts.AbstractNeuron;
import Neuro.enums.LayerName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Baylrock and Legementario on 11.01.2016.
 */

public class Layer implements AbstractLayer, Serializable {
    private final int LAYERSIZE;
    private LayerName name;
    private ArrayList< Neuron> neuronsSet; // массив нейронов в слое
    private Layer next_layer;


    {
        neuronsSet = new ArrayList<>();
    }


    public Layer() {
        LAYERSIZE = 0;
    }
    /**
     * конструктор слоя
     *
     * @param layerSize количество нейронов в слое
     * @param name      имя слоя
     */
    public Layer( int layerSize, LayerName name ) {
        this.name = name;
        LAYERSIZE = layerSize;
        buildLayer( layerSize );
    }

    public ArrayList<Neuron> getNeuronsSet() {
        return neuronsSet;
    }

    @Override
    public void setNeuronsSet( ArrayList<Neuron> neuronsSet ) {
        this.neuronsSet = neuronsSet;
    }

    @Override
    public void insertValue( double value ) {
        //TODO ЧТО ОНО ДОЛЖНО ДЕЛАТЬ?
    }

    /**
     * добавить нейрон в конец слоя
     *
     * @param neuron
     */
    @Override
    public void addNeuron( Neuron neuron ) {
        neuronsSet.add( neuron );
    }

    /**
     * создать N-ное количествой нейронов
     *
     * @param layerSize
     */
    @Override
    public void buildLayer( int layerSize ) {
        for (int i = 0; i < layerSize; i++) {
            addNeuron( new Neuron() );
        }
    }

    @Override
    public void getNeuronWeight( Neuron neuron ) {
        //TODO  НУЖНА ЛИ ЭТА ЕРЕСЬ?
    }

    @Override
    public void getNeuronWeight( int index ) {

    }

    @Override
    public Layer getNextLayer() {
        return next_layer;
    }

    @Override
    public void linkOutputsWithLayer( AbstractLayer targetOutputLayer ) {
        for (AbstractNeuron neuron : getNeuronsSet()) {
            targetOutputLayer.getNeuronsSet().forEach( neuron::addLink );
        }
    }

    @Override
    public void setNextLayer( Layer layer ) {
        this.next_layer = layer;
    }

    public Layer getInstance() {
        return this;
    }
}
