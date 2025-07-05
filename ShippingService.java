
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShippingService {
    public void ship(ArrayList<Shippable> items) {
        if (items.isEmpty()) {
            return;
        }

        System.out.println("** Shipment notice ** ");

        Map<String, Integer> itemCounts = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            itemCounts.merge(item.getName(), 1, Integer::sum);
            totalWeight += item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            double weight = 0;

            for(Shippable item : items)
            {
                if(item.getName().equals(entry.getKey()))
                {
                    weight = item.getWeight();
                    break;
                }
            }

            System.out.printf(entry.getValue() + "x " + entry.getKey() + "      " + weight * entry.getValue() + "g\n");
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight / 1000);
        System.out.println();
    }
}