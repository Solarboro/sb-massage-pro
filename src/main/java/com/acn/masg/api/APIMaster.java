package com.acn.masg.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface APIMaster<T> {
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	List<T> findAllEntity();
	
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET)
	List<T> findBySpeicfyId(@PathVariable String id);
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json")
	T saveEntity(@RequestBody T entity);
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE, consumes="application/json")
	void deleteEntity(@RequestBody T entity);
}
