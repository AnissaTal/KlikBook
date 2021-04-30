package fr.doranco.KlikBook.metier.cryptage.algo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.doranco.KlikBook.enums.AlgorithmeCryptage;

public final class CryptageDES {
	
	private CryptageDES() {
	}

	public final static byte[] encrypt(String messageToEncrypt, SecretKey key) throws Exception {

		
		Cipher cipher = Cipher.getInstance(AlgorithmeCryptage.DES.toString());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageInByte = messageToEncrypt.getBytes("UTF-8");
		
		
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
	}

	public final static String decrypt(byte[] messageToDecrypt, SecretKey key) throws Exception {
		
		
		Cipher cipher = Cipher.getInstance(AlgorithmeCryptage.DES.toString());
		
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		
		String originalMessage = new String(messageDecrypte, "UTF-8");
		
		return originalMessage;

	}
}
