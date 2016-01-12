/*
 * 跳过指定的资源
 * 	使用request.abort()方法中断连接。
 */


//codes.js   
system = require('system')   
address = system.args[1];//获得命令行第二个参数 接下来会用到   
//console.log('Loading a web page');   
var page = require('webpage').create();   
var url = address;   
//console.log(url);   
var fs = require('fs');//文件

page.onResourceRequested = function(requestData, request) {
  if ((/(http|https):\/\/.+?\.(css|png|jpg|jpeg|)$/gi).test(requestData['url'])) {
    console.log('Skipping', requestData['url']);
    request.abort();
  }   
  if ((/(http|https):\/\/.+?\.js$/gi).test(requestData['url'])) {
    console.log('load js ', requestData['url']);
  }
};
page.open(url, function (status) {   
    //Page is loaded!   
    if (status !== 'success') {   
        console.log('Unable to post!');   
    } else {   
	    fs.write('163.html',page.content,'w');
    }      
    phantom.exit();   
});