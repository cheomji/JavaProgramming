
public abstract class Parent { // incorrect : public -> protected
	protected static int numChildren;
	protected int number;
	private String name;
	
	public Parent(String name){
		this.number = 0;
		this.name = name;
	}
	
	public static int getNumChildren() {
		return Parent.numChildren;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	protected abstract void increaseNumber();

}
