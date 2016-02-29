package com.hybrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;


// Spring에 자동 등록
@Service
public class DeptService {
	
		// 아래의 변수에 injection 요구 (필드 주입)
		@Autowired
		DeptMapper deptMapper;
		
	//Transaction 을 시작하고 에러시 rollback 아니면 commit처리
	@Transactional
	public List<Dept> getList(){
		
		List<Dept> depts = deptMapper.selectAll();
		
		return depts;
	}
	
	@Transactional
	public Dept getDept(Integer deptno){
		return deptMapper.selectByDeptno(deptno);
	}
	
	@Transactional
	public void insertDept(Dept dept){
		deptMapper.insert(dept);
	}
	
	@Transactional
	public Dept deleteDept(Integer deptno){
		Dept dept = deptMapper.selectByDeptno(deptno);
		deptMapper.deleteByDeptno(deptno);
		
		return dept;
	}
	
	@Transactional
	public void updateDept(Dept dept){
		deptMapper.updateByDeptno(dept);
	}
	
	

}
