package cn.innohub.crawler.conf.readxml;

import java.util.Comparator;
import java.util.Date;

import cn.innohub.crawler.conf.readxml.Host;


public class SeedComparator implements Comparator<Host> {

	@Override
	public int compare(Host o1, Host o2) {

		if(o1.getUrl().equals(o2.getUrl())){
			return 0;
		}
		
		Date nextFetchTime = o1.getNextFetchTime();
		Date now = new Date();
		if (nextFetchTime == null) {
			o1.setNextFetchTime(now);
			nextFetchTime = now;
		}
		Date nextFetchTime2 = o2.getNextFetchTime();
		if (nextFetchTime2 == null) {
			o2.setNextFetchTime(now);
			nextFetchTime2 = now;
		}
		
		return nextFetchTime.getTime() - nextFetchTime2.getTime() > 0 ? 1 : -1;
	}

}