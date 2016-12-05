package com.morphia;

import java.util.Date;
import java.util.Random;

public class MorphiaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MorphiaUtils morphiaUtils = MorphiaUtils.getInstance();
		testQueryEntity(morphiaUtils);
		
	}
	
	
	@SuppressWarnings("unused")
	private static void testAddEntity(MorphiaUtils morphiaUtils){
		Date startDate = new Date();
		for(int i = 0;i<30;i++){
			TestEntity entity= new TestEntity(i);
			morphiaUtils.addEntity(entity);
			entity = null;
		}
		Date endDate = new Date();
		long diff = endDate.getTime() - startDate.getTime();
		System.out.println(diff+"ms");
	}
	
	@SuppressWarnings("unused")
	private static void testDelEntity(MorphiaUtils morphiaUtils){
		Random random = new Random();
		int i = random.nextInt(30);
		boolean f = morphiaUtils.delEntityByNum(i);
		System.out.println("delete result:" + f);
	}
	
	private static void testQueryEntity(MorphiaUtils morphiaUtils){
		Random random = new Random();
		int i = random.nextInt(30);
		TestEntity entity = morphiaUtils.getEntityByNum(i);
		System.out.println(entity);
	}
}
