package c00_javase.a13_calendar;

import java.util.*;
import java.text.*;


class  CalendarDemo
{
	public static void main(String[] args) 
	{

		Calendar c = Calendar.getInstance();


		String[] mons = {"һ��","����","����","����"
					,"����","����","����","����"
					,"����","ʮ��","ʮһ��","ʮ����"};


		String[] weeks = {
						"","������","����һ","���ڶ�","������","������","������","������",
							};		
		int index = c.get(Calendar.MONTH);

		int index1 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR)+"��");
		//sop((c.get(Calendar.MONTH)+1)+"��");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH)+"��");
		//sop("����"+c.get(Calendar.DAY_OF_WEEK));
		sop(weeks[index1]);


		






		/*
		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		String year = sdf.format(d);

		System.out.println(year);

		*/
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}