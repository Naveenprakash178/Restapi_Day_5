package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BookEntity;
import com.example.demo.service.BookService;
@RestController
public class ApiController {

	@Autowired
	BookService bookService;
			@GetMapping("/student")
			public List<BookEntity>getDetails()
			{
				return bookService.show();
			}
			@PostMapping("/book")
			public BookEntity create(@RequestBody BookEntity student)
			{
				return bookService.postDetails(student);
			}
			@PutMapping("/student/{id}")
			public String update(@RequestBody BookEntity student,@PathVariable Integer id)
			{
				BookEntity temp = bookService.get(id);
				if(temp !=null)
				{
					bookService.putDetails(student); 
					return "Student detail of id "+id+" updated";
				}
				return "Not found";
			}
			@DeleteMapping("/student/delete/{id}")
			public void delete(@PathVariable Integer id)
			{
				bookService.delete(id);
			}
			@DeleteMapping("/student/delete/direct")
			public void deleteDirect(BookEntity st)
			{
				bookService.deletedirect(st);
			}
			
}
