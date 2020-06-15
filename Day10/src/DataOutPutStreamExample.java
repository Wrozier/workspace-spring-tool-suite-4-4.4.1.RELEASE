import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataOutPutStreamExample {

	public static void main(String[] args) {
		File file = new File ("data.dat");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(12345);
			dos.writeBoolean(true);
			dos.writeChar('W');
			dos.close();
		} catch (FileNotFoundException x){
			System.out.println("FileNotFoundException" + x.getMessage());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}

}
