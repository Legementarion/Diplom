package NeuroNet;

public class NLayer implements java.io.Serializable {

    protected java.util.ArrayList<Neuron> neurons;
    protected java.util.ArrayList<Ninput> inputs;
    private String name;

    public NLayer() {
        neurons = new java.util.ArrayList<Neuron>();
        inputs = new java.util.ArrayList<Ninput>();
    }
/*
    public NLayer(java.util.ArrayList<Ninput> inputs) {
        neurons = new java.util.ArrayList<Neuron>();
        this.inputs = inputs;
    }
*/
    public NLayer(java.util.ArrayList<String> ss) {
        this();
        parse(ss);
    }
    
    public java.util.ArrayList<Ninput> getInputs() {
        return inputs;
    }

    public java.util.ArrayList<Ninput> getOutputs() {
        java.util.ArrayList<Ninput> out = new java.util.ArrayList<Ninput>();
        for (Ninput ni : neurons) out.add(ni);
        return out;
    }
    
    public void setInputs(java.util.ArrayList<Ninput> inputs) {
        this.inputs = inputs;
        for(Neuron n : neurons) n.setDendrits(inputs);
        //this.inputs.removeAll(this.inputs);
        //this.inputs.addAll(inputs);

    }
    
    public void addInput(Ninput ni) {
        inputs.add(ni);
    }

    public java.util.ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addNeuron(Neuron n) {
        neurons.add(n);
        n.setDendrits(inputs);
    }
    
    public void work() {
        for(Neuron n : neurons) {
            n.work();
        }
    }
    
    public void saveTo(java.io.OutputStreamWriter osw) throws java.io.IOException {
        osw.write(toString());
    }
    
    @Override
    public String toString() {
        String s = "NLayer("+getClass().getName()+"):";
        s += "name="+name+";";
        s += "neurons("+neurons.size()+")={\n";
        for(Neuron n:neurons) s+= n.toString()+"\n";
        s += "}";
        return s;
    }
    /*
    public String[] toStrings() {
        String []ss = new String[neurons.size()+2];
        ss[0] = "NLayer("+getClass().getName()+"):";
        ss[0] += "name="+name+";";
        ss[0] += "neurons("+neurons.size()+")={";
        for(int i = 0; i < neurons.size(); i++) ss[i+1] = neurons.get(i).toString();
        ss[neurons.size()+1] = "}";
        return ss;
    }*/
 
    public java.util.ArrayList<String> toStrings() {
        java.util.ArrayList<String> als = new java.util.ArrayList<String>();
        String s = "NLayer("+getClass().getName()+"):";
        s += "name="+name+";";
        s += "neurons("+neurons.size()+")={";
        als.add(s);
        for(int i = 0; i < neurons.size(); i++) als.add(neurons.get(i).toString());
        als.add("}");
        return als;
    }
 
    /*
    protected String[] parse(String[] ss) {
        String tmp = ss[0].substring(ss[0].indexOf("name=")+5);
        name = tmp.substring(0, tmp.indexOf(";"));
        if(name.equals("null")) name = null;
        tmp = tmp.substring(tmp.indexOf("neurons(")+8);
        neurons = new java.util.ArrayList<Neuron>();
        int n = Integer.parseInt(tmp.substring(0, tmp.indexOf(")")))+1;
        for(int i = 1; i < n; i++) {
            try {
                String s = ss[i].substring(ss[i].indexOf("(")+1, ss[i].indexOf(")"));
                Class cl;
                try {
                    cl = Class.forName(s);
                } catch (ClassNotFoundException ex) {
                    cl = Neuron.class;
                }
                Neuron ne = (Neuron) cl.getConstructor(String.class).newInstance(ss[i]);
                addNeuron(ne);
            } catch (ReflectiveOperationException ex) {
                System.out.println("Пипец...");
            }
        }
        String []out = new String[ss.length-n];
        for(int i = 0; i < out.length; i++) {
            out[i] = ss[i+n];
        }
        return out;
    }*/
    protected java.util.ArrayList<String> parse(java.util.ArrayList<String> ss) {
        String tmp = ss.get(0).substring(ss.get(0).indexOf("name=")+5);
        name = tmp.substring(0, tmp.indexOf(";"));
        if(name.equals("null")) name = null;
        tmp = tmp.substring(tmp.indexOf("neurons(")+8);
        int n = Integer.parseInt(tmp.substring(0, tmp.indexOf(")")))+1;
        for(int i = 1; i < n; i++) {
            try {
                //System.out.println(ss.get(i));
                String s = ss.get(i).substring(ss.get(i).indexOf("(")+1, ss.get(i).indexOf(")"));
                Class cl;
                try {
                    cl = Class.forName(s);
                } catch (ClassNotFoundException ex) {
                    cl = Neuron.class;
                }
                Neuron ne = (Neuron) cl.getConstructor(String.class).newInstance(ss.get(i));
                addNeuron(ne);
            } catch (ReflectiveOperationException ex) {
                System.out.println("Пипец..."+ex.getMessage());
            }
        }
        for(int i = n; i > 0; i--) {
            ss.remove(i);
        }
        return ss;
    }

}
