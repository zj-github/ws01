/**
 * 保存到本地
 * 	1、文件对象的获取： require('fs');
 * 	2、文件对象的write方法：fs.write("文件名","要写的内容",'w'); //r是固定的，覆盖掉已经存在的文件
 * 
 */

var page = require('webpage').create();
var fs = require('fs');
page.open('http://web2.qq.com/', function(status){
    if(status !== 'success'){
        console.log('Unable to post!');
    }else{
        fs.write('webqq.html',page.content,'w');
    }
    phantom.exit();
});
