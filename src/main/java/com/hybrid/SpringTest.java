package com.hybrid;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.shape.Shape;

public class SpringTest {
	static Log log = LogFactory.getLog(SpringTest.class);
	
	Shape s;
	Shape s1;
	
	SimpleDateFormat dateFormat;
	
	
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public SpringTest(){
		log.info("SpringTest()...");
		
	}
	
	public void setShape(Shape s){
		log.info("setShape()");
		this.s = s;
	}
	
	public void setShape1(Shape s1){
		log.info("setShape1()..");
		this.s1 = s1;
		
	}
	
	public void print() {
		log.info("s.width = " + s.getWidth());
		log.info("s.height = " + s.getHeight());
		log.info("s.color = " + s.getColor());
		log.info("s.date = " + dateFormat.format(s.getDate()));
		
		
		log.info("s1.width = " + s1.getWidth());
		log.info("s1.height = " + s1.getHeight());
		log.info("s1.color = " + s1.getColor());
		log.info("s1.date = " + dateFormat.format(s1.getDate()));
		
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans.xml");
		
//		Shape s = ctx.getBean(Shape.class);
		
		SpringTest spring = ctx.getBean(SpringTest.class);
		spring.print();
	
		ctx.close();
	}
	
	
}
