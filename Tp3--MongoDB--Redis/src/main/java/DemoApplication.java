import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


public class DemoApplication {
    public static void main( String[] args )
    {
        //Implémentation MongoDB

        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        morphia.map(Person.class).map(Address.class).map(Article.class);
        Datastore ds = morphia.createDatastore(mongo, "my_database");

        Person p = new Person();
        p.setName("rantamplan");

        Address address = new Address();
        address.setStreet("123 Some street");
        address.setCity("Some city");
        address.setPostCode("123 456");
        address.setCountry("Some country");
        //set address
        p.setAddress(address);

        Article article=new Article();
        article.setName("Yaourt");
        article.setStars(12345678);
        article.setBuyers(p);
        // Save the POJO
        ds.save(p);
        ds.save(article);
        int i=0;
        for (Person e : ds.find(Person.class)){
            System.err.println("Nom:"+ e.getName());
            for (Address a:e.getAddress()){
                i++;
                System.err.println("Adresses "+i+":");
                System.err.println("Ville:"+a.getCity());
                System.err.println("Code postal:"+a.getPostCode());
                System.err.println("Rue:"+a.getStreet());
                System.err.println("Pays:"+a.getCountry());
            }
        }
        i=0;
        for (Article a:ds.find(Article.class)){
            i++;
            System.err.println("Article "+i+":");
            System.err.println("intitulé: "+a.getName());
            System.err.println("Stars: "+a.getStars());
            System.err.println("Acheteurs: ");
            for (Person person:a.getBuyers()){
                System.err.println("Nom:"+person.getName());
            }

        }

    }

}
