package codeParse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by baylrock on 11.06.2016.
 */
public class HtmlParse extends FactorFinder{

    private Document doc;
    private String URL;
    private static HtmlParse instance;
    private float[] factorsValues;

    public HtmlParse readURL(String URL) {
        try {
            this.URL = URL;
            doc = Jsoup.connect( "http://www.google.com" ).get();
            factorsValues = findFactors( doc );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
    private HtmlParse(){}

    public static synchronized HtmlParse getInstance() {
        return instance==null?new HtmlParse():instance;
    }

    public float[] getFactorsValues() {
        return factorsValues;
    }

}
