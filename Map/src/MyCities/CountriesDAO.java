package MyCities;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountriesDAO {
    List<Countries> countryList ;
    public  CountriesDAO(){
        this.countryList=new ArrayList<>();
    }

    public List<Countries> readCountriesFromCSV(String fileName){
        // reading lines from file and saving them in list
        File countriesFile = new File(fileName);
        List<String> lines = new ArrayList<>();
        String[] fields = {};
        try{
            lines = Files.readAllLines(countriesFile.toPath());
        }catch (Exception ex){
            System.out.println("There is a problem happened." + ex);
        }
        // extract all pyramids info and save them in a list
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            fields = line.split(",");

            for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
                fields[fieldIndex] = fields[fieldIndex].trim();
            }
            createCountries(fields);
        }
        //countryList.add(createCountries(fields));
        return this.countryList;
    }
    public Countries createCountries (String[]fields){
        Countries country = new Countries();
        try{
            country.setCountryId(Integer.parseInt(fields[0]));
        }catch (Exception ex){
            country.setCountryId(0);
        }
        try{
            country.setName(fields[1]);
        }catch (Exception ex){
            country.setName("null");
        }
        try{
            country.setContinent(fields[2]);
        }catch (Exception ex){
            country.setContinent("null");
        }

        countryList.add(country);
        return country;
    }
}
