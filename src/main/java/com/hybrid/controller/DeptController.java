package com.hybrid.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.Dept;
import com.hybrid.service.DeptService;

@Controller
public class DeptController {
	
	static Log log = LogFactory.getLog(DeptController.class);
	
	@Autowired
	DeptService deptService;
	
           /*	JSON 으로 리턴*/
	//URL 등록 value의 값으로 호출 될때 자동으로 getList()를 호출
	@RequestMapping(value="/dept/list")
	@ResponseBody // Jackson 라이브러리를 이용해서 json의 형태로 값을 리턴한다.
	public List<Dept> getList(){

		return deptService.getList();
	}
	
	@RequestMapping(value="/dept", method=RequestMethod.GET)
	@ResponseBody
	public Dept getDept(Integer deptno){
		log.info("getDept() deptno=" + deptno);
		
		return deptService.getDept(deptno);	
	}
	
	
	@RequestMapping(value="/dept", method=RequestMethod.POST)
	@ResponseBody
	public Dept postDept(Dept dept){
		log.info("deptno = " + dept.getDeptno());
		log.info("dname = " + dept.getDname());
		log.info("loc = " + dept.getLoc());
		
		try{	
		deptService.insertDept(dept);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dept;
	}
	
	@RequestMapping(value="/dept", method=RequestMethod.DELETE)
	@ResponseBody
	public Dept deleteDept(Integer deptno){
		
		return deptService.deleteDept(deptno);
	}
	
	@RequestMapping(value="/dept", method=RequestMethod.PUT)
	@ResponseBody
	public Dept putDept(Dept dept){
		
		try{	
		deptService.updateDept(dept);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dept;
	}
	
	
	
}
