import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    private ObjectId id;
    private String name;
    private Set<Address> addresses=new HashSet<Address>();

    public Person(){

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddress() {
        return addresses;
    }

    public void setAddress(Address address) {
        addresses.add(address);
    }
}
