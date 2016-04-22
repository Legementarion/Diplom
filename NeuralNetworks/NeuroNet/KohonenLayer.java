package NeuroNet;

import java.util.ArrayList;


public class KohonenLayer extends NLayer {

    private int winner;
    private int []wins;
    private double iters = 0;

    public KohonenLayer(ArrayList<String> ss) {
        super(ss);
    }

    public KohonenLayer(ArrayList<Ninput> inputs, int count) {
        super();
        this.inputs = inputs;
        kohNeuron kn0 = new kohNeuron();
        addNeuron(kn0);
        kn0.initWeight(0.0);
        for (int i = 1; i < count; i++) {
            kohNeuron kn = new kohNeuron();
            addNeuron(kn);
            kn.initWeight();
        }
        wins = new int[neurons.size()];
    }

    @Override
    public void work() {
        super.work();
        winner = 0;
        double minD = neurons.get(0).val;
        for(int i = 1; i < neurons.size(); i++) {
            if(minD > neurons.get(i).val) {
                winner = i;
                minD = neurons.get(i).val;
            }
        }
    }
    
    public void sWork() {
        super.work();
        winner = -1;
        iters += 1;
        int i = 0;
        for(; i < neurons.size(); i++) {
            if(wins[i] < iters/wins.length) {
                winner = i;
                break;
            }
        }
        double minD = neurons.get(winner).val;
        for(; i < neurons.size(); i++) {
            if(wins[i] < iters/wins.length) {
                if(minD > neurons.get(i).val) {
                    winner = i;
                    minD = neurons.get(i).val;
                }
            }
        }
        wins[winner] += 1;
    }

    public int getWinner() {
        return winner;
    }
    
}
class kohNeuron extends Neuron implements initedNeuron,studentNeuron {

    public kohNeuron(String s) {
        super(s);
    }

    public kohNeuron(ArrayList<Ninput> dendrits, ArrayList<Double> weights) {
        super(dendrits, weights);
    }

    @Override
    public void work() {
        val = 0;
        for(int i = 0; i < dendrits.size(); i++) {
            val += Math.pow(dendrits.get(i).get()-weights.get(i), 2);
        }
        val = Math.sqrt(val);
    }

    public kohNeuron() {
        super();
    }

    @Override
    public void study(double r) {
        for(int i = 0; i < dendrits.size(); i++) {
            weights.set(i, weights.get(i)+r*(dendrits.get(i).get()-weights.get(i)));
        }
    }
    
    @Override
    public void initWeight() {
        weights = new java.util.ArrayList<Double>();
        for(int i = 0; i < dendrits.size(); i++) {
            weights.add(0.5);            
        }
    }
    
    public void initWeight(Double val) {
        weights = new java.util.ArrayList<Double>();
        for(int i = 0; i < dendrits.size(); i++) {
            weights.add(val);            
        }
    }
    
    public void initWeight(Double []vals) {
        weights = new java.util.ArrayList<Double>();
        for(int i = 0; i < dendrits.size(); i++) {
            weights.add(vals[i]);            
        }
    }
}