package com.bigdata.mongodbcon;


import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Arrays;
import static javax.management.Query.eq;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("info");
        MongoCollection<Document>collection = database.getCollection("Personel");

        BasicDBObject data = new BasicDBObject()
                .append("name","Serdar Çolak")
                .append("date","1999")
                .append("Country","Turkey");

        BasicDBObject data2 = new BasicDBObject()
                .append("name","Serdar Çolak2")
                .append("date","1998")
                .append("Country","England");


        //Bir tane dokuman ekleme
        //collection.insertOne(Document.parse(data.toJson()));

        //Çoklu dokuman ekleme
        /*Document parse = Document.parse(data.toJson());
        Document parse2 = Document.parse(data2.toJson());

        collection.insertMany(Arrays.asList(parse,parse2));*/

        //Data okuma
        /*for (Document document : collection.find()) {
            System.out.println(document);
        }*/

        //Data okuma koşullu
        /*FindIterable<Document>documents = collection.find(new BasicDBObject("date", "1999"));
        for (Document document : documents){
            System.out.println(document.toJson());
        }*/

        /*Bson documents = Projections.fields(Projections.include("date","1999"));
        System.out.println(documents);*/

        //update etme
        /*
        Bson filter = Filters.eq("date","1999");
        Bson update =  Updates.set("name","Çolak Serdar");
        collection.updateOne(filter,update);*/

        //Silme
        /*Bson deleteFilter =  Filters.eq("name","Çolak Serdar");
        collection.deleteOne(deleteFilter);*/

        //collection silme
        //collection.drop();

        //db silme
        //database.drop();

    }
}