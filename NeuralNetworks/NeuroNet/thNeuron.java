package NeuroNet;

import java.util.ArrayList;

public class thNeuron extends Neuron implements stdNeuron {

    private double p = 0;

    public thNeuron(String s) {
        super(s);
    }

    public thNeuron(ArrayList<Ninput> dendrits, ArrayList<Double> weights) {
        super(dendrits, weights);
    }

    public thNeuron() {
        super();
    }

    @Override
    public double getP() {
        return p;
    }

    @Override
    public void setP(double p) {
        this.p = p;
    }
    
    @Override
    public double active(double sum) {
        return Math.tanh(sum - p);
    }
    
    @Override
    public double pActive(double out) {
        return 1-out*out;
    }
    
    @Override
    public void initWeight() {
        weights = new java.util.ArrayList<Double>();
        for (int i = 0; i < dendrits.size(); i++) {
            weights.add(Math.random() - 0.5);            
        }
    }

    @Override
    public String toString() {
        return super.toString()+"p="+p+";";
    }

    @Override
    protected String parse(String s) {
        String tmp = super.parse(s);
        p = Double.parseDouble(tmp.substring(tmp.indexOf("p=")+2, tmp.indexOf(";")));
        return tmp.substring(tmp.indexOf(";")+1);
    }
    
}
