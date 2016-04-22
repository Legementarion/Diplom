package NeuroNet;

import java.util.ArrayList;

public class NNet implements java.io.Serializable {
    
    protected java.util.ArrayList<Ninput> inputs;
    protected java.util.ArrayList<NLayer> layers;
    private String name;

    public NNet(java.util.ArrayList<String> inputs) {
        this();
        parse(inputs);
    }

    public NNet() {
        this.inputs = new java.util.ArrayList<Ninput>();
        this.layers = new java.util.ArrayList<NLayer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addLayer(NLayer nl) {
        if(layers.isEmpty()) nl.setInputs(inputs);
        else nl.setInputs(layers.get(layers.size()-1).getOutputs());
        layers.add(nl);
    }
    
    public NLayer getLastLayer() {
        return layers.isEmpty()?null:layers.get(layers.size()-1);
    }

    public java.util.ArrayList<Ninput> getInputs() {
        return inputs;
    }

    public void setInputs(java.util.ArrayList<? extends Ninput> inputs) {
        this.inputs = (ArrayList<Ninput>) inputs;
        if(!layers.isEmpty()) layers.get(0).setInputs(this.inputs);
    }
    
    public void addInput(Ninput ni) {
        inputs.add(ni);
    }
  
    public void work() {
        for(NLayer nl:layers) {
            nl.work();
        }
    }
    
    public java.util.ArrayList<String> toStrings() {
        java.util.ArrayList<String> als = new java.util.ArrayList<String>();
        String s = "NNet("+getClass().getName()+"):";
        s += "name="+name+";";
        s += "layers("+layers.size()+") = {";
        als.add(s);
        for(NLayer nl:layers) als.addAll(nl.toStrings());
        als.add("}");
        return als;
    }
    
    protected java.util.ArrayList<String> parse(java.util.ArrayList<String> ss) {
        String tmp = ss.get(0).substring(ss.get(0).indexOf("name=")+5);
        name = tmp.substring(0, tmp.indexOf(";"));
        if(name.equals("null")) name = null;
        tmp = tmp.substring(tmp.indexOf("layers(")+7);
        int n = Integer.parseInt(tmp.substring(0, tmp.indexOf(")")));
        for(int i = 0; i < n; i++) {
            try {
                ss.remove(0);
                System.out.println(ss.get(0));
                String s = ss.get(0).substring(ss.get(0).indexOf("(")+1, ss.get(0).indexOf(")"));
                Class cl;
                try {
                    cl = Class.forName(s);
                } catch (ClassNotFoundException ex) {
                    cl = NLayer.class;
                }
                NLayer nl = (NLayer) cl.getConstructor(java.util.ArrayList.class).newInstance(ss);
                this.addLayer(nl);
            } catch (ReflectiveOperationException ex) {
                System.out.println("Полный Пипец..."+ex.getMessage());
            }
        }
        ss.remove(0);
        ss.remove(0);
        return ss;
    }
}
