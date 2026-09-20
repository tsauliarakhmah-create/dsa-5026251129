

public class ColourPrint extends PrintJob {

	private int firstPageLimit = 10; 
	private int firstPageCharge = 1500;
	private int extraPageCharge = 1000;
	private int setUpFee = 2000;

	public ColourPrint(String id, int pages) {
		super(id, pages);
	}

	@Override 
	public int calculateCharge() {
		int pages = getPages();
		int firstPages = Math.min(pages, firstPageLimit);
		int extraPages = Math.max(0, pages - firstPageLimit);

		return firstPages * firstPageCharge + extraPages * extraPageCharge + setUpFee;
	}	

	public String label() {
		return "Colour";
	}
}