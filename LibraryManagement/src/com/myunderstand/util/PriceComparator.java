package com.myunderstand.util;
import java.util.Comparator;

import com.myunderstand.beans.LibraryBooks;

public class PriceComparator implements Comparator<LibraryBooks> {

	@Override
	public int compare(LibraryBooks o1, LibraryBooks o2) {
		return Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
}}



