import java.util.ArrayList;
import java.util.Arrays;
/**
 * Problema 01: Este ejercicio es de repado para la gestión de est. y asigs
 * @author Daniel Irene
 * @version 1.0
 */
class Asignatura{
    public String nombAsig;
    public double n1, n2, promd, suple;
    private boolean estado;
    public Asignatura(String nombAsig, double n1, double n2) {
        this.nombAsig = nombAsig;      this.n1 = n1;       this.n2 = n2;
        calcularPromedio();                    }
    public void calcularPromedio(){
        this.promd = (this.n1 + this.n2) / 2;  }
    public void definirEstado(double nota){
        this.estado = (nota >= 7);              }
    public boolean isEstado() {
        return estado;                         }
    @Override
    public String toString() {
        return "Asignatura{" + "nombAsig=" + nombAsig + ", n1=" + n1 + ", n2=" + n2 + ", promd=" + promd + ", suple=" + suple + ", estado=" + estado + '}';
    }
}
class Estudiante{
    public String nombEst;
    public ArrayList<Asignatura> asigs;
    public Estudiante() {    }
    public Estudiante(String nombEst, ArrayList<Asignatura> asigs) {
        this.nombEst = nombEst;
        this.asigs = asigs;   } 
    @Override
    public String toString() {
        return "Estudiante{" + "nombEst=" + nombEst + ", asigs=" + asigs + '}';
    }
}
class Estudiante_Presencial extends Estudiante{ 
    public Estudiante_Presencial(String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);
    }
    @Override
    public String toString() {
        return "Estudiante_Presencial{" + super.toString() +'}';
    }
}
class Estudiante_Online extends Estudiante{
    public double porcentajeBeca;
    public boolean estadoBeca;
    public Estudiante_Online(double porcentajeBeca, String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);
        this.porcentajeBeca = porcentajeBeca;     }
    public void definirEstadoBeca(){
        this.estadoBeca = true;
        for(Asignatura asig : this.asigs){
            if(asig.isEstado() == false){
                this.estadoBeca = false;
                break;
            }
        }
    }
    @Override
    public String toString() {
        return "Estudiante_Online{" + "porcentajeBeca=" + porcentajeBeca + ", estadoBeca=" + estadoBeca + '}' + super.toString();
    }
}

public class Ejecutor_EstAsigs_V2 {
    public static void main(String[] args) {
        ArrayList<Asignatura> asigEst1 = new ArrayList<Asignatura>(
                                                                    Arrays.asList 
                                                                    (
                                                                     new Asignatura("POO", 9.5, 8.6),
                                                                     new Asignatura("MATE", 5.7, 4.6)
                                                                    )
                                                                  );
        ArrayList<Asignatura> asigEst2 = new ArrayList<Asignatura>(
                                                                    Arrays.asList 
                                                                    (
                                                                     new Asignatura("EST", 7.5, 3.1),
                                                                     new Asignatura("HUMN", 2.7, 2.3)
                                                                    )
                                                                  );
        Estudiante_Presencial est1 = new Estudiante_Presencial("Jojan", asigEst1);
        Estudiante_Online est2 = new Estudiante_Online(10, "JuanSebas", asigEst2);
        est1.asigs.get(0).definirEstado(est1.asigs.get(0).promd);
        est1.asigs.get(1).definirEstado(est1.asigs.get(1).promd);
        System.out.println(est1);
        est1.asigs.get(1).suple = 7;
        est1.asigs.get(1).definirEstado(est1.asigs.get(1).suple);
        System.out.println(est1);
        
        
    }
}
