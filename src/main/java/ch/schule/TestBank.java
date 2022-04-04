package ch.schule;

public class TestBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// neue Bank
		Bank migrosbank = new Bank();
		
		migrosbank.createAccount();
		migrosbank.deposit("A-1000", 16000, 100000);
		
		migrosbank.print("A-1000");

	}

}
