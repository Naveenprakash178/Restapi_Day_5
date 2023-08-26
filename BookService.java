package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.*;
import com.example.demo.repository.*;
@Service
public class BookService {

	@Autowired
	BookRepo repositorylayer;
	public List<BookEntity> show()
	{
		return repositorylayer.findAll();
	}
	public BookEntity postDetails(BookEntity modify)
	{
		return repositorylayer.save(modify);
	}
	public void putDetails(BookEntity name)
	{
		repositorylayer.saveAndFlush(name);
	}
	public void delete(Integer id)
	{
		repositorylayer.deleteById(id);
	}
	public void deletedirect(BookEntity st)
	{
		repositorylayer.delete(st);
	}
	public BookEntity get(Integer id)
	{
		return repositorylayer.findById(id).get();
	}

	
}
