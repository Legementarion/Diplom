package codeParse;

import org.jsoup.nodes.Document;

import java.util.Arrays;

/**
 * Created by baylrock on 11.06.2016.
 */
abstract class FactorFinder {

    private int[] titleCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] descriptionCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] linkingCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] analyticksCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] socialNetworkingCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] imageCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] SnipetsCheck(Document document) {
        return new int[]{2,1};
    }

    private int[] techCheck(Document document) {
        return new int[]{2,1};
    }

    protected float[] findFactors(Document document) {
        return new float[]{};
    }



}
