package com.springcloud.eureka.service;

import java.util.List;

import com.springcloud.eureka.vo.Customer;

public interface CustomerService {
	public List<Customer> query();
	public Customer getById(Long id);
	public void insert(Customer mod);
	public void update(Customer mod);
	public void delete(Long id);
}
