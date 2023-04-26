
public class Child extends Parent {

	public Child(String name) {
		super(name);
		Parent.numChildren++;
	}

	@Override
	public void increaseNumber() {
		this.number++;
	}

}
