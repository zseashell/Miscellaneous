package java_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws Exception {
		String storage = "object.dat";

		Bar bar = new Bar("bar", 1);

		// serialize
		FileOutputStream fileOutputStream = new FileOutputStream(storage);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				fileOutputStream);
		objectOutputStream.writeObject(bar);

		// de-serialize
		FileInputStream fileInputStream = new FileInputStream(storage);
		ObjectInputStream objectInputStream = new ObjectInputStream(
				fileInputStream);
		bar = (Bar) objectInputStream.readObject();
		System.out.println(bar.getName() + "-" + bar.getId());
	}

}
