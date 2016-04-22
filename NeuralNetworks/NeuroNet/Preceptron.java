package NeuroNet;

import java.util.ArrayList;

public class Preceptron extends NNet {
    
    private double a = 0.5;

    public Preceptron(ArrayList<String> inputs) {
        super(inputs);
    }

    public Preceptron() {
        super();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
    
    public void study(double[] y) {
        work();
        int l = layers.size() - 1;
        
        ArrayList<Neuron> neurons = layers.get(l).getNeurons();
        double []sig = new double[neurons.size()];
        for(int i = 0; i < sig.length; i++) {
            Neuron n = neurons.get(i);
            sig[i] = ((stdNeuron)n).pActive(n.get())*(y[i] - n.get());
            ArrayList<Ninput> inp = layers.get(l).getInputs();
            for(int j = 0; j < inp.size(); j++) {
                n.weights.set(j, n.weights.get(j)+a*sig[i]*inp.get(j).get());
            }
        }
        l--;
        while(l>-1) {
            ArrayList<Neuron> neurons2 = layers.get(l).getNeurons();
            double []sig2 = new double[neurons2.size()];
            for(int i = 0; i < sig2.length; i++) {
                Neuron n = neurons2.get(i);
                sig2[i] = 0;
                for(int j = 0; j < neurons.size(); j++) sig2[i] += neurons.get(j).weights.get(i)*sig[j];//
                sig2[i] *= ((stdNeuron)n).pActive(n.get());
                ArrayList<Ninput> inp = layers.get(l).getInputs();
                for(int j = 0; j < inp.size(); j++) {
                    n.weights.set(j, n.weights.get(j)+a*sig2[i]*inp.get(j).get());
                }
            }
            l--;
            sig = sig2;
            neurons = neurons2;
        }
    }
    
}
