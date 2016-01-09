package cn.iktz.p01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.iktz.p01.beans.ART;
import cn.iktz.p01.beans.Constant;
import cn.iktz.utils.JedisPoolUtil;

public class ARTService {
	
	public List<ART> getKeyList() throws Exception {
		Set<String> keys = JedisPoolUtil.keys(Constant.ART_KEY+"*");
		List<ART> arts = new ArrayList<>();
		for (String s : keys) {
			ART a = new ART();
			List<String> list = JedisPoolUtil.get(s,"title","sn");
			String title = list.get(0);
			String sn = list.get(1);
			System.out.println(title+" >> "+sn);
			a.setTitle(title);
			a.setSn(sn);
			arts.add(a);
		}
		return arts;
	}
	public ART getART(String sn){
		
		List<String> list = JedisPoolUtil.get(Constant.ART_KEY+sn,"title","h2","content" );
		ART a = new ART();
		a.setTitle(list.get(0));
		a.setH2(list.get(1));
		a.setContent(list.get(2));
		return a;
	}
}
