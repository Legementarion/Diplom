package Neuro;

import Neuro.enums.LayerName;
import Neuro.managers.NeuroManager;
import Neuro.managers.Teacher;
import codeParse.HtmlParse;

import java.io.Serializable;

/**
 * Created by baylrock on 11.06.2016.
 */
public class NeuroMain implements Serializable {
    public NeuroManager neuroNet;

    public static void main (String[] args) {
        NeuroMain nm = new NeuroMain();
        nm.neuroNet = NeuroManager.getInstance();
        nm.neuroNet.addLayer( 10, LayerName.INPUT );
        Teacher teacher = Teacher.getInstance();

        float[] factorsValues = HtmlParse.getInstance().readURL( "http://www.google.com" ).getFactorsValues();
        teacher.loadInputs( factorsValues );
        teacher.teach( nm.neuroNet );

    }



}
