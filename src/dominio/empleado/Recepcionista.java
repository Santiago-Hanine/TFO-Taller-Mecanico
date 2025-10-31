package dominio.empleado;

public class Recepcionista extends Empleado {
    private double tarifaHora;

    public Recepcionista(int legajo, double tarifaHora) {
        super(legajo);
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double tarifaHora() {
        return tarifaHora;
    }
}
