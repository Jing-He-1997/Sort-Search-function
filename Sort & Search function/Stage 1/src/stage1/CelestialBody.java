package stage1;

//Constellation, Plant, Stars, Messier super class
public class CelestialBody {
	
	protected String name;
	protected Double RA;
	protected Double dec;
	protected Double mag;
	protected Double dis;

	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRA(Double RA) {
		this.RA=RA;
	}
	
	public Double getRA() {
		return RA;
	}
	
	public void setDec(Double dec) {
		this.dec=dec;
	}
	
	public Double getDec() {
		return dec;
	}
	
	public void setMag(Double mag) {
		this.mag=mag;
	}
	
	public Double getMag() {
		return mag;
	}
	
	public void setDis(Double dis) {
		this.dis=dis;
	}
	
	public Double getDis() {
		return dis;
	}
	
}
