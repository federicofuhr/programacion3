package entregable;

public class Tarea {
	/*
	 * Atributos de la clase Tarea
	 */
	private String nombre, descripcion;
	private int duracion;
	
	public Tarea(String nombre, String descripcion, int duracion) {
		/*
		 * Constructor de la clase
		 */
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
	}

	public String getNombre() {
		/*
		 * Retorna el atributo nombre. Su complejidad es O(1)
		 */
		return nombre;
	}

	public void setNombre(String nombre) {
		/*
		 * Carga el atributo nombre. Su complejidad es O(1)
		 */
		this.nombre = nombre;
	}

	public String getDescripcion() {
		/*
		 * Retorna el atributo descripcion. Su complejidad es O(1)
		 */
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		/*
		 * Carga el atributo descripcion. Su complejidad es O(1)
		 */
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		/*
		 * Retorna el atributo nombre. Su complejidad es O(1)
		 */
		return duracion;
	}

	public void setDuracion(int duracion) {
		/*
		 * Carga el atributo duracion. Su complejidad es O(1)
		 */
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDescripcion: " + descripcion + "\nDuracion: " + duracion;
	}
	
	
}
