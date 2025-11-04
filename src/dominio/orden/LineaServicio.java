	package dominio.orden;

public class LineaServicio implements Facturable {
	private String descripcion;
	private double horas;
	private double tarifaHora;

	public LineaServicio(String descripcion, double horas, double tarifaHora) {
		this.descripcion = descripcion;
		this.horas = horas;
		this.tarifaHora = tarifaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getTarifaHora() {
		return tarifaHora;
	}

	public void setTarifaHora(double tarifaHora) {
		this.tarifaHora = tarifaHora;
	}
	@Override 
	public double calcularCostoTotal() { 
		return this.horas * this.tarifaHora;
	}
	public double subTotal() {
		return calcularCostoTotal();
	}
	
}
