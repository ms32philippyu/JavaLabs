import by.gsu.ms32.Butter;
import by.gsu.ms32.Byn;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {

    private static String getTotalCost(Butter[] butter){
        Byn byn = new Byn();
        double total = 0;
        for (Butter aButter : butter) {
            total += aButter.getPrice();
        }

        return byn.toByn((int) total);
    }

    private static int getNumberWithHerbSuppl(Butter[] butter){
        int number = 0;

        for (Butter aButter : butter) {
            if (aButter.isAvailabilityOfHerbalSupplements()) {
                number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {

        Butter[] butters = {new Butter("Gusto",true,1455d),
                new Butter("Olivkovoe",true,1654d),
                new Butter("Podsolnechnoe",false,1854d),
                new Butter("Lnanoe",true,1543d),
                new Butter("Kukuruznoe",false,1265d),
                new Butter("Gorchichnoe",true,4565d),
                new Butter("Kunjutnoe",true,1341d),
                new Butter("Tikvennoe",false,1733d),
                new Butter("Soevoe",false,1345d),
                new Butter("Orehovoe",true,7823d),
        };

        System.out.println("Total cost = " + getTotalCost(butters));
        System.out.println("Number with HerbalSupplements = " + getNumberWithHerbSuppl(butters));
        System.out.println("\n===========Array without sorting=============");

        for (Butter butter : butters) {
            System.out.println(butter);
        }

        Arrays.sort(butters, new Comparator<Butter>() {
            public int compare(Butter o1, Butter o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("\n===========Array, sorted by name=============");
        for (Butter butter : butters) {
            System.out.println(butter);
        }

        Arrays.sort(butters);

        System.out.println("\n===========Array, sorted by price=============");
        for (Butter butter : butters) {
            System.out.println(butter);
        }

    }
}
