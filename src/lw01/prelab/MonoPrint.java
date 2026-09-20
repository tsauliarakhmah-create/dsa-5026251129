public class MonoPrint extends PrintJob {

	private int ChargePerPage = 500;

	public MonoPrint(String id, int pages) {
		super(id, pages);
	}

	public int calculateCharge() {
		return getPages() * ChargePerPage;
	}

	public String label() {
		return "Mono"; 
	}

}