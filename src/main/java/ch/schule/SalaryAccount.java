package ch.schule;

/**
 * Lohnkonto.
 * 
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */
public class SalaryAccount extends Account {
	/**
	 * Kreditlimite dieses Sparkontos. Bis zu diesem Betrag darf das Saldo
	 * absinken, d.h. der Wert dieses Attributs ist normalerweise negativ.
	 */
	private long creditLimit;

	/**
	 * Erzeugt ein neues Lohnkonto.
	 * 
	 * @param id
	 *            die Kontonummer
	 * @param creditLimit
	 *            die Kreditlimite (eine negative Zahl!)
	 */
	public SalaryAccount(String id, long creditLimit) { // Konstruktor vom
														// Account wird
														// aufgerufen
		super(id);
		this.creditLimit = creditLimit;
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto ab.
	 * 
	 * @param date
	 *            das Transaktionsdatum
	 * @param amount
	 *            der abzuhebende Betrag
	 * 
	 * @return boolean <code>true</code>, falls die Abhebung erfolgreich war,
	 *         andernfalls (z.B. bei negativem Betrag, oder nicht gen�gend
	 *         Saldo) <code>false</code>.
	 */
	public boolean withdraw(int date, long amount) {
		long finalBalance = getBalance() - amount;

		if (finalBalance < creditLimit) {
			// falls cl ueberzogen dann Buchung mit amount =0 einfuegen!
			// Achtung: hier Buchung mit 0 Betrag!
			getBookings().add(new Booking(date, 0));

			return false;
		}
		return super.withdraw(date, amount);
	}

	/**
	 * Druckt den Kontoauszug dieses Kontos. �berschreiben der Methode print vom
	 * Account.
	 * 
	 */
	public void print() {
		System.out.println("Kontoauszug '" + getId() + "'" + " creditLimit "
				+ creditLimit);
		System.out.println("Datum           Betrag      Saldo");

		long balance = 0;

		for (int i = 0; i < getBookings().size(); ++i) {
			Booking b = (Booking) getBookings().get(i);

			if (b.getAmount() == 0) {
				// KOnto wurde �berzogen
				// Ausgabe m�sste in der print Methode sein
				System.out.print(BankUtils.formatBankDate(b.getDate()));
				System.out
						.println("        CreditLimit wurde überzogen -> keine Buchung!!");

			} else {
				b.print(balance);
				balance += b.getAmount();
			}

		}
	}
}
