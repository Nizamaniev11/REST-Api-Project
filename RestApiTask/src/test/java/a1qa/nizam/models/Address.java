package a1qa.nizam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;




@Getter @Setter @NoArgsConstructor
public class Address {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!Objects.equals(street, address.street)) return false;
        if (!Objects.equals(suite, address.suite)) return false;
        if (!Objects.equals(city, address.city)) return false;
        if (!Objects.equals(zipcode, address.zipcode)) return false;
        return Objects.equals(geo, address.geo);
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (suite != null ? suite.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (geo != null ? geo.hashCode() : 0);
        return result;
    }


}
