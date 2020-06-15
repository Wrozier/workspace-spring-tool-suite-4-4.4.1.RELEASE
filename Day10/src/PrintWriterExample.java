import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.*;

public class PrintWriterExample {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Data.dat");
		FileOutputStream fos = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(fos);
		
		//PrintWriter pw = new PrintWriter(file);
		
		ArrayList<String> names = new ArrayList<>();
		for(int i = 0;i <10; i++)
			names.add("name "+ i);
		pw.println(names);
		System.out.println("name:" + names);
		HashMap<Integer, String> hashMapOfNames = new HashMap<Integer, String>();
		for(int i=0; i<10; i++)
		hashMapOfNames.put( i, "name" + i);
		pw.println(hashMapOfNames);
		System.out.println("hasMapOfNames:" + hashMapOfNames);
		pw.close();

	}

}
