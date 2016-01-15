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


}
