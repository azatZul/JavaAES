package tsd.crypto.algoritm;

import java.util.Arrays;

public class Hash {
	private static byte[] plus(byte[] b1, byte[] b2){
		byte[] result=new byte[b1.length];
		for(int i=0; i<b1.length;i++){
			result[i]=(byte) (b1[i]^b2[i]);
		}
		return result;
	}
	public static byte[] getHash(byte [] in){
		byte[] hash=new byte[16];
		for(int i=0;i<hash.length;i++){
			hash[i]=(byte)0;
		}
		for(int i=0;i<in.length/16;i=i+16){
			byte[] block=Arrays.copyOfRange(in, i, i+16);
			byte[] eps=AES.encryptBlockWithKey(hash, block);
			byte[] c=Hash.plus(block, hash);
			hash=Hash.plus(eps, c);
		}
		return hash;
	}
}
