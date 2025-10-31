package dominio.empleado;

public class Mecanico extends Empleado {
    private String especialidad;
    private double salarioMensual;
    private Nivel nivel;

    public Mecanico(int legajo, String especialidad, double salarioMensual, Nivel nivel) {
        super(legajo);
        this.especialidad = especialidad;
        this.salarioMensual = salarioMensual;
        this.nivel = nivel;
    }

    @Override
    public double tarifaHora() {
        double base = salarioMensual / 160.0; // simple: 160 hs/mes
        return base * nivel.factor();
    }

    // getters/setters mínimos si los necesitás
}
