
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problema 01: Gestion de estudiantes con asigs. 
 * @author Daniel Irene 
 * @version 1.0
 */
class Asignatura{
    public String nombAsig;
    public double n1, n2, promedio, suple;
    private boolean estado;
    public Asignatura(String nombAsig, double n1, double n2) {
        this.nombAsig = nombAsig;    this.n1 = n1;     this.n2 = n2;     
        this.promedio = this.calcularPromedio();     }
    public double calcularPromedio(){
        return (this.n1 + this.n2) / 2;              } 
    public void determinarEstado(double nota){
        this.estado = (nota > 7);                    }
    public boolean isEstado() {
        return estado;                               }
    @Override
    public String toString() {
        return "Asignatura{" + "nombAsig=" + nombAsig + ", n1=" + n1 + ", n2=" + n2 + ", promedio=" + promedio + ", suple=" + suple + ", estado=" + estado + '}';
    }
}
class Estudiante{
    public String nombEst;     public ArrayList<Asignatura> asigs;
    public Estudiante() {}
    public Estudiante(String nombEst, ArrayList<Asignatura> asigs)  {
        this.nombEst = nombEst;        this.asigs = asigs;          }
    @Override
    public String toString() {
        return "Estudiante{" + "nombEst=" + nombEst + ", asigs=" + asigs + '}';
    }
}
class Estudiante_Presencial extends Estudiante{
    public Estudiante_Presencial(String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);                                                }    
}
class Estudiante_Online extends Estudiante{
    public double procentajeBeca;
    public boolean estadoBeca; //true => Con beca. false => Perdio beca
    public Estudiante_Online(double procentajeBeca, String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);
        this.procentajeBeca = procentajeBeca;                                 }
    public boolean definirBeca(){
        this.estadoBeca = true;
        for(Asignatura asig : this.asigs)
            if (asig.isEstado() == false){
               estadoBeca = false; 
               break;
            }
        return estadoBeca;                                                    }
    @Override
    public String toString() {
        return "Estudiante_Online{" + "procentajeBeca=" + procentajeBeca + ", estadoBeca=" + estadoBeca + '}' + super.toString(); }
}
public class Ejecutor_EstAsigs {
    public static void main(String[] args) {
        ArrayList<Asignatura> asigsEst1 = new ArrayList<Asignatura>(
                                                Arrays.asList(
                                                    new Asignatura("POO", 6.5, 5.5),
                                                    new Asignatura("MATE", 10, 9)
                                                ) 
                                              );
        ArrayList<Asignatura> asigsEst2 = new ArrayList<Asignatura>(
                                                Arrays.asList(
                                                    new Asignatura("PROG", 9.1, 7.8),
                                                    new Asignatura("ESTD", 8.6, 6.5)
                                                ) 
                                              );
        //ESTUDIANTE PRESENCIAL => SubClase de Estudiante
        Estudiante_Presencial est1 = new Estudiante_Presencial("Raul", asigsEst1);
        
        //ESTUDIANTE Online => SubClase de Estudiante
        Estudiante_Online est2 = new Estudiante_Online(10, "Jonathan", asigsEst2);
        for(Asignatura asig : asigsEst2){
            asig.determinarEstado(asig.promedio);
        }
        est2.definirBeca();
        System.out.println(est2);
    }
}

