package demo;

import java.awt.EventQueue;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.swing.JFrame;

public class PasswordEncryption {
	private static final Random RANDOM =new SecureRandom();	
	private static final String ALPHABET="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGHT = 256;
	public static String getSalt(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for(int i= 0; i<length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new
				String(returnValue);
	}
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec =new PBEKeySpec("password, salt, ITERATIONS, KEY_LENGHT");
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return
					skf.generateSecret(spec).getEncoded();
			
		}catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new
			AssertionError("Error while hashing a password: " +e.getMessage(), e);
		}
		finally {
			spec.clearPassword();
		}
	}

	private static void PBEKeySpec(char[] password, byte[] salt, int iterations2, int keyLenght) {
		// TODO Auto-generated method stub
		
	}

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordEncryption window = new PasswordEncryption();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordEncryption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
