package NeuroNet;

public interface stdNeuron extends initedNeuron {
    public double getP();
    public void setP(double p);
    public double pActive(double out);
}

interface initedNeuron {
    public void initWeight();
}

interface studentNeuron {
    public void study(double r);
}