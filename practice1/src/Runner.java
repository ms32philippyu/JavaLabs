import by.gsu.ms32.BusinessTrip;
import by.gsu.ms32.Byn;


public class Runner {
    public static void main(String[] args) {

        Byn byn = new Byn();
        double maximumTotalExpenses = 0;
        double sum = 0;
        BusinessTrip[] businessTrips = {new BusinessTrip("Artem", 14256,2),
                null,
                new BusinessTrip("Petr", 15619,5),
                new BusinessTrip("Vlad", 14222,11),
                new BusinessTrip()};

        for (BusinessTrip b : businessTrips) {
            if(b != null)
                b.show();
        }

        businessTrips[businessTrips.length - 1].setTrasportExp(55555);
        int duration = businessTrips[0].getNumbOfDays() + businessTrips[2].getNumbOfDays();
        System.out.println("\nDuration = " + duration);
        System.out.print("\n");

        for (BusinessTrip b : businessTrips) {
            System.out.println(b);
        }

        for (BusinessTrip b : businessTrips) {
            if(b != null)
                sum += b.getTotal();
        }

        System.out.println("\nTotal sum = " + byn.toByn((int) sum));

        for (BusinessTrip b : businessTrips) {
            if(b != null){
                if(b.getTotal() > maximumTotalExpenses)
                    maximumTotalExpenses = b.getTotal();
            }

        }

        System.out.println("\nMaximum total expenses = " + byn.toByn((int) maximumTotalExpenses));

    }
}
