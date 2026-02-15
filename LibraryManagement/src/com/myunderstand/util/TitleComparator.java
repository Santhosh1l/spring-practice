package com.myunderstand.util;


import java.util.Comparator;


import com.myunderstand.beans.LibraryBooks;

public class TitleComparator implements Comparator<LibraryBooks>{
	@Override
	public int compare(LibraryBooks e1, LibraryBooks e2) {
		return e1.getTitle().compareToIgnoreCase(e2.getTitle());
	}
}
