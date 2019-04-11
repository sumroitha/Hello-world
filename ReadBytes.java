import java.io.*;

public class ReadBytes {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		File f = new File("CDKHMSMDEUK900748");
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			long byteLength = f.length();
			byte[] fileContent = new byte[(int)byteLength];
			fis.read(fileContent, 0, (int) byteLength);
			for (int i=0; i < fileContent.length ; i++) {
				System.out.println("Bit of each Byte" + i + ": " + Integer.toBinaryString((fileContent[i] & 0xFF) + 0x100).substring(1));	
			}
			System.out.println(fileContent.length);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
