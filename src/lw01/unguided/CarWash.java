
public class CarWash extends WashService {
    
    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        if (getDays() <= 3){
            return getDays() * 35000 + 15000;
        }
        return getDays() * 25000 + 15000;
    }

    @Override
    public String label() {
        return "Car";
    }
}
