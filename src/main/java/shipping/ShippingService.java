package shipping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable p) {
        packages.add(p);
    }

    public List<Transportable> getPackages() {
        return packages;
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(c -> c.isBreakable() == breakable)
                .filter(c -> c.getWeight() >= weight)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> collectTransportableByCountry() {


        Map<String, Long> result = packages.stream()
                .filter(o -> o.getClass() == InternationalPackage.class)
                .map(o -> ((InternationalPackage) o).getDestinationCountry())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Integer> result2 = new HashMap<>();
     for (Map.Entry<String, Long> map : result.entrySet()) {
           result2.put(map.getKey(),map.getValue().intValue());
        }
        return result2;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return  packages.stream()
                .filter(o -> o.getClass() == InternationalPackage.class)
                .sorted()
                .collect(Collectors.toList());

//        return  packages.stream()
//                .filter(o -> o.getClass() == InternationalPackage.class)
//                .sorted(Comparator.comparing())
//                .collect(Collectors.toList());

    }


}
