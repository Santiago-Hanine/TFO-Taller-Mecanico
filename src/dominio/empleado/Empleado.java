package dominio.empleado;

import dominio.excepciones.HorasInvalidasException;

public abstract class Empleado {
    private final int legajo;

    public Empleado(int legajo) { this.legajo = legajo; }
    public int getLegajo() { return legajo; }

    /** Tarifa pura por hora del empleado */
    public abstract double tarifaHora();

    /** Costo por X horas */
    public double costoPor(double horas) throws HorasInvalidasException {
        if (horas <= 0) throw new HorasInvalidasException("Las horas deben ser > 0");
        return horas * tarifaHora();
    }
}
