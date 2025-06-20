public class EjecutorEmpleado {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente();
        Gerente gerente2 = new Gerente("Computacion", "Mary", "Joelito", 1000.0);
        System.out.println(gerente2);
    }
}
class Empleado{
    public String nombre;
    private double sueldo;
    public Empleado(){}
    public Empleado(String nombre, double sueldo){
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public double getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';}
}
class Gerente extends Empleado{
    public String departamento;
    public String secretaria;
    public Gerente(){}
    public Gerente(String departamento, String secretaria, String nombre, double sueldo){
        //Se invoca IMPLICITAMENTE el constror implicito del padre
        super(nombre, sueldo);//Se invoca EXPLICITAMENTE el constror EXPLICITO CON PARAMETOR/Sobrecargado del padre
        this.setSueldo(10000000);
        this.departamento = departamento;
        this.secretaria = secretaria;
    }
    public String toString() {
        return "Gerente{" + "departamento=" + departamento + ", secretaria=" + secretaria + '}' + " " + super.toString();
    }
}
class Operario extends Empleado{
    public double horasLaboradas;
    
}