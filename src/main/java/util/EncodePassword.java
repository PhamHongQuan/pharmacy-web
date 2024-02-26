package util;

import java.security.MessageDigest;

public class EncodePassword {
	public static String toSHA1(String str) {
		String rs = null;
		String salt = "23lklj2jn!@%$ASa";
		str += salt;
		try {
			byte[] data = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA1");
			rs = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(md.digest(data));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void main(String[] args) {
		System.out.println(toSHA1("12345"));
	}
}
