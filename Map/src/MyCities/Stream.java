package MyCities;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream {

    public static Map<Integer, Optional<Cities>> countryHighestPopulationCity(List<Cities> cities){
        return cities.stream().collect(Collectors.groupingBy(Cities::getCountryId,Collectors.maxBy(Comparator.comparingInt(Cities::getPopulation))));
    }
    public static Map<String,Optional<Cities>> ContinentHighPopulationCity(List<Cities> cities){
        return cities.stream().collect(Collectors.groupingBy(Cities::getContinent,Collectors.maxBy(Comparator.comparingInt(Cities::getPopulation))));
    }
    public static Optional<Cities> highPopulationCapital (List<Cities> cities){
        return cities.stream().filter(Cities::isCapital).max(Comparator.comparingInt(Cities::getPopulation));
    }
}
