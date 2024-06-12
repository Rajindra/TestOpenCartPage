package testSelenium;

import java.util.UUID;

public class Util {

	public static String generateRandomUsername() {
		return "user_" + UUID.randomUUID().toString();
	}

}
