package uta.mav.appoint.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncrypterString {

	public static void main(String[] args) {
		String encrypted = EncrypterString.encrypt("10010010");
		System.out.println(encrypted);
		System.out.println(EncrypterString.decrypt(encrypted));
		
		
	}
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'y' };

	public static String encrypt(Integer data){
		return encrypt(String.valueOf(data));
	}
	
	public static String encrypt(String Data) {
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(Data.getBytes());
			String encryptedValue = new BASE64Encoder().encode(encVal);
			return encryptedValue;
		} catch (Exception e) {
			return Data;
		}
	}

	public static String decrypt(String encryptedData) {
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Exception e) {
			return encryptedData;
		}
	}
	
	public static Integer decryptToInt(String encryptedData) {
		return Integer.valueOf(decrypt(encryptedData));
	}
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}
