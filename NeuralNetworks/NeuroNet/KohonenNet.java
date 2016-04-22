package NeuroNet;

import java.util.ArrayList;

public class KohonenNet extends NNet implements Ninput {
    
    private double a = 1;
    private double s = 0.5;

    public KohonenNet(ArrayList<String> inputs) {
        super(inputs);
    }

    public void setS(double s) {
        this.s = s;
    }
            
    public void setA(double a) {
        this.a = a;
    }

    public double getS() {
        return s;
    }

    public double getA() {
        return a;
    }

    public KohonenNet(ArrayList<Ninput> inputs,int countN) {
        setInputs(inputs);
        KohonenLayer kl = new KohonenLayer(inputs,countN);
        //super.addLayer(kl);
        layers.add(kl);
    }
    
    private double h(int i) {
        return a*Math.exp(0-Math.pow(i-((KohonenLayer)getLastLayer()).getWinner(),2)/(2*s*s));
    }
    
    public void study() {
        KohonenLayer kl = (KohonenLayer)getLastLayer();
        kl.sWork();
 //       System.out.println(kl.getWinner());
        for(int i = 0; i < kl.neurons.size(); i++) {
//            double h = h(i);
//            if(h>0.001) ((kohNeuron)kl.neurons.get(i)).study(h);
            ((kohNeuron)kl.neurons.get(i)).study(h(i));
 //           System.out.println(h(i));
        }
//        System.out.println("study Koh");
        s *= 0.999;
        a *= 0.999;
    }
/*
    @Deprecated @Override
    public void addLayer(NLayer nl) {
        //super.addLayer(nl);
    }
  */  
    public void initWeights() {
        for(Neuron n:layers.get(0).getNeurons()) ((initedNeuron)n).initWeight();
    }
    
    @Override
    public double get() {
        return ((KohonenLayer)getLastLayer()).getWinner();
    }
}
