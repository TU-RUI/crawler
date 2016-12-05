package com.morphia;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@SuppressWarnings("deprecation")
public class MorphiaUtils {
	private static MorphiaUtils morphiaUtils = null;
	private Morphia morphia = null;
	private Mongo mongo = null;
	private DB db = null;
	private DBCollection collection = null;
	//10.23.102.122:32800;10.23.102.125:32800
	private static final String dbName = "test";
	private static final String collectionName = "entity";
	private static final String host1 = "10.23.102.122";
	private static final int port1 = 32800;
	private static final String host2 = "10.23.102.125";
	private static final int port2 = 32800;
	
	//初始化
	private MorphiaUtils(){
		morphia = new Morphia();
		morphia.map(TestEntity.class);
		MongoOptions mongoOptions = new MongoOptions();
		mongoOptions.setConnectionsPerHost(200);
		mongoOptions.setSocketKeepAlive(true);
		List<ServerAddress> serverList = new ArrayList<ServerAddress>();
		serverList.add(new ServerAddress(host1,port1));
		serverList.add(new ServerAddress(host2,port2));
		mongo = new Mongo(serverList,mongoOptions);
		db = mongo.getDB(dbName);
		collection = db.getCollection(collectionName);
	}
	
	//获取实例
	public static MorphiaUtils getInstance(){
		if(morphiaUtils == null){
			synchronized(MorphiaUtils.class){
				if(morphiaUtils == null){
					morphiaUtils = new MorphiaUtils();
				}
			}
		}
		return morphiaUtils;
	}
	
	//关闭连接
	public void close(){
		if(mongo!=null){
			mongo.close();
		}
		morphia = null;
		mongo = null;
		db = null;
		collection = null;
	}
	
	//添加entity
	public boolean addEntity(TestEntity entity){
		try {
			DBObject object = morphia.toDBObject(entity);
			collection.save(object, WriteConcern.SAFE);
			return true;
		} catch (MongoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	//删除entity
	public boolean delEntityByNum(Integer id){
		DBObject delObject = new BasicDBObject("num",id);
		try {
			collection.remove(delObject);
			return true;
		} catch (MongoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	//查询entity
	public 	TestEntity getEntityByNum(Integer id){
		DBObject queryObject = new BasicDBObject("num",id);
		DBCursor cursor = null;
		try {
			cursor = collection.find(queryObject).limit(1);
			if(cursor.hasNext()){
				TestEntity entity = morphia.fromDBObject(TestEntity.class, cursor.next());
				return entity;
			}
		} catch (MongoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(cursor!=null){
				cursor.close();
			}
		}
		return null;
	}
	
	
	
}
