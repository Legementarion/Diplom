package Neuro.enums;

import Neuro.abstracts.AbstractLayer;
import Neuro.elements.Layer;

/**
 * Created by baylrock on 15.01.2016.
 */
public enum LayerName {
    INPUT( "INPUT" ),
    STELTH( "STELTH" ),
    OUTPUT( "OUTPUT" );

    private String layerName;

    LayerName( String layerName ) {
        this.layerName = layerName;
    }

    public AbstractLayer getLayer( int size ) {
        return new Layer( size, this );
    }

    public String getLayerName() {
        return layerName;
    }


    //Эксперементальный вариант дифферинциации слоев нейронов (входящий/скрытый/выходной)
    //// TODO: 15.01.2016 Опеределить необходимость в перечислении или в отдельных классах для каждого вида нейролнов.
}
