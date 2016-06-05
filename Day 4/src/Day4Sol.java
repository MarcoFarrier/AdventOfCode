import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Day4Sol {

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		String input = "iwrupvqb";
		
		boolean hashFound = false;
		int count = 0;
		
		while(!hashFound)
		{
			String key = input + count;
			byte[] keyByte = key.getBytes();
			
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");
			md5Digest.update(keyByte);
			byte[] digest = md5Digest.digest();
			BigInteger digestInt = new BigInteger(1, digest);
			String digestString = digestInt.toString(16);
			
			while(digestString.length() < 32)
				digestString = "0" + digestString;
			
			
			if(digestString.substring(0, 6).equals("000000"))
			{
				hashFound = true;
				System.out.println(count);
			}
			
			count++;
		}
	}
}
