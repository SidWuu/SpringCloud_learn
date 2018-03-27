package com.springcloud.eureka.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.springcloud.eureka.service.CustomerService;
import com.springcloud.eureka.util.SessionUtil;
import com.springcloud.eureka.vo.Customer;

@Repository
public class CustomerDao {
	private static SqlSessionFactory factory=SessionUtil.getFactory("mybatis-config.xml");
	
	public List<Customer> query(){
		SqlSession session=factory.openSession();
		List<Customer> list=new ArrayList<Customer>();
		try {
			list=session.getMapper(CustomerService.class).query();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	public Customer getById(Long id){
		SqlSession session=factory.openSession();
		Customer mod=new Customer();
		try {
			mod=session.getMapper(CustomerService.class).getById(2L);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mod;
	}
	
	public void insert(Customer mod){
		SqlSession session=factory.openSession();
		try {
			mod.setId(null);
			session.getMapper(CustomerService.class).insert(mod);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void update(Customer mod) {
		SqlSession session=factory.openSession();
		try {
			Customer oldMod=session.getMapper(CustomerService.class).getById(mod.getId());
			if(null==oldMod){
				throw new Exception("不存在");
			}
			oldMod.setAge(mod.getAge());
			oldMod.setName(mod.getName());
			session.getMapper(CustomerService.class).update(oldMod);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(Long id) {
		SqlSession session=factory.openSession();
		try {
			session.getMapper(CustomerService.class).delete(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/*public static void main(String[] args) {
		SqlSession session=factory.openSession();
		try {
			Customer mod=new Customer();
			mod.setName("xixi");
			mod.setAge(0);
			session.getMapper(CustomerService.class).insert(mod);
			session.commit();
			Customer customer = new CustomerDao().getById(2L);
			System.out.println(customer.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}*/
}
