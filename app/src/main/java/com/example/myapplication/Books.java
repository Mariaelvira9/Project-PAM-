package com.example.myapplication;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Books {

	@SerializedName("books")
	private List<BooksItem> books;

	public List<BooksItem> getBooks(){
		return books;
	}
}