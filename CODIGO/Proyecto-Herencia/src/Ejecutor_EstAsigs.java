
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
    public Estudiante(String nombEst, ArrayList<Asignatura> asigs)  {
        this.nombEst = nombEst;        this.asigs = asigs;          }
    @Override
    public String toString() {
        return "Estudiante{" + "nombEst=" + nombEst + ", asigs=" + asigs + '}';
    }
}
class Estudiante_Presencial extends Estudiante{
    public Estudiante_Presencial(String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);   }    
}
class Estudiante_Online extends Estudiante{
    public double beca;
    public Estudiante_Online(double beca, String nombEst, ArrayList<Asignatura> asigs) {
        super(nombEst, asigs);
        this.beca = beca;    }
    public boolean beca(){
        boolean estadoBeca = true;
        for(Asignatura asig : this.asigs)
            if (!asig.isEstado()){
               estadoBeca = false; 
               break;
            }
        return estadoBeca;
    }
    @Override
    public String toString() {
        return "Estudiante_Online{" + "beca=" + beca + '}' + super.toString();
    }
}
public class Ejecutor_EstAsigs {
    public static void main(String[] args) {
        ArrayList<Asignatura> asigsEst1 = new ArrayList<Asignatura>(Arrays.asList(
                                                                                  new Asignatura("POO", 6.5, 5.5),
                                                                                  new Asignatura("MATE", 10, 9)
                                                                                 ) 
                                                                   );
        ArrayList<Asignatura> asigsEst2 = new ArrayList<Asignatura>(Arrays.asList(
                                                                                  new Asignatura("PROG", 6, 5),
                                                                                  new Asignatura("ESTD", 4, 3)
                                                                                 ) 
                                                                   );
        Estudiante_Presencial est1 = new Estudiante_Presencial("Rual", asigsEst1);
        Estudiante_Online est2 = new Estudiante_Online(100.5, "Juana", asigsEst2);
        System.out.println(est1);
        System.out.println(est2);
    }
}

