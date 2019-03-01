import by.gsu.ms32.BusinessTrip;

import java.text.NumberFormat;

public class Runner {
    public static void main(String[] args) {

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        double maximumTotalExpenses = 0;
        double sum = 0;
        BusinessTrip[] businessTrips = {new BusinessTrip("Artem", 142.56d,2),
                null,
                new BusinessTrip("Petr", 156.19d,5),
                new BusinessTrip("Vlad", 1422.56d,11),
                new BusinessTrip()};

        for (BusinessTrip b : businessTrips) {
            if(b != null)
                b.show();
        }

        businessTrips[businessTrips.length - 1].setTrasportExp(555.55d);
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

        System.out.println("\nTotal sum = " + nf.format(sum));

        for (BusinessTrip b : businessTrips) {
            if(b != null){
                if(b.getTotal() > maximumTotalExpenses)
                    maximumTotalExpenses = b.getTotal();
            }

        }

        System.out.println("\nMaximum total expenses = " + nf.format(maximumTotalExpenses));

    }
}
