package com.tca.comparators;

import java.util.Comparator;

import com.tca.entities.Student;

public class RnoComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) 
	{
		return o1.getRno().compareTo(o2.getRno());
	}

}
