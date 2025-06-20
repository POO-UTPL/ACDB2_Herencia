public class EjecutorGerenteOperario {
    public static void main(String[] args) {
        Gerente2 erick = new Gerente2("Humanismo", "Fernanda","Carlos", 200.0);
        //Gerente2 sebas = new Gerente2("Desarrollo", "Maria", "Sebastien", 100.0);
        Operario2 jowanVicente = new Operario2(1.0, "Vicente", 10.0);
        System.out.println(jowanVicente);
    }
}
class Empleado2 {
    public String nombre;
    private double sueldo;
    public Empleado2(){ }
    public Empleado2(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public String toString() {
        return "Empleado2{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }
}
class Gerente2 extends Empleado2 {
    public String depa, secre;

    public Gerente2(String depa, String secre, String nombre, double sueldo) {
        super(nombre, sueldo);
        this.depa = depa;
        this.secre = secre;
    }
    
    public String toString() {
        return "Gerente2{" + "depa=" + depa + ", secre=" + secre + '}' + super.toString();
    }
}

class Operario2 extends Empleado2 {
    private double horasLaboradas;
    public Operario2(double horasLaboradas, String nombre, double sueldo) {
        super(nombre, sueldo);
        this.horasLaboradas = horasLaboradas;
    }

    @Override
    public String toString() {
        return "Operario2{" + "horasLaboradas=" + horasLaboradas + "}   " + super.toString();
    }
    
}
