  $(function(){
	var ts = $("textarea");
	for(var i in ts){
		var t=$(ts[i]);
		var len = (t.val().split(/\n/).length)
		t.attr("rows",len)
		t.attr("disabled","disabled");
		t.attr("cols","100");
		t.css("resize","none");
	}

  });