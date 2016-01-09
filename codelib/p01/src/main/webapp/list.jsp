<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html>
 <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"> 
  <link rel="dns-prefetch" href="//res.wx.qq.com"> 
  <link rel="dns-prefetch" href="//mmbiz.qpic.cn"> 
  <link rel="shortcut icon" type="image/x-icon" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico"> 
  <meta name="apple-mobile-web-app-capable" content="yes"> 
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="format-detection" content="telephone=no"> 
  <title><!-- 1--></title> 
  <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve2a7a3f.css"> 
  <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_combo2a7a3f.css"> 
 </head> 
 <body id="activity-detail" class="zh_CN mm_appmsg" ontouchstart=""> 
  
  <div id="js_article" class="rich_media"> 
 
   <div class="rich_media_inner"> 
    <div id="page-content"> 
     <div id="img-content" class="rich_media_area_primary"> 
      <h2 class="rich_media_title" id="activity-name"> <!--2 --> </h2> 
<table>
	<c:forEach items="${arts}" var="art">
		<tr><td><a href="${pageContext.request.contextPath }/detail/${art.sn}">${art.title }</a></td></tr>
	</c:forEach>
</table>

     </div> 
	 
    </div> 
	
    <div id="js_pc_qr_code" class="qr_code_pc_outer" style="display:none;"> 
     <div class="qr_code_pc_inner"> 
      <div class="qr_code_pc"> 
       <img id="js_pc_qr_code_img" class="qr_code_pc_img"> 
       <p>微信扫一扫<br>关注该公众号</p> 
      </div> 
     </div> 
    </div> 
	
	
   </div> 
  </div> 
 
 </body>
</html>
