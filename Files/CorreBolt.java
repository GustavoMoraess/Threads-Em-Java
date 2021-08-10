package Thread;
public class CorreBolt implements Runnable{
    private String nome;
    private double distPulo;
    private double distPercorrido;
    private double distMax;
    public CorreBolt(String n, double pu, double pe, double dm){
        nome=n;
        distPulo=pu;
        distPercorrido=pe;
        distMax=dm;
    }
    public void run(){
        while(distPercorrido<distMax){
            distPercorrido+=distPulo;
            System.out.println(nome +" Correndo"  + "distancia" + distPercorrido);
        }
    }
}