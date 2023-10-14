
public class Produs {
	private int cod;
	private String denumire;
	private double pret;
	private boolean glutenFree;
	
	public Produs(int cod, String denumire, double pret, boolean glutenFree) {
		super();
		this.cod = cod;
		this.denumire = denumire;
		this.pret = pret;
		this.glutenFree = glutenFree;
	}


	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public boolean isGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	@Override
	public String toString() {
		return "Produs [cod=" + cod + ", denumire=" + denumire + ", pret=" + pret + ", glutenFree=" + glutenFree + "]";
	}
	
	

}
