
public abstract class WashService implements Billable {
    private String id;
    private int days;
    
    protected WashService(String id, int days) {
        if (days <= 0){
            throw new IllegalArgumentException("days must be positive");
        }
        this.id = id;
        this.days = days;
   }

   public String getId(){
        return id;
   }

   public int getDays(){
        return days;
   }

   public abstract int calculateCharge();

   public int calculateCharge(int units){
    return units * calculateCharge();
   }

   public String label(){
    return "Service";
   }

   public String summary(){
    return id + " |" + label() + " |" + calculateCharge();
   }
}
