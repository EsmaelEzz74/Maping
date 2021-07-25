package MyCities;

import java.io.IOException;
import java.util.*;


public class MainClass {
    public static void main(String[] args) throws IOException {
        // create map key is integer and value is list of cities
        Map<Integer, List<Cities>> mergedMap = new HashMap<>();
        // read the countries csv file
        CountriesDAO countryDao = new CountriesDAO();
        List<Countries> countries = countryDao.readCountriesFromCSV("C:\\ITI\\Java\\Day 3\\countries.csv");
        // read the cities csv file
        CitiesDAO cityDao = new CitiesDAO();

        List<Cities> cities = cityDao.readCitiesfromCSV("C:\\ITI\\Java\\Day 3\\cities.csv");
        // sorting the cities list
        Cities cityComparator = new Cities();
        Collections.sort(cities, cityComparator);
        Collections.reverse(cities);
        //System.out.println(cities);
        // put every country id and its corresponding cities list in a map
        for (Cities city : cities) {
            List<Cities> newCity = mergedMap.get(city.getCountryId());
            if (newCity == null) {
                newCity = new ArrayList<>();
                mergedMap.put(city.getCountryId(), newCity);
            }
            newCity.add(city);
        }
        // print every key and its value in the map
        System.out.println("Print each city in the country : ");
        mergedMap.forEach((k, v) -> System.out.println("Country Id  : " + k + " -->  City : " + v));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.in.read();
        // get the high population city in the country
        System.out.println("Print the highest population city in each country : ");
        Map<Integer,Optional<Cities>> maxPopCityInCountry = Stream.countryHighestPopulationCity(cities);
        maxPopCityInCountry.forEach((k,v) -> System.out.println("Country Id is : " + k+" --> High Population City is : "+ v));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.in.read();
        // get the high population city in the continent
        System.out.println("Print the highest population city in the continent : ");
        Map<String, Optional<Cities>> maxPopCityInContinent = Stream.ContinentHighPopulationCity(cities);
        maxPopCityInContinent.forEach((k,v) -> System.out.println("Continent is : " + k+" --> High Population City is : "+ v));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.in.read();
        // get the high population capital
        System.out.println("Print the highest population capital : ");
        Optional<Cities> maxCapitalPop = Stream.highPopulationCapital(cities);
        System.out.println("Highest Population Capital is : " + maxCapitalPop);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }
}
