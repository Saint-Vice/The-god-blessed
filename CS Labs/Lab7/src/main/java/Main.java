import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential= MongoCredential.createCredential("sampleUser", "Persons", "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("Persons");

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("Persons");
        System.out.println("Collection myCollection selected successfully");

        DocumentManipulation doc = new DocumentManipulation();
        doc.encryptFields(collection);
    }
}
