import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import redis.clients.jedis.Jedis;


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



        //Implémentation Redis


        //Exemple1
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");

        System.err.println(value);

        //EXemple 2
        /*
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("counter"));
        jedis.incr("counter");
        System.out.println(jedis.get("counter"));
        */

        //Exemple 3
        /*
        String cacheKey = "cachekey";
        Jedis jedis = new Jedis("localhost");
        // adding a new key
        jedis.set(cacheKey, "cached value");
        // setting the TTL in seconds
        jedis.expire(cacheKey, 15);
        // Getting the remaining ttl
        System.out.println("TTL:" + jedis.ttl(cacheKey));
        Thread.sleep(1000);
        System.out.println("TTL:" + jedis.ttl(cacheKey));
        // Getting the cache value
        System.out.println("Cached Value:" + jedis.get(cacheKey));

        // Wait for the TTL finishs
        Thread.sleep(15000);

        // trying to get the expired key
        System.out.println("Expired Key:" + jedis.get(cacheKey));
        */

        //Exemple4
        /*
        String cacheKey = "languages";
        Jedis jedis = new Jedis("localhost");
        // Adding a set as value

        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "C#");
        jedis.sadd(cacheKey, "Python");// SADD

        // Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));
        // Adding new values
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "Ruby");
        // Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));
        */

    }

}
