package edu.upc.bip.batch;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by osboxes on 18/12/16.
 */
public class MongoUtils {

    private static MongoClient client;

    public static void main(String[] args) throws MongoException, UnknownHostException, Exception {


        ServerAddress serverAddress = new ServerAddress("ds135798.mlab.com", 35798);

        MongoCredential mongoCredential = MongoCredential.createCredential("katya", "heroku_41659s43", "echo216".toCharArray());
        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(mongoCredential));
        MongoDatabase database = mongoClient.getDatabase("heroku_41659s43");


        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://anas_alba:echo216@ds135798.mlab.com:35798/heroku_41659s43"));


        // get handle to "heroku_dbname" database
        //MongoDatabase database = mongoClient.getDatabase("heroku_dbname");


        // get a handle to the "book" collection
        MongoCollection<Document> collection = database.getCollection("heatmap");

        // make a document and insert it
        Document doc = new Document("title", "Good Habits")
                .append("author", "Akbar");

        collection.insertOne(doc);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", BasicDBObjectBuilder.start("$gte", "10s2008-10-23T02:53:25").add("$lte", "10s2008-10-23T02:54:05").get());
        // get it (since it's the only one in there since we dropped the rest earlier on)
        MongoCursor cursor = collection.find(query).iterator();
        try {
            while (cursor.hasNext()) {

                //System.out.println(cursor.next());
                Document tobj = (Document) cursor.next();
                System.out.println(tobj.toJson());

            }
        } finally {
            cursor.close();
        }


        // release resources
        mongoClient.close();
    }

    public static List<String> getRecordRangeValues(String tableName, String startDateStr, String endDateStr) {
        List<String> result = new ArrayList<>();

        MongoDatabase database = getClient().getDatabase("heroku_41659s43");


        // get a handle to the "book" collection
        MongoCollection<Document> collection = database.getCollection(tableName);

        // make a document and insert it
        Document doc = new Document("title", "Good Habits")
                .append("author", "Akbar");

        collection.insertOne(doc);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", BasicDBObjectBuilder.start("$gte", startDateStr).add("$lte", endDateStr).get());
        // get it (since it's the only one in there since we dropped the rest earlier on)
        MongoCursor cursor = collection.find(query).iterator();
        try {
            while (cursor.hasNext()) {

                //System.out.println(cursor.next());
                Document tobj = (Document) cursor.next();
                System.out.println(tobj.toJson());
                result.add(tobj.toJson());
            }
        } finally {
            cursor.close();
        }


        // release resources
        //mongoClient.close();
        return result;
    }

    private static MongoClient getClient() {
        if (client == null) {
            ServerAddress serverAddress = new ServerAddress("ds135798.mlab.com", 35798);

            MongoCredential mongoCredential = MongoCredential.createCredential("katya", "heroku_41659s43", "echo216".toCharArray());
            client = new MongoClient(serverAddress, Arrays.asList(mongoCredential));
        }

       return client;
    }

    public static List<String> getAllRowIDs(String tableName) {
        List<String> result = new ArrayList<>();

        MongoDatabase database = getClient().getDatabase("heroku_41659s43");


        // get a handle to the "book" collection
        MongoCollection<Document> collection = database.getCollection(tableName);

        // make a document and insert it
        Document doc = new Document("title", "Good Habits")
                .append("author", "Akbar");

        collection.insertOne(doc);

        // get it (since it's the only one in there since we dropped the rest earlier on)
        MongoCursor cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {

                //System.out.println(cursor.next());
                Document tobj = (Document) cursor.next();
                System.out.println(tobj.toJson());
                result.add(tobj.toJson());
            }
        } finally {
            cursor.close();
        }


        // release resources
        //mongoClient.close();
        return result;
    }
}
