package java_serialization;

public class Foo {

	protected String name;

	// must have its own non-arg constructor
	public Foo() {
		this.name = "default";
	}

	public Foo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
