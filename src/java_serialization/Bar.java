package java_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * To allow sub-types of non-serializable classes to be serialized, the sub-type
 * may assume responsibility for saving and restoring the state of the
 * supertype's public, protected, and (if accessible) package fields. The
 * sub-type may assume this responsibility only if the class it extends has an
 * accessible no-arg constructor to initialize the class's state. It is an error
 * to declare a class serializable if this is not the case.
 * 
 */
public class Bar extends Foo implements Serializable {

	private static final long serialVersionUID = -7887185669396757829L;
	
	private int id;

	public Bar(String name, int id) {
		super(name);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	  // adding helper method for serialization to save/initialize super class state
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();

        String name  = ((String) ois.readObject());
//        this.name = name;
        setName(name);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        oos.writeObject(this.name);
    }
}
