package cn.innohub.crawler.crawl.firstlevel.seeds.extract;

import java.util.Comparator;
import java.util.Date;

import cn.innohub.crawler.common.beans.FirstLevelSeed;

public class SeedComparator implements Comparator<FirstLevelSeed> {

	@Override
	public int compare(FirstLevelSeed o1, FirstLevelSeed o2) {

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