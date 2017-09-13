package enums;

/**
 * Created by Nikolaj on 13.09.2017.
 */
public enum RegionEnums {
    MSK("Москве", "г. Москва"),
    SPB("Санкт-Петербурге", "г. Санкт-Петербург");

    public String region1;
    public String region2;

    RegionEnums(String region1, String region2){
        this.region1 = region1;
        this.region2 = region2;
    }
}
