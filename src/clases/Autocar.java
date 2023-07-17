package clases;

import java.util.Objects;

public class Autocar {

	private String matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	private int numPlazas;
	
	
	public Autocar() {
		super();
		this.matricula = "";
		this.marca = "";
		this.modelo = "";
		this.kilometros = 0;
		this.numPlazas = 30;
	}
	
	public Autocar(String matricula, String marca, String modelo, int kilometros, int numPlazas) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
		this.numPlazas = numPlazas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autocar other = (Autocar) obj;
		return Objects.equals(matricula, other.matricula);

	}

	@Override
	public String toString() {
		return "matricula: " + matricula + "\nmarca: " 
				+ marca + "\nmodelo: " + modelo + "\nkilometros: " + kilometros
				+ "\nnumPlazas: " + numPlazas;
	}
	
}
