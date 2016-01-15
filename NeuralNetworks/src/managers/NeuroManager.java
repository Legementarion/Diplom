package managers;

import elements.Layer;
import enums.LayerName;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Baylrock and Legementario on 15.01.2016.
 */

public class NeuroManager implements Serializable {
    private static NeuroManager neuroManager;
    private ConcurrentHashMap<Integer, Layer> leyer_set; //массив слоёв
    private NeuroManager(){} // пустой конструктор?

    public static NeuroManager getInstance() {
        if (neuroManager==null) {neuroManager = new NeuroManager();}
        return neuroManager;
    }

    /**
     * добавляет слой в массив
     * @param neuron_num количство нейронов в слое
     * @param name имя слоя
     */
    public void addLayer(int neuron_num, LayerName name) {
        leyer_set.put(leyer_set.size(),new Layer(neuron_num, name));
    }




    //// TODO: 15.01.2016 Тут нужен код сборки слоев и их наполнения. Необходим метод начинающий работу системы.
    // Класс является синглтоном, доступен во всех частях кода


}
