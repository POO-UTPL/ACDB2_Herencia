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
        this.estado = (nota > 7);              }
    public boolean isEstado() {
        return estado;                         }
}
class Estudiante{
    public String nombEst;
    public ArrayList<Asignatura> asigs;
    public Estudiante() {    }
    public Estudiante(String nombEst, ArrayList<Asignatura> asigs) {
        this.nombEst = nombEst;
        this.asigs = asigs;   }  
}
class Estudiante_Presencial extends Estudiante{ }
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
    }
}
