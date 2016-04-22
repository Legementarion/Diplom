package NeuroNet;

public class Neuron implements Ninput,java.io.Serializable {
    
    static private int COUNT = 0;
    protected double val;
    private long id;
    private String name;
    protected java.util.ArrayList<Ninput> dendrits;
    protected java.util.ArrayList<Double> weights;
    
    public Neuron() {
        dendrits = new java.util.ArrayList<Ninput>();
        weights = new java.util.ArrayList<Double>();
        id = ++COUNT;
    }
    
    public Neuron(String s) {
        this();
        parse(s);
    }

    public Neuron(java.util.ArrayList<Ninput> dendrits,java.util.ArrayList<Double> weights) {
        this.dendrits = dendrits;
        this.weights = weights;
        id = ++COUNT;
    }

    public void setDendrits(java.util.ArrayList<Ninput> dendrits) {
        this.dendrits = dendrits;
    }

    public void setWeights(java.util.ArrayList<Double> weights) {
        this.weights = weights;
    }
    
    public void addDendrit(Ninput ni, double w) {
        dendrits.add(ni);
        weights.add(w);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double get() {
        return val;
    }
    
    public double active(double sum) {
        return sum;
    }
    
    public void work() {
        double sum = 0;
        for(int i = 0; i < dendrits.size(); i++) {
            sum += dendrits.get(i).get() * weights.get(i);
        }
        val = active(sum);
    }

    @Override
    public String toString() {
        String s = "Nueron("+getClass().getName()+"):";
        s += "id="+id+";";
        s += "name="+name+";";
        s += "weights("+weights.size()+")={";
        for(Double d:weights) s += d.toString()+";";
        s += "}";
        return s;
    }
    
    public void saveTo(java.io.OutputStreamWriter osw) throws java.io.IOException {
        osw.write(toString());
    }
        
    protected String parse(String s) {
        String tmp = s.substring(s.indexOf("id=")+3);
        id = Integer.parseInt(tmp.substring(0, tmp.indexOf(";")));
        tmp = tmp.substring(tmp.indexOf("name=")+5);
        name = tmp.substring(0, tmp.indexOf(";"));
        if(name.equals("null")) name = null;
        tmp = tmp.substring(tmp.indexOf("weights(")+8);
        int n = Integer.parseInt(tmp.substring(0, tmp.indexOf(")")));
        tmp = tmp.substring(tmp.indexOf("{")+1);
        for(int i = 0; i < n; i++) {
            weights.add(Double.parseDouble(tmp.substring(0,tmp.indexOf(";"))));
            tmp = tmp.substring(tmp.indexOf(";")+1);
        }
        return tmp;
    }
}
