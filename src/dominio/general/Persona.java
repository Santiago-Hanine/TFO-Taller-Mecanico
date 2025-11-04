package dominio.general;

public abstract class Persona {
    private static int contador = 0;
	private int id;
	private String nombre;
	private int edad;
	private int telefono;

	public Persona(String nombre, int edad, int telefono) {
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
        this.id = ++contador;
    }

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
