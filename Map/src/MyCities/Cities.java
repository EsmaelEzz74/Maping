package MyCities;

import java.util.Comparator;

public class Cities  implements Comparator<Cities> {
    private int cityId,countryId, surfaceArea,population;
    private String name, capital,continent;


    public Cities(int cityId,int countryId, String name, int surfaceArea, int population , String capital){
        this.cityId=cityId;
        this.countryId=countryId;
        this.name=name;
        this.surfaceArea=surfaceArea;
        this.population=population;
        this.capital=capital;
    }
    public Cities(){}

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(int surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital.equals("yes");
    }

    public void setCapital(String  capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString(){
        return "City [ Country ID is : "+ countryId  +" , Name is : " + name + " , population is :"
                + population +" , Continent is : " + continent + " , is it a capital ?? : " + capital ;
    }
    public Cities getCity(){
        this.getCityId();
        this.getName();
        this.getSurfaceArea();
        this.getPopulation();
        this.isCapital();
        return this ;


    }


    @Override
    public int compare(Cities city1, Cities city2) {
        return Integer.compare(city1.population,city2.population);
    }
}
