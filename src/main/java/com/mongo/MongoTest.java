package com.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("10.23.102.122",32800);
		MongoDatabase mongodb = mongoClient.getDatabase("saberTest");
		MongoCollection<Document> collection = mongodb.getCollection("hello_saber");
		//插入文档
		insert(collection);
		//检索文档
		retrieval(collection);
	}	
	
	@SuppressWarnings("unused")
	private static void retrieval(MongoCollection<Document> collection) {
		FindIterable<Document> iterable = collection.find();
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
	}
	
	@SuppressWarnings("unused")
	private static void insert(MongoCollection<Document> collection){
		Document doc = new Document("title","test")
			.append("key1", "value1")
			.append("key2", "value2")
			.append("key3", new Document("key33","value33"));
		List<Document> list = new ArrayList<Document>();	
		list.add(doc);
		collection.insertMany(list);
	}

}
