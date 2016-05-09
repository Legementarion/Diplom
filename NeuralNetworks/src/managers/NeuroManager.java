package managers;

import abstracts.AbstractLayer;
import enums.LayerName;
import exeption.MergeException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Baylrock and Legementario on 15.01.2016.
 */

public class NeuroManager implements Serializable {
    private static NeuroManager neuroManager;
    private ArrayList<AbstractLayer> layersSet; //массив слоёв
    private AbstractLayer inputLayer;
    private AbstractLayer outputLayer;

    private NeuroManager() {
    } // пустой конструктор?

    public static NeuroManager getInstance() {
        return neuroManager == null ? new NeuroManager() : neuroManager;
    }

    /**
     * добавляет слой в массив
     *
     * @param size количство нейронов в слое
     * @param name имя слоя
     */
    public void addLayer( int size, LayerName name ) {
        AbstractLayer newLayer = name.getLayer( size );
        layersSet.add( newLayer );
        if ( name.equals( LayerName.INPUT ) && inputLayer == null ) {
            inputLayer = newLayer;
        }
        if ( name.equals( LayerName.OUTPUT ) && outputLayer == null ) {
            outputLayer = newLayer;
        }

    }

    public void mergeLayers() throws MergeException {
        if ( inputLayer != null && outputLayer != null ) {

            for (int i = 0; i < layersSet.size() - 1; i++) {
                layersSet.get( i ).linkOutputsWithLayer( layersSet.get( i + 1 ) );
            }

        } else {
            throw new MergeException( "Input or Output layers not exists!", 1 );
        }
    }


    //// TODO: 15.01.2016 Тут нужен код сборки слоев и их наполнения. Необходим метод начинающий работу системы.
    // Класс является синглтоном, доступен во всех частях кода


}
