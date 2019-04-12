import java.io.*;

public class DecodeBER {

	public static byte[] ReadBytes(File f){
		FileInputStream fis;
		byte[] fileContent=null;
		try {
			fis = new FileInputStream(f);
			long byteLength = f.length();
			fileContent = new byte[(int)byteLength];
			fis.read(fileContent, 0, (int) byteLength);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public static void main(String[] args) {
		File f = new File("test_file.txt");
		byte[] Bytes = ReadBytes(f);
		int TagForm;  // 0 Primitive , 1 Constructed
		
		for (int i=0; i < Bytes.length ; i++) {
			String BinNum = Integer.toBinaryString((Bytes[i] & 0xFF) + 0x100).substring(1);
			//Check for Tag Form 
			if( ((Bytes[i] >> 5) & 1) == 1 ){ // 1 Constructed
				TagForm = 1;
			}
			else{ // 0 Primitive
				TagForm = 0 ;
			}
			
			//Number of Tag
			int TempTagNumRang = Bytes[i] & 0x1F; // take 5 less significant bit 
			int TagNumRang;
			if( TempTagNumRang <= 30 ){
				//low tag number
				TagNumRang = TempTagNumRang;
			}
			else{
				//high tag number
				
			}
			
		}
	}

}
