package MyCities;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CitiesDAO {
    List<Cities> cityList ;

     public CitiesDAO(){
         this.cityList=new ArrayList<>();
     }

    public List<Cities> readCitiesfromCSV(String fileName){
        // reading lines from file and saving them in list
        this.cityList=new ArrayList<>();
        File citiesFile = new File(fileName);
        List<String> lines = new ArrayList<>();
        String[] fields = {};
        try{
            lines = Files.readAllLines(citiesFile.toPath());
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
            createCities(fields);
        }
        //cityList.add(createCities(fields));
        return this.cityList;
    }
    public Cities createCities (String[]fields){
        Cities city = new Cities();
        try{
            city.setCityId(Integer.parseInt(fields[0]));
        }catch (Exception ex){
            city.setCityId(0);
        }
        try{
            city.setCountryId(Integer.parseInt(fields[1]));
        }catch (Exception ex){
            city.setCountryId(0);
        }
        try{
            city.setName(fields[2]);
        }catch (Exception ex){
            city.setName("null");
        }
        try{
            city.setSurfaceArea(Integer.parseInt(fields[3]));
        }catch (Exception ex){
            city.setSurfaceArea(0);
        }
        try{
            city.setPopulation(Integer.parseInt(fields[4]));
        }catch (Exception ex){
            city.setPopulation(0);
        }
        try{
            city.setContinent(fields[5]);
        }catch (Exception ex){
            city.setContinent("null");
        }
        try{
            city.setCapital(fields[6]);
        }catch (Exception ex){
            city.setCapital("false");
        }

        cityList.add(city);
        return city;
    }
}
