package NeuroNet;

import java.util.ArrayList;

public class Pretseptron extends NNet {
    
    private double a = 0.5;

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
    
    public double[] study() {
        work();
        double []tmp = new double[getLastLayer().neurons.size()];
        for(int i = 0; i < tmp.length; i++) {
            tmp[i] = getLastLayer().neurons.get(i).val;
        }
        
        studyHeb();
        
        return tmp;
    }
    
    private void studyHeb() {
        for(int l = 0; l < layers.size(); l++) {
            ArrayList<Neuron> lay = layers.get(l).neurons;
            for(int i = 0; i < lay.size(); i++) {
                Neuron neu = lay.get(i);
                for(int j = 0; j < neu.dendrits.size(); j++) {
                    neu.weights.set(j, neu.weights.get(j)+a*neu.dendrits.get(j).get()*neu.val);
                }
            }
        }
    }

    private void studyKoh() {
        for(int l = 0; l < layers.size(); l++) {
            ArrayList<Neuron> lay = layers.get(l).neurons;
            for(int i = 0; i < lay.size(); i++) {
                Neuron neu = lay.get(i);
                for(int j = 0; j < neu.dendrits.size(); j++) {
                    neu.weights.set(j, neu.weights.get(j)+a*(neu.dendrits.get(j).get()-neu.weights.get(j)));
                }
            }
        }
    }
}
