
public class PolarPoint extends Point {
	private double r;
	private double theta;
	
	public PolarPoint (double r, double theta) {
		super(r*Math.cos(theta*Math.PI/180), r*Math.sin(theta*Math.PI/180));
		this.r = r; this.theta = theta;
	}
	
	public double getR() {
		return this.r;
	}
	public double getTheta() {
		return this.theta;
	}
	
	@Override
	public double distFromOrigin() {
		return this.r;
	}
	
	@Override
	public void setX(double x) {
		super.setX(x); // not this.setX << this makes recursive error. 
		this.r = super.distFromOrigin();
		theta = Math.atan2(this.getY(), this.getX())*180/Math.PI;
	}
	
	@Override
	public void setY(double y) {
		super.setY(y);
		this.r = super.distFromOrigin();
		theta = Math.atan2(this.getY(), this.getX())*180/Math.PI;
		
	}
}
