package managers;

import elements.Layer;
import enums.LayerName;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baylrock on 15.01.2016.
 */
public class NeuroManager implements Serializable {
    private static NeuroManager neuroManager;
    private ConcurrentHashMap<Integer, Layer> leyer_set;
    private NeuroManager(){}

    public static NeuroManager getInstance() {
        if (neuroManager==null) {neuroManager = new NeuroManager();}
        return neuroManager;
    }

    public void addLayer(int neuron_num, LayerName name) {
        leyer_set.put(leyer_set.size(),new Layer(neuron_num, name));
    }


    //// TODO: 15.01.2016 Тут нужен код сборки слоев и их наполнения. Необходим метод начинающий работу системы.
    // Класс является синглтоном, доступен во всех частях кода


}
