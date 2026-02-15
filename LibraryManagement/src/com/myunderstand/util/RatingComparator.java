package com.myunderstand.util;

import java.util.Comparator;

import com.myunderstand.beans.LibraryBooks;

public class RatingComparator implements Comparator<LibraryBooks>{

	@Override
	public int compare(LibraryBooks o1, LibraryBooks o2) {
		
		return Float.valueOf(o1.getRating()).compareTo(o2.getRating());
	}
	

	
	}
