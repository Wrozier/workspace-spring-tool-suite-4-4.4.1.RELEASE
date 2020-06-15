import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scannner;
		try {
			scannner = new Scanner(new File ("Data.text"));
			
			while(scannner.hasNextLine()) {
				String name = scannner.nextLine();
				System.out.println("name: " + name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
