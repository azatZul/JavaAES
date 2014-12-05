package tsd.crypto.algoritm;

import java.io.UTFDataFormatException;
import java.nio.charset.Charset;

public class Main {

	private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			String text = "�������� AES (��� Rijndael)";
			
			String k = "8a25s8fe3dsg65ss";
			System.out.println("�������� �����: "+text);
			System.out.println("������ ������ � UTF-8: " + text.getBytes().length + " ����");
			System.out.println("������ ����� � UTF-8: " + k.getBytes().length+" ����");
			byte[] enc = AES.encrypt(text.getBytes(), k.getBytes());
			System.out.println("����: "+new String(enc));

			byte[] dec = AES.decrypt(enc, k.getBytes());
			System.out.println("�������������� �����: "+new String(dec));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
