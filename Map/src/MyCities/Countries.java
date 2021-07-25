package MyCities;

public class Countries {
    private int countryId;
    private String name, continent;

    public Countries(int code , String name , String continent){
        this.countryId = code;
        this.name = name;
        this.continent = continent;
    }
    public Countries(){}

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString(){
        return "Country [Country ID is : " + countryId + ", Name=" + name + ", Continent is :" + continent;
    }
}
