package dominio.empleado;

public enum Nivel {
    JUNIOR(1.00), SEMI(1.20), SENIOR(1.50);

    private final double factor;
    Nivel(double factor) { this.factor = factor; }
    public double factor() { return factor; }
}
