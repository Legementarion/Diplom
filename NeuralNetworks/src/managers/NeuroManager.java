package managers;

import java.io.Serializable;

/**
 * Created by baylrock on 15.01.2016.
 */
public class NeuroManager implements Serializable {
    private static NeuroManager neuroManager;
    private NeuroManager(){}

    public static NeuroManager getInstance() {
        if (neuroManager==null) {neuroManager = new NeuroManager();}
        return neuroManager;
    }


    //// TODO: 15.01.2016 Тут нужен код сборки слоев и их наполнения. Необходим метод начинающий работу системы.
    // Класс является синглтоном, доступен во всех частях кода


}
