package cn.innohub.crawler.firstlevel;
public class FirstLevelSeed implements Comparable<FirstLevelSeed>{
	int fetchTime;
	int interval;
	String url;
	public FirstLevelSeed(int fetchTime,int interval,String url){
		this.fetchTime = fetchTime;
		this.interval = interval;
		this.url = url;
	}
	@Override
	public int compareTo(FirstLevelSeed o) {
		return fetchTime-o.fetchTime;
	}
	@Override
	public String toString() {
		return "FirstLevelSeed [fetchTime=" + fetchTime + ", interval=" + interval + ", url=" + url + "]";
	}

}