package tsd.crypto.algoritm;


import java.math.BigInteger;
import java.util.Random;

public class Sign {
	public static BigInteger rndBigInt(BigInteger max, BigInteger min) {
	    Random rnd = new Random();
	    do {
	        BigInteger i = new BigInteger(max.bitLength(), rnd);
	        if (i.compareTo(max) < 0 && i.compareTo(min)>0)
	            return i;
	    } while (true);
	}
	public static BigInteger[] sign(byte[] in){
		BigInteger p=new BigInteger("115792089237316195423570985008687907837957278154198333183605726673483560106291");
		BigInteger q=new BigInteger("340282366920938463463374607431768211297");
		BigInteger one=new BigInteger("1");
		BigInteger pp=p.subtract(one);
		BigInteger gamma= rndBigInt(pp,one);
		BigInteger pow=pp.divide(q);
		BigInteger g=gamma.modPow(pow, p);
		BigInteger x=rndBigInt(q.subtract(new BigInteger("2")),one);
		BigInteger y=g.modPow(x, p);
		
		BigInteger k=rndBigInt(q, new BigInteger("0"));
		byte[] hash=Hash.getHash(in);
		BigInteger hashNum=new BigInteger(hash);
		BigInteger r=g.modPow(k, p);
		BigInteger ro=r.mod(q);
		BigInteger s=ro.multiply(hashNum.multiply(k)).subtract(x).mod(q);
		//check
		BigInteger left=r.modPow(ro.multiply(hashNum), p);
		BigInteger right=g.modPow(s, p).multiply(y).mod(p);
		if(left.compareTo(right)==0){
			System.out.println("EQUAL!");
			System.out.println("Длина r "+r.toByteArray().length);
			System.out.println("Длина s "+s.toByteArray().length);
		}
		BigInteger[] res={r,s};
		return res;
	}
}
