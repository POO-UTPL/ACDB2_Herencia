public class EjecutorEmpleado {
    public static void main(String[] args) {
        Empleado jhoel = new Empleado("Jholein", 1500.0);
        System.out.println(jhoel);
        Gerente axcel = new Gerente();
        System.out.println(axcel);
        Gerente michael = new Gerente("IA", "Natasha", "Micha", 5000.0);
        System.out.println(michael);
    }
}
class Empleado{
    public String nombre;
    private double sueldo;
    public Empleado() {  }
    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo; } 
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';}
}
class Gerente extends Empleado{
    public String departamento;
    public String secretaria;
    public Gerente() {}
    public Gerente(String departamento, String secretaria, String nombre, double sueldo){
        //super(); //Invocacion explicita (si esta) / implicita (asi no este) de padre
        super(nombre, sueldo); //Invocacion EXPLICITA del constructor del padre
        this.departamento = departamento;
        this.secretaria = secretaria;}
    @Override
    public String toString() {
        return "Gerente{" + "departamento=" + departamento + ", secretaria=" + secretaria + '}' + super.toString();
    }
}
class Operario extends Empleado{
    public double horasLaboradas;}