package com.springcloud.eureka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.eureka.dao.CustomerDao;
import com.springcloud.eureka.service.CustomerService;
import com.springcloud.eureka.vo.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> query() {
		return customerDao.query();
	}

	public Customer getById(Long id) {
		return customerDao.getById(id);
	}

	public void insert(Customer mod) {
		customerDao.insert(mod);
	}

	public void update(Customer mod) {
		customerDao.update(mod);
	}

	public void delete(Long id) {
		customerDao.delete(id);
	}
	
}
