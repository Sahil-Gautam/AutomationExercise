package utility;

import java.util.List;

public class DataInitiation {
	public static String email, password, product, firstName, paymentType;
	
	public static void initializeTestData(String user) throws Exception {
		List<String> list = ExcelOperations.readInputData(user);
		email = list.get(0);
		password = list.get(1);
		product = list.get(2);
		firstName = list.get(3);
		paymentType = list.get(4);
	}
}
