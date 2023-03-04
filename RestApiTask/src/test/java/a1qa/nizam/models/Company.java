package a1qa.nizam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;



@Getter
@Setter
@NoArgsConstructor
public class Company{
    public String name;
    public String catchPhrase;
    public String bs;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!Objects.equals(name, company.name)) return false;
        if (!Objects.equals(catchPhrase, company.catchPhrase)) return false;
        return Objects.equals(bs, company.bs);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (catchPhrase != null ? catchPhrase.hashCode() : 0);
        result = 31 * result + (bs != null ? bs.hashCode() : 0);
        return result;
    }
}
