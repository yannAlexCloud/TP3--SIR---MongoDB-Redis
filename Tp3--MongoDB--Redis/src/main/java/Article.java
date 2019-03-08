
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Article {
    @Id
    private ObjectId id;

    private String Name;

    private int stars;
    @Reference
    private Set<Person> buyers=new HashSet<Person>();

    public Article(){
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Set<Person> getBuyers() {
        return buyers;
    }

    public void setBuyers(Person buyer) {
        buyers.add(buyer);
    }
}
