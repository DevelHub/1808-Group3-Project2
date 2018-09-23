package com.revature.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Company;
import com.revature.model.Item;
import com.revature.services.CompanyService;
import com.revature.services.ItemService;

@CrossOrigin
@RestController
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	ItemService is;
	
	@Autowired
	CompanyService cs;
	
	//allow for the company to add an item.
	@PostMapping("add")
	public int save(@RequestBody Item item){
		System.out.println("Adding an item.");
		return is.save(item);
	}
	
	//find all items in the DB.
	@GetMapping
	public List<Item> findAll() {
		return is.findAll();
		
	}
	

	//find a specific item by ID.
	@GetMapping("{id}")
	public Item findByItemId(@PathVariable int id){
		return is.findById(id);
	}
	
	//update the name of an item by obtaining the item id
	//inc : item name change
	@PatchMapping("update-name")
	public ResponseEntity<Item> updateName(@RequestBody Item item){
		Item inc = is.findById(item.getId());
		inc.setName(item.getName());
		is.save(inc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(inc, HttpStatus.CREATED);
		return response;
	}
	
	//update the status of an item by obtaining the item id
	//isc : item status change
	@PatchMapping("update-status")
	public ResponseEntity<Item> updateStatus(@RequestBody Item item){
		Item isc = is.findById(item.getId());
		isc.setStatus(item.getStatus());
		is.save(isc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(isc, HttpStatus.CREATED);
		return response;
	}
	
	//update the price of an item by obtaining the item id
	//ipc : item price change
	@PatchMapping("update-price")
	public ResponseEntity<Item> updatePrice(@RequestBody Item item){
		Item ipc = is.findById(item.getId());
		ipc.setPrice(item.getPrice());
		is.save(ipc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(ipc, HttpStatus.CREATED);
		return response;
	}
	
	@PatchMapping("update-description")
	public ResponseEntity<Item> updateDescription(@RequestBody Item item){
		Item idc = is.findById(item.getId());
		idc.setDescription(item.getDescription());
		is.save(idc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(idc, HttpStatus.CREATED);
		return response;
	}
    
	@GetMapping("total")
	public List<Map<String, Object>> findTotalItemsOfCompany() {
		System.out.println("Getting Number of Items by Company");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Company> companies = cs.findAll();
		int numberOfCompanies = companies.size();
		for (int i = 1; i <= numberOfCompanies; i++) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Item> items = is.findByCompanyId(i);
				String companyName = items.get(0).getCompany().getCompanyName();
				map.put("name", companyName);
				map.put("total", items.size());
				list.add(map);
			} catch(IndexOutOfBoundsException ex) {
				System.out.println("No Items");
			}
		}
		return list;
	}
    
}