import managers.NeuroManager;

import java.io.Serializable;

/**
 * Created by Baylrock and Legementario on 11.01.2016.
 */

public class NeuroMain implements Serializable {
    public NeuroManager neuroNet;

    public static void main (String[] args) {
        NeuroMain nm = new NeuroMain();
        nm.neuroNet = NeuroManager.getInstance();
    }
}
