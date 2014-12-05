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
			
			String text = "Алгоритм AES (или Rijndael)";
			
			String k = "8a25s8fe3dsg65ss";
			System.out.println("Исходный текст: "+text);
			System.out.println("Размер текста в UTF-8: " + text.getBytes().length + " байт");
			System.out.println("Размер ключа в UTF-8: " + k.getBytes().length+" байт");
			byte[] enc = AES.encrypt(text.getBytes(), k.getBytes());
			System.out.println("Шифр: "+new String(enc));

			byte[] dec = AES.decrypt(enc, k.getBytes());
			System.out.println("Расшифрованный текст: "+new String(dec));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
