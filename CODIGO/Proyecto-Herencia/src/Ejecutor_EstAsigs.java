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
        this.promedio = this.calcularPromedio();   }
    public double calcularPromedio(){
        return (this.n1 + this.n2) / 2;     } 
    public void determinarEstado(double nota){
        this.estado = (nota > 7);     }
}

public class Ejecutor_EstAsigs {
    public static void main(String[] args) {
        
    }
}

