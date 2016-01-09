<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
    
        var fn = function(){
            $("#id img").each(function() {//遍历所有图片
                var othis = $(this),//当前图片对象
                    top = othis.offset().top - $(window).scrollTop();//计算图片top - 滚动条top
                if (top > $(window).height()) {//如果该图片不可见
                    return;//不管
                } else {
                    othis.attr('src', othis.attr('data-src')).removeAttr('data-src');//可见的时候把占位值替换 并删除占位属性
                }
            });
        }
        
        fn();
        $window.scroll(fn).resize(fn);//绑定事件
        
        window.logs = {
                pagetime: {}
            };
            window.logs.pagetime['html_begin'] = (+new Date());
        </script>
        
<script type="text/javascript"> 
    var page_begintime = (+new Date());

    var biz = "MjM5NzAyNTE0Ng==";
    var sn = "5f5daa70f8652d9d5543a497b8cc1707" || "";
    var mid = "401593336" || "";
    var idx = "1" || "" ;
    
    
    var is_rumor = ""*1;
    var norumor = ""*1;
    if (!!is_rumor&&!norumor){
      if (!document.referrer || document.referrer.indexOf("mp.weixin.qq.com/mp/rumor") == -1){
        location.href = "http://mp.weixin.qq.com/mp/rumor?action=info&__biz=" + biz + "&mid=" + mid + "&idx=" + idx + "&sn=" + sn + "#wechat_redirect";
      }
    }

    
    
</script>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />

<link rel="dns-prefetch" href="//res.wx.qq.com">
<link rel="dns-prefetch" href="//mmbiz.qpic.cn">
<link rel="shortcut icon" type="image/x-icon" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript">
    String.prototype.html = function(encode) {
        var replace =["&#39;", "'", "&quot;", '"', "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&amp;", "&", "&yen;", "¥"];
        if (encode) {
            replace.reverse();
        }
        for (var i=0,str=this;i< replace.length;i+= 2) {
             str=str.replace(new RegExp(replace[i],'g'),replace[i+1]);
        }
        return str;
    };

    window.isInWeixinApp = function() {
        return /MicroMessenger/.test(navigator.userAgent);
    };

    window.getQueryFromURL = function(url) {
        url = url || 'http://qq.com/s?a=b#rd'; // 做一层保护，保证URL是合法的
        var query = url.split('?')[1].split('#')[0].split('&'),
            params = {};
        for (var i=0; i<query.length; i++) {
            var arg = query[i].split('=');
            params[arg[0]] = arg[1];
        }
        if (params['pass_ticket']) {
        	params['pass_ticket'] = encodeURIComponent(params['pass_ticket'].html(false).html(false).replace(/\s/g,"+"));
        }
        return params;
    };

    (function() {
	    var params = getQueryFromURL(location.href);
        window.uin = params['uin'] || '';
        window.key = params['key'] || '';
        window.wxtoken = params['wxtoken'] || '';
        window.pass_ticket = params['pass_ticket'] || '';
    })();

</script>

        <title>【年度案例】大数据盘点之Spark篇</title>
        
<link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve2a7a3f.css">
<style>
     
    </style>
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc2a7a3f.css">
<![endif]-->
<script type="text/javascript">
    document.domain = "qq.com";
</script>

    </head>
    <body id="activity-detail" class="zh_CN mm_appmsg" ontouchstart="">
        
    <script type="text/javascript">
        var write_sceen_time = (+new Date());
    </script>
    
    <div id="js_cmt_mine" class="discuss_container editing access" style="display:none;">
        <div class="discuss_container_inner">
            <h2 class="rich_media_title">【年度案例】大数据盘点之Spark篇</h2>
            <span id="log"></span>
            <div class="frm_textarea_box_wrp">
                <span class="frm_textarea_box">
                    <textarea id="js_cmt_input" class="frm_textarea" placeholder="留言将由公众号筛选后显示，对所有人可见。"></textarea>
                    <div class="emotion_tool">
                        <span class="emotion_switch" style="display:none;"></span>
                        <span id="js_emotion_switch" class="pic_emotion_switch_wrp">
                            <img class="pic_default" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/emotion/icon_emotion_switch.2x278965.png" alt="">
                            <img class="pic_active" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/emotion/icon_emotion_switch_active.2x278965.png" alt="">
                        </span>
                        <div class="emotion_panel" id="js_emotion_panel">
                            <span class="emotion_panel_arrow_wrp" id="js_emotion_panel_arrow_wrp">
                                <i class="emotion_panel_arrow arrow_out"></i>
                                <i class="emotion_panel_arrow arrow_in"></i>
                            </span>
                            <div class="emotion_list_wrp" id="js_slide_wrapper">
                                
                                
                            </div>
                            <ul class="emotion_navs" id="js_navbar">
                                
                            </ul>
                        </div>
                    </div>
                </span>
            </div>
            <div class="discuss_btn_wrp"><a id="js_cmt_submit" class="btn btn_primary btn_discuss btn_disabled" href="javascript:;">提交</a></div>
            <div class="discuss_list_wrp" style="display:none">
                <div class="rich_tips with_line title_tips discuss_title_line">
                    <span class="tips">我的留言</span>
                </div>
                <ul class="discuss_list" id="js_cmt_mylist"></ul>
            </div>
            <div class="rich_tips tips_global loading_tips" id="js_mycmt_loading">
                <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/icon_loading_white2805ea.gif" class="rich_icon icon_loading_white" alt="">
                <span class="tips">加载中</span>
            </div>
            <div class="wx_poptips" id="js_cmt_toast" style="display:none;">
                <img alt="" class="icon_toast" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGoAAABqCAYAAABUIcSXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3NpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDoyMTUxMzkxZS1jYWVhLTRmZTMtYTY2NS0xNTRkNDJiOGQyMWIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MTA3QzM2RTg3N0UwMTFFNEIzQURGMTQzNzQzMDAxQTUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MTA3QzM2RTc3N0UwMTFFNEIzQURGMTQzNzQzMDAxQTUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NWMyOGVjZTMtNzllZS00ODlhLWIxZTYtYzNmM2RjNzg2YjI2IiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjIxNTEzOTFlLWNhZWEtNGZlMy1hNjY1LTE1NGQ0MmI4ZDIxYiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pmvxj1gAAAVrSURBVHja7J15rF1TFMbXk74q1ZKHGlMkJVIhIgg1FH+YEpEQJCKmGBpThRoSs5jVVNrSQUvEEENIhGiiNf9BiERICCFIRbUiDa2qvudbOetF3Tzv7XWGffa55/uS7593977n3vO7e5+199p7v56BgQGh0tcmvAUERREUQVEERREUQVEERREUQVEERREUQVEERREUQVEERREUQVEERVAUQVEERVAUQbVYk+HdvZVG8b5F0xj4RvhouB+eCy8KrdzDJc1RtAX8ILxvx98V1GyCSkN98Cx4z/95/Wn4fj6j6tUEeN4wkFSnw1MJqj5NhBfAuwaUHREUg4lqNMmePVsHll/HFhVfe1t3FwpJI8DXCCquDrCWNN4B6Tb4M3Z98aTPmTvh0YHl18PXw29yZiKejoPvcUD6E74yFBJbVDk6Bb7K8aP/Hb4c/tRzEYIqprPhSxzlf4Uvhb/0Xoig8qnHAJ3lqPMzfDH8XZ4LEpRf2sVdA5/sqPO9Qfop70UJyn+/boaPddT5yrq7VUUvTIVJI7q74MMddXR8NB1eXcYvhBpZm0s2w72/o86HFoKvLau/pYaXzjLMdUJ6y0LwtWV9CIIaXtvA8+G9HHV03u5q+K+yH47U0NoRngPv7KjzHDwTLj0bS1BDazfJJlcnOOostC6ysnCT+q80G/sIvFVgeW09D8FPVT0uoP7VfvAD8NjA8pqmuAN+OcYAjso0RbIZ8DGB5TVNcRO8JMaHY9SXSdfa3eeANJimWBLrA7JFiZwIXye+NMUV8CcxP2SRFjXefok7NRjSGZJlWUPvw2/wtNiQirSoXWyMsR28wR7AzzYM0oXw+Y7yK+CLJGeaoqjyrJSdZJD6Ov4+z5y6NJc0Az7NUecHydIUy+v60KNyQHoM3nKI1y7YCFiq0i7uBvgER52vDdKqWn9djhY1Dn4G3n6Ecqm2rF74dvgoR53S0hQxW9RJAZAGW5bSn58QJA27dQ7uIEedjywEX5NKVxCqsY6y+qA+LxFI4+yZ6oH0trWkNan80jygtIUsc5SflgAsDXgehfdx1KkkTRE76tN+Xue2jnTU0Ru1oIbvpt30bBtKhOp5yaaRkts0lic8V1i6dPcIRx2d/l8Y8XtNNEg7OOo8bl1kmmOKnDsO88CaYzejau0hWZqiL7C83oCH4SeTHvwV2BqqsHRVztSEYOmWF80NeXZT6Hd4KflResE9vCnBOlCyGfDNAstHTVPUDWoQ1t3iW+9WNizvlhfd4aerXd+ThqiMfNR6+9LvOOro5OY5JX2H4+F7HZD+kGzlamMgldWiirQsjcwWFbjmqZJteekJLK9pisvgL6RhKvuciZiwzrWWGapfrPy30kBVcSBIrw0aD3PU0XB6cehntq7rTMf7/2iQlktDVdXJLXlg6VjmiYBn6rWSTRCH6hvJ0hQrpcGq8oidsmHpTP8t8DGO9/vcWt9qabiqPgup1yKyQwvC2tSefZ73SSpNkUJ4PlLorlHZ+446nc8f3fIyywlJhwrTuwVSjBa1ccvSxN0hjjoK5xVrYZMd9V6XbFfgBukixTwGLg8sDam3dZR/wZ6L/dJlin1en8LS+bgpFbz3Ygvzu1J1HKxYNqxGpCmaCEo12rrBorD6LRp8UbpcdR5VWhTW35KlKd6QFqjuM2XzwlpnMxTvSkuUwuG/Xlg6NtPjbT6WFimF/VG6LEvXgn8QGDjMbBukVECFwhpoS+CQatfX2Q1q6H7wENHdrfCr0lKleEB9JyxNneus+VJpsVL9TwI6W65LovWIGl3KtVJaLv7LBwYTFEERFEVQFEERFEVQFEERFEVQFEERFEVQFEERFEVQFEERFFWq/hFgADUMN4RzT6/OAAAAAElFTkSuQmCC">
                <p class="toast_content">已留言</p>
            </div>
        </div>
    </div>

    <div id="js_article" class="rich_media">
        
        <div id="js_top_ad_area" class="top_banner">
 
        </div>
                

        <div class="rich_media_inner">
            <div id="page-content">
                <div id="img-content" class="rich_media_area_primary">
                    <h2 class="rich_media_title" id="activity-name">
                        【年度案例】大数据盘点之Spark篇 
                    </h2>
                    <div class="rich_media_meta_list">
                        						                        <em id="post-date" class="rich_media_meta rich_media_meta_text">2016-01-07</em>

                                                <em class="rich_media_meta rich_media_meta_text">谭政</em>
                                                <a class="rich_media_meta rich_media_meta_link rich_media_meta_nickname" href="javascript:void(0);" id="post-user">hadoop123</a>
                        <span class="rich_media_meta rich_media_meta_text rich_media_meta_nickname">hadoop123</span>

                        <div id="js_profile_qrcode" class="profile_container" style="display:none;">
                            <div class="profile_inner">
                                <strong class="profile_nickname">hadoop123</strong>
                                <img class="profile_avatar" id="js_profile_qrcode_img" src="" alt="">

                                <p class="profile_meta">
                                <label class="profile_meta_label">微信号</label>
                                <span class="profile_meta_value">hadoop-123</span>
                                </p>

                                <p class="profile_meta">
                                <label class="profile_meta_label">功能介绍</label>
                                <span class="profile_meta_value">最知名的Hadoop/Spark/Docker大数据技术基地，分享Hadoop技术内幕，Hadoop最新技术进展，发布Hadoop相关职位和求职信息，Hadoop技术交流聚会、讲座以及会议等。</span>
                                </p>
                                
                            </div>
                            <span class="profile_arrow_wrp" id="js_profile_arrow_wrp">
                                <i class="profile_arrow arrow_out"></i>
                                <i class="profile_arrow arrow_in"></i>
                            </span>
                        </div>
                    </div>
                    
                    
                    
                    
                                                            
                                                            
                    
                    <div class="rich_media_content " id="js_content">
                        
                        <p style="white-space: normal; line-height: 23.2727px;"><em style="max-width: 100%; color: rgb(136, 136, 136); line-height: 25.6px; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><span style="max-width: 100%; font-size: 14px; box-sizing: border-box !important; word-wrap: break-word !important;">编者按：高可用架构推出 2015 年度案例系列文章，分享在架构领域具有典型意义的年度案例，本文由<span style="line-height: 23.2727px;"><span style="">谭政</span></span>分享。转载请注明来自高可用架构公众号「ArchNotes」。</span></em></p><p style="white-space: normal; line-height: 23.2727px;"><em style="max-width: 100%; color: rgb(136, 136, 136); line-height: 25.6px; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><span style="max-width: 100%; font-size: 14px; box-sizing: border-box !important; word-wrap: break-word !important;"><br  /></span></em></p><blockquote style="white-space: normal; line-height: 23.2727px;"><p><span style="font-size: 14px; line-height: 23.2727px;">谭政，Hulu 网大数据基础平台研发。曾在新浪微博平台工作过。专注于大数据存储和处理，对 Hadoop、HBase 以及 Spark 等等均有深入的了解。</span><br  /></p></blockquote><p style="line-height: 23.2727px; white-space: normal;"><br  /></p><h2 style="margin: 0.6em auto; padding-left: 0.5em; font-size: 20px; white-space: normal; max-width: 100%; color: rgb(62, 62, 62); border-left-width: 10px; border-left-style: solid; line-height: 1.5em; border-left-color: rgb(2, 156, 242); box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><strong style="line-height: 1.5em; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="">Spark 最新的特性以及功能</span></strong></h2><p><span style="line-height: 1.6;"><img data-s="300,640" data-type="png" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapOPKDreH4KzxlEcfdhZEd5VVbMZROLV54iapHYQtevWLXOhJE6RliaVia3iaP80qmcXbGOR0cYUicNYFYVA/0?wx_fmt=png" style="float: left;" data-ratio="1" data-w="100"  /> 2015 年中 Spark 版本从 1.2.1 升级到当前最新的 1.5.2，1.6.0 版本也马上要进行发布，每个版本都包含了许多的新特性以及重要的性能改进，我会按照时间顺序列举部分改进出来，希望大家对 Spark 版本的演化有一个稍微直观的认识。</span><br  /></p><p><br  /></p><p>由于篇幅关系，这次不能给大家一一讲解其中每一项改进，因此挑选了一些我认为比较重要的特性来给大家讲解。如有遗漏和错误，还请帮忙指正。</p><p><br  /></p><p><strong>Spark 版本演化</strong></p><p><br  /></p>
                        <p>首先还是先来看一下 Spark 对应版本的变化：</p><p>
                        <img data-s="300,640" data-type="png" 
data-src="http://localhost:8080/img/QU0WLzvA+DRmnlveLbiEng==" 
                        style="width: 100%; height: auto;" data-ratio="0.5053956834532374" data-w=""  />
                        
                        
                        <br  /></p><p><br  /></p><p>先来一个整体的介绍：1.2 版本主要集中于 Shuffle 优化， 1.3 版本主要的贡献是 DataFrame API， 1.4 版本引入 R API 并启动 Tungsten 项目阶段，1.5 版本完成了 Tungsten 项目的第一阶段，1.6 版本将会继续进行 Tungsten 项目的第二个阶段。<span style="line-height: 1.6;">而我下面则重点介绍 DataFrame API 以及 Tungsten 项目。</span></p><p><br  /></p><p><strong><span style="line-height: 1.6;">DataFrame 介绍</span></strong></p><p><span style="line-height: 1.6;">DataFrame API 是在 1.3.0 中引入的，其目的是为了统一 Spark 中对结构化数据的处理。在引入 DataFrame 之前，Spark 之有上针对结构化数据的 SQL 查询以及 Hive 查询。</span></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;">这些查询的处理流程基本类似：查询串先需要经过解析器生成逻辑查询计划，然后经过优化器生成物理查询计划，最终被执行器调度执行。</span><br  /></p><p><br  /></p><p><span style="line-height: 1.6;">而不同的查询引擎有不同的优化器和执行器实现，并且使用了不同的中间数据结构，这就导致很难将不同的引擎的优化合并到一起，新增一个查询语言也是非常艰难。</span></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;">为了解决这个问题，Spark 对结构化数据表示进行了高层抽象，产生了 DataFrame API。简单来说 DataFrame 可以看做是带有 Schema 的 RDD（在1.3之前DataFrame 就叫做 SchemaRDD，受到 R 以及 Python 的启发改为 DataFrame这个名字）。</span><br  /></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;">在 DataFrame 上可以应用一系列的表达式，最终生成一个树形的逻辑计划。这个逻辑计划将会经历 Analysis, Logical Optimization, Physical Planning 以及 Code Generation 阶段最终变成可执行的 RDD，如下图所示：</span><br  /></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;"><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpllMyyHxM5U7J0fTUqjJHfE9aMXgZnbgB0FT94Hk4JXdzpvgXVX4P5Pw/0?wx_fmt=jpeg" data-ratio="0.24280575539568344" data-w=""  /><br  /></span></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;">在上图中，除了最开始解析 SQL/HQL 查询串不一样之外，剩下的部分都是同一套执行流程，在这套流程上 Spark 实现了对上层 Spark SQL, Hive SQL, DataFrame 以及 R 语言的支持。</span></p><p><span style="line-height: 1.6;"><br  /></span></p><p><span style="line-height: 1.6;"><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpliapV3BicgrvvicGpNBkFekQzbU03k8icwia5bpKkVIpia3E3jFV6Y5S5lRicw/0?wx_fmt=jpeg" data-ratio="0.6654676258992805" data-w=""  /><br  /></span></p><p><br  /></p><p><span style="line-height: 1.6;"><span style="">下面我们来看看这些语言的简单示例：</span><br style=""  /><span style="">Spark SQL : </span><span style="">val count = sqlContext.sql(&quot;SELECT COUNT(*) FROM records&quot;).collect().head.getLong(0)</span></span></p><p><span style="line-height: 1.6;"><span style=""><br  /></span></span></p><p><span style="line-height: 1.6;"><span style=""><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpl2QnQknDkXgia9vSyzdO3YsTrkEErTImTUicNicAZxiaNAic1t10tC9bCOcg/0?wx_fmt=jpeg" data-ratio="0.1510791366906475" data-w=""  /><br  /></span></span></p><p><span style="line-height: 1.6;"><span style=""><br  /></span></span></p><p><span style="line-height: 1.6;"><span style=""><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIplK5Wezbke8XiaYWcqvRO7Ec4c3Tq9A1pR6VTfvmXXLLcMmUrJWaz7sVQ/0?wx_fmt=jpeg" data-ratio="0.17266187050359713" data-w=""  /><br  /></span></span></p><p><span style="line-height: 1.6;"><span style=""><br  /></span></span></p><p><br  /></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIplSlE7FX2r6hmCW65elzBKcMBFeHia1y66M2SRIpHKWXPDCZY3fGicEXZA/0?wx_fmt=jpeg" data-ratio="0.21762589928057555" data-w=""  /><br  /></span></span></p><p><br  /></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><br  /></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style="">各个语言的使用方式都很类似。</span><span style="">除了类 SQL 的表达式操作之外，DataFrame 也提供普通的类似于 RDD 的转换，例如可以写如下代码：</span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><br  /></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIplAnOhiaicm2pCwKcDFUlZdnnWl50gmysCqMJBFozWSkWkPNiazKicZQiaz2A/0?wx_fmt=jpeg" data-ratio="0.08273381294964029" data-w=""  /><br  /></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">另外还值得一提的是，和 DataFrame API 紧密相关的 API -- DataSource API。如果说 DataFrame API 提供的是对结构化数据的高层抽象，那么 DataSource API 提供的则是对于结构化数据统一的读写接口。</span><br style=""  /><br style=""  /><span style="">DataSource API 支持从 JSON, JDBC, ORC, parquet 中加载结构化数据 (SQLContext 类中的诸多读取方法，均会返回一个 DataFrame 对象)，也同时支持将 DataFrame 的数据写入到上述数据源中 (DataFrame 中的 save 系列方法 )。</span><br style=""  /><br style=""  /><span style="">这两个 API 再加上层多种语言的支持，使得 Spark 对结构化数据拥有强大的处理能力，极大简化了用户编程工作。</span><br style=""  /><br style=""  /><strong><span style="">Tungsten 项目介绍</span></strong><br style=""  /><br style=""  /><span style="">在官方介绍中 Tungsten 将会是对 Spark 执行引擎所做的最大的修改，其主要目标是改进 Spark 内存和 CPU 的使用效率，尽可能发挥出机器硬件的最大性能。</span><br style=""  /><br style=""  /><span style="">之所以将优化的重点集中在内存和 CPU 而不是 IO 之上是社区实践发现现在很多的大数据应用的瓶颈在 CPU 。</span><span style="">例如目前很多网络 IO 链路的速度达到 10Gbps，SSD 硬盘和 Striped HDD 阵列的使用也使得磁盘 IO 也有较大提升。而 CPU 的主频却没有多少提升，CPU 核数的增长也不如前两者迅速。</span><br style=""  /><br style=""  /><span style="">此外在 Spark 已经对 IO 做过很多的优化（如列存储以及 IO 剪枝可以减少 IO的数据量，优化的 Shuffle 改善了 IO 和网络的传输效率），再继续进行优化提升空间并不大。</span><br style=""  /><br style=""  /><span style="">而随着序列化以及 Hash 的广泛使用，现在 CPU 反而成为了一个瓶颈。</span><br style=""  /><br style=""  /><span style="">内存方面，使用 Java 原生的堆内存管理方式很容易产生 OOM 问题，并伴随着较大的 GC 负担，进一步降低了 CPU 的利用率。</span><br style=""  /><br style=""  /><span style="">基于上述观察 Spark 在 1.4 中启动了 Tungsten 项目，并在 1.5 中完成第一阶段的优化</span><br style=""  /><br style=""  /><span style="">这些优化包括下面三个方面：</span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""><br  /></span></span></span></span></p><ul class=" list-paddingleft-2" style="list-style-type: square;"><li><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">内存管理和二进制格式处理</span></span></span></span></p></li><li><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">缓存友好的计算</span></span></span></span></p></li><li><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">代码生成</span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span></span></span></span></p><p><br  /></p></li></ul><p><strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span><span style="">内存管理和二进制格式处理</span></span></span></span></strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span><br style=""  /><span style="">避免以原生格式存储 Java 对象(使用二进制的存储格式），减少 GC 负担</span><br style=""  /><span style="">压缩内存数据格式，减少内存占用以及可能的溢写。</span><span style="">使用更准确的内存的统计而不是依赖启发规则管理内存。</span><br style=""  /><br style=""  /><span style="">对于那些已知数据格式运算( DataFrame 和 SQL )，直接使用二进制的运算，避免序列化和反序列化开销。</span><br style=""  /><strong><span style=""><br  /></span></strong></span></span></span></p><p><strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">缓存友好的计算</span></span></span></span></strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span><br style=""  /><span style="">更加快的排序以及 Hash，优化 Aggregation, Join 以及 Shuffle 操作。</span><br style=""  /><span style=""><br  /></span></span></span></span></p><p><strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style="">代码生成</span></span></span></span></strong><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span><br style=""  /><span style="">更快的表达式计算以及 DataFrame/SQL 运算（这是代码生成的主要应用场景，主要是为了降低进行表达式评估中 JVM 的各种开销，如虚函数调用，分支预测，原始类型的对象装箱开销以及内存消耗）</span><span style="">更快的序列化。</span><br style=""  /><br style=""  /><span style="">相关的每个版本所做的优化如下：</span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIplLn3YEfibpsBLx9NP0YusdGpKmU6dsCJ8238KwAlBGz5QWgIYOPxy17g/0?wx_fmt=jpeg" data-ratio="0.5053956834532374" data-w=""  /><br  /></span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""><br  /></span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""></span></span></span></span></p><p>Tungsten 项目并不是完全是一个通用的优化技术，其中很多优化利用了 DataFrame 模型所提供的丰富的语义信息（因此 DataFrame 和 Spark SQL 查询能够享受该项目所来的大量的好处），同样未来也会改进 RDD API 来为底层优化提供更多的信息支持。</p><p><br  /></p><h2 style="margin: 0.6em auto; padding-left: 0.5em; font-size: 20px; white-space: normal; max-width: 100%; color: rgb(62, 62, 62); border-left-width: 10px; border-left-style: solid; line-height: 1.5em; border-left-color: rgb(2, 156, 242); box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><strong style="line-height: 1.5em; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style=""><span style="line-height: 23.2727px;">Spark 在 Hulu 的实践</span></span></strong></h2><p>Hulu 是一家在线付费视频网站，每天都有大量的用户观看行为数据产生，这些数据会由 Hulu 的大数据平台进行存储以及处理。推荐团队需要从这些数据中挖掘出单个用户感兴趣的内容并推荐给对应的观众，广告团队需要根据用户的观看记录以及行为给其推荐的最合适广告，而数据团队则需要分析所有数据的各个维度并为公司的策略制定提供有效支持。</p><p><br  /></p><p>他们的所有工作都是在 Hulu 的大数据平台上完成的，该平台由 HDFS/Yarn, HBase, Hive, Cassandera 以及的 Presto，Spark 等组成。Spark 是运行在 Yarn上，由 Yarn 来管理资源并进行任务调度。</p><p><br  /></p><p>Spark 则主要有两类应用：Streaming 应用以及短时 Job。</p><p><br  /></p><p>Streaming 应用中各个设备前端将用户的行为日志输入到 Kafka 中，然后由 Spark Streaming 来进行处理，输出结果到 Cassandera, HBase 以及 HDFS 中。短时 Job 并不像 Streaming 应用一样一直运行，而是由用户或者定时脚本触发，一般运行时间从几分钟到十几个小时不等。</p><p><br  /></p><p>此外为了方便 PM 类型的用户更便捷的使用 Spark，我们也搭建了 Apache Zeppelin 这种交互式可视化执行环境。对于非 Python/Scala/Java/R 用户（例如某些用户想在 NodeJS 中提交 Spark 任务），我们也提供 REST 的 Spark-JobServer 来方便用户提交作业。</p><p><br  /></p><p>Hulu 从 0.9 版本就开始将 Spark 应用于线上作业，内部经历了 1.1.1, 1.2.0, 1.4.0 等诸多版本，目前内部使用的最新版本是基于社区 1.5.1 进行改造的。</p><p><br  /></p><p>在之前的版本中我们遇到的很多的问题也添加了不少新功能，大部分修改都已经包含在最新版本里面，我就不再这里赘述了。这节里我主要想讲的是社区里所没有的，但是我们认为还比较重要的一些修改。</p><p><br  /></p><p><strong>较多的迭代触发 StackOverflow 的问题</strong></p><p>在某些机器学习算法里面需要进行比较多轮的迭代，当迭代的次数超过一定次数时候应用程序就会发生 StackOverflow 而崩溃。<span style="line-height: 1.6;">这个次数限制并不会很大，几百次迭代就可能发生栈溢出。大家可以利用一小段代码来进行一个简单的测试：</span></p><p><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpltqibpIPB9U43WzqVGVhMA2cn2QufvG3tDENdnlGvvCUML9gtnyPEpgg/0?wx_fmt=jpeg" data-ratio="0.2823741007194245" data-w=""  /><br  /></p><p><br  /></p><p>产生上述错误的原因在于 Driver 将 RDD 任务发送给 Executor 执行的时候需要将 RDD 的信息序列化后广播到对应的 Executor 上。<span style="line-height: 1.6;">而 RDD 在序列的时候需要递归将其依赖的 RDD 序列化，这样在出现长 lineage 的 RDD 的时候就可能因为线程的栈帧内存不够，抛出 StackOverflow 异常。</span></p><p><br  /></p><p>解决方法也比较直接，就是将递归改为迭代，把原来需要递归保存在线程栈帧的序列化 RDD 挪到堆区进行保存。<span style="line-height: 1.6;">具体的做法是将 RDD 的依赖关系分离出来，变成两个映射表: rddId-&gt;List of depId 以及depId -&gt; Dependency。</span><span style="line-height: 1.6;">Driver 端然后将 RDD 以及这些映射序列化为字节数组广播出去，Executor 端接收到广播消息后重新将映射组装成为原始的依赖。</span></p><p><br  /></p><p>这个过程中要改动 RDD 核心 Task 接口，需要经过严格的测试。但是在做这种优化之后，迭代个一两千次都没有什么问题。</p><p><br  /></p><p><strong>Streaming 延迟数据接收机制( Receive-Base )</strong></p><p>在 Receive-Base 的 Spark Streaming 的架构中, 主要有两个角色 Driver 和 Executor。</p><p><br  /></p><p>在 Executor 中运行着 Receiver, Receiver 的主要作用是从外部接收数据并缓存到本地内存中，同时 Receiver 回向 Driver 汇报自己所接收的数据块，Driver 定期产生新的任务并分发到各个 Executor 去处理这些数据。</p><p><br  /></p><p>在应用启动的时候，Driver 会首先将 Receiver 处理程序调度到各个 Executor 上让其初始化。一旦 Receiver 初始化完毕，它就开始源源不断的接收数据，并且需要 Driver 定期调度任务来消耗这些数据。</p><p><br  /></p><p>但是在某些场景下, Executor 处理端还并没有准备好，无法开始处理数据。</p><p><br  /></p><p>这时候在 Receiver 端就会发生内存积压，随着积压的数据越来越多，大部分数据都会撑过新生代回收年龄进入老年代，进一步给 GC 带来严重的压力，这个时候也就离应用程序崩溃不远了。</p><p><br  /></p><p>在 Hulu 的 Spark Streaming 处理中，需要加载并初始化很多机器学习的模型，这些模型的初始化非常费时间，长的可能需要半个小时才能初始化完毕。在此期间 Receiver 不能接收数据，否者内存将会被消耗殆尽。</p><p><br  /></p><p>Hulu 中的解决方法是在每个 Executor 接收任何任务之前先进行执行一个用户定义的初始化任务，初始化任务中可以执行一些独立的用户代码。我们在新增了一个接口，让用户可以设置自定义的初始化任务。</p><p><br  /></p><p>如下代码所示：</p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpl7H5H22DVgUTYmFeQANBK8UPDeicPRibfcoDHD2auEqib0ibuticDszGzxQw/0?wx_fmt=jpeg" data-ratio="0.33992805755395683" data-w=""  /><br  /></span></span></span></span></p><p><span style="font-family:微软雅黑, Microsoft Yahei, Helvetica Neue, Hiragino Sans GB, 宋体, simsun, 黑体, Arial, sans-serif"><span style="line-height: 24px;"><span style=""><span style=""><br  /></span></span></span></span></p><p>实现上需要更改 Spark 的任务调度器，先将每个 Executor 设置为未初始化状态，除了初始化任务之外调度器不会给未初始化状态的 Executor 分配其他任务。等 Executor 运行完初始化任务，调度器更新 Executor 的状态为已初始化，这样的 Executor 就可以分配给其他正常任务了，包括初始化 Receiver 的任务。</p><p><br  /></p><p><strong>其他注意事项</strong></p><p>Spark 允许用户设置 spark.executor.userClassPathFirst，这可以部分缓解用户代码库和 Spark 系统代码库冲突的问题。</p><p><br  /></p><p>但是在实践过程中我们发现，大并发情况加载相同的类有可能发生死锁的情况（我们的一个场景下有 1/10 几率复现该问题）。</p><p><br  /></p><p>其问题在于 Spark 所新增加的 ChildFirstURLClassLoader 的实现引入了并发死锁的问题。</p><p><br  /></p><p>Java 7 中的 ClassLoader 本身提供细粒度的类加载并发锁，可以做到为每个 classname 设置一个锁，但是使用该细粒度的类加载锁有一个条件，用户自己实现的 ClassLoader 必须在自身静态初始化方法中将自己注册到 ClassLoader 中。</p><p><br  /></p><p>然而在 Scala 语言中并没有类的静态初始化方法，只有一个伴生对象的初始化方法。但是伴生对象和类对象的类型并不完全一致。</p><p><br  /></p><p>因此 Scala 在 ChildFirstURLClassLoader 中模仿 Java 的 ClassLoader 实现了自己的细粒度的类加载锁，然而这段代码却无法达到预期目的，最终还是会降级到 ClassLoader 级别的锁，并且在某些场景下还会触发死锁，解决方法是去除对应的细粒度锁代码。</p><p><br  /></p><h2 style="margin: 0.6em auto; padding-left: 0.5em; font-size: 20px; white-space: normal; max-width: 100%; color: rgb(62, 62, 62); border-left-width: 10px; border-left-style: solid; line-height: 1.5em; border-left-color: rgb(2, 156, 242); box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><strong style="line-height: 1.5em; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style=""><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;">Spark 未来的发展趋势</span></span></span></strong></h2><p><span style="line-height: 1.6;">Spark 1.6 即将发布，其中最重要的特性有两个 [SPARK-10000] 统一内存管理以及 [SPARK-9999] DataSet API。当然还有很多其他的改进，由于篇幅关系，下面主要介绍上两个。</span><br  /></p><p><br  /></p><p><strong>统一内存管理</strong></p><p>在 1.5 以及之前存在两个独立的内存管理：执行时内存管理以及存储内存管理，前者是在对 Shuffle, Join, Sort, Aggregation 等计算的时候所用到的内存，后者是缓存以及广播变量时用的内存。</p><p><br  /></p><p>可以通过 spark.storage.memoryFraction 来指定两部分的大小，默认存储占据 60% 的堆内存。<span style="line-height: 1.6;">这种方式分配的内存都是静态的，需要手动调优以避免 spill，且没有一个合理的默认值可以覆盖到所有的应用场景。</span></p><p><br  /></p><p>在 1.6 中这两个部分内存管理被统一起来了，当执行时内存超过给自己分配的大小时可以临时向存储时内存借用空间，临时借用的内存可以在任何时候被回收，反之亦然。更进一步可以设置存储内存的最低量，系统保证这部分量不会被剔除。</p><p><br  /></p><p><strong>DataSet API</strong></p><p>RDD API 存储的是原始的 JVM 对象，提供丰富的函数式运算符，使用起来很灵活，但是由于缺乏类型信息很难对它的执行过程优化。DataFrame API 存储的是 Row 对象，提供了基于表达式的运算以及逻辑查询计划，很方便做优化，并且执行起来速度很快，但是却不如 RDD API 灵活。</p><p><br  /></p><p>DataSet API 则充分结合了二者的优势，既允许用户很方便的操作领域对象又拥有 SQL 执行引擎的高性能表现。</p><p><br  /></p><p>本质上来说 DataSet API 相当于 RDD + Encoder， Encoder 可以将原始的 JVM对象高效的转化为二进制格式，使得可以后续对其进行更多的处理。目前是实现为 Catalyst 的逻辑计划，这样就能够充分利用现有的 Tungsten 的优化成果。</p><p><br  /></p><p>DataSet API 需要达到如下几点目标：</p><ul class=" list-paddingleft-2" style="list-style-type: square;"><li><p>快速：Encoder 需要至少和现有的 Kryo 或者 Java 序列一样快。</p></li><li><p><span style="line-height: 1.6;">类型安全：在操作这些对象的时候需要尽可能提供编译时的类型安全，如果编译期无法知晓类型，在发生 Schema 不匹配的时候需要快速失败。</span></p></li><li><p><span style="line-height: 1.6;">对象模型支持：默认需要提供原子类型，case 类，tuple， POJOs, JavaBeans 的 Encoder。</span></p></li><li><p><span style="line-height: 1.6;">Java 兼容性：需要提供一个简单的 API 来兼容 Scala 和 Java，尽可能使用这些 API，如果实在不能使用这些API也需要提供重载的版本。</span></p></li><li><p><span style="line-height: 1.6;">DataFrame 的互操作：用户需要能够无缝的在 DataSet API 和 DataFrame API之间做转换。</span></p></li></ul><p><br  /></p><p>目前 DataSet API 和 DataFrame API 还是独立的两个 API，未来 DataFrame 有可能继承自 DataSet[Row]。</p><p><br  /></p><p>最后再来看一下整体的架构：</p><p><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONgnKr8wkAq1raricNnAlIpl3nD0fZtooqJG67wiaYUWDA8LugTslWHHph4f5gUoR5p5yF2bOfoDWTQ/0?wx_fmt=jpeg" data-ratio="0.38669064748201437" data-w=""  /><br  /><br  /></p><h2 style="margin: 0.6em auto; padding-left: 0.5em; font-size: 20px; white-space: normal; max-width: 100%; color: rgb(62, 62, 62); border-left-width: 10px; border-left-style: solid; line-height: 1.5em; border-left-color: rgb(2, 156, 242); box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><strong style="line-height: 1.5em; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;">参考文章</span></span></strong></h2><p><strong>Hadoop年度回顾与2016发展趋势</strong></p><p><img data-s="300,640" data-type="png" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONa9YjfwAIibGRJRv03AGgtVXCyuLPlWgPtA5eRj6rAO6xqfTRvGsZfUniaykngn0xZmZrtQTMdVUfw/0?wx_fmt=png" data-ratio="0.3579136690647482" data-w=""  /><br  /></p><p><strong><span style="line-height: 1.6;">Apache HBase 2015年发展回顾与未来展望</span></strong><br  /></p><p><img data-s="300,640" data-type="png" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapONa9YjfwAIibGRJRv03AGgtVHYELhWv5LhZxJSWic8tMRQxSJDMd1xRAF8xZRdsXRejCxmqRM3zq8Nw/0?wx_fmt=png" data-ratio="0.2978723404255319" data-w="470"  /><br  /></p><p><br  /></p><h2 style="margin: 0.6em auto; padding-left: 0.5em; font-size: 20px; white-space: normal; max-width: 100%; color: rgb(62, 62, 62); border-left-width: 10px; border-left-style: solid; line-height: 1.5em; border-left-color: rgb(2, 156, 242); box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);"><strong style="line-height: 1.5em; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;">Q &amp; A</span></span></strong></h2><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">1、</span></span></span>在 hulu, streaming 跑在多少个节点上？Zeppelin 和 sparknotebook.io 各有什么优劣、是如何选型的？</strong></p><p>hulu 的 Spark Streaming 运行在 YARN 上，规模是几百个节点。我们当前主要用的是 Zeppelin，sparknotebook.ion 目前还没有试用</p><p><br  /></p><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">2、</span></span></span>我们用的是 hive on spark 模式，因为 hive 是统一入口，上面已经有 mr 和 tez，请问对比 spark sql 各自优缺点？还有就到对比一下 spark shuffle 和 yarn自带 shuffle（on yarn 模式）的优缺点？</strong></p><p>底层的存储引擎不一样，相比于性能方面 spark 和 tez 不相上下，但是稳定性方面 spark 更胜一筹。spark shuffle 提供了三种实现，分别是 hash-based，sort-based 和 tungsten-sort, 而 mapreduce shuffle 知识 sort-based，在灵活度上，spark 更高，且个别之处，spark 有深度优化。</p><p><br  /></p><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">3、</span></span></span>能否简单说说 spark 在图片计算方面的应用？</strong></p><p>是指图像处理方面吗，这方面 Spark 并没有专门的组件来处理。图片方面的应用比较少，至少在 hulu 没有。</p><p><br  /></p><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">4、</span></span></span>Tungsten 项目目前成熟吗？或者说贵司有线上应用没？</strong></p><p>Tungsten 项目还处于开发阶段（阶段二），不建议在线上使用。</p><p><br  /></p><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">5、</span></span></span>请问使用 Spark streaming 在 <span style="line-height: 25.6px;">YARN</span> 上和其他任务共同运行，稳定性如何？<span style="line-height: 25.6px;">YARN</span> 有没有做 CPU 级别的隔离？我们在 <span style="line-height: 25.6px;">YARN</span> 上运行的任务，运行几天就会挂掉，通常都是 OOM，但是从程序看，并没有使用过多内存。</strong></p><p>如果 YARN 上还会混合运行 mapreduce 和 tez 等应用，则会对 Spark streaming 存在资源竞争，造成性能不稳定，可以使用 label-based scheduling 对一些节点打标签，专门运行 Spark streaming。<span style="line-height: 1.6;">总体上说，spark streaming 在 <span style="line-height: 25.6px;">YARN</span> 上运行比较稳定。<span style="line-height: 25.6px;">YARN</span> 对 CPU 有隔离，使用的 cgroups。 如果是 OOM 挂掉，可能程序存在内存泄露，不知道你们用的什么版本，建议使用 jprofile 定位一下内存效率之处。</span></p><p><br  /></p><p><strong><span style="line-height: 23.2727px;"><span style="line-height: 23.2727px;"><span style="line-height: 1.6;">6、</span></span></span>能否简单对比下 Storm 和 Spark 的优劣？如何技术选型？</strong></p><p>Storm 是实时流式数据处理，面向行处理，单条延时比较低。Spark 是近实时流式处理，面向 vp 处理，吞吐量比较高。如果应用对实时性要求比较高建议试用 Storm, 否则大家可以考虑利用 Spark 的丰富的数据操作能力。</p><p><br  /></p><p style="white-space: normal; line-height: 23.2727px;"><em style="color: rgb(136, 136, 136); font-size: 18px; white-space: pre-wrap; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="font-size: 14px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;">本文策划邓启明，编辑王杰，审校 Tim Yang，转载请注明来自高可用架构 「ArchNotes」微信公众号及以下二维码。</span></em></p><p style="white-space: normal; line-height: 23.2727px;"><em style="color: rgb(136, 136, 136); font-size: 18px; white-space: pre-wrap; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="font-size: 14px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><br  /></span></em></p><p style="white-space: normal; line-height: 23.2727px;"><em style="color: rgb(136, 136, 136); font-size: 18px; white-space: pre-wrap; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="font-size: 14px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><img data-s="300,640" data-type="png" data-src="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapOOyiaZ31Jb4E8VC4Z6l7dnJaHD9AUG2slPfC2v0sT0LP5fbFa5icRbAk1Tiamt2d7bXuMqIjyqhbBCdg/0?wx_fmt=png" data-ratio="0.5467625899280576" data-w=""  /><br  /></span></em></p><p style="line-height: 23.2727px; white-space: normal;"><em style="color: rgb(136, 136, 136); font-size: 18px; white-space: pre-wrap; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><span style="font-size: 14px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;"><br  /></span></em></p><p><br  /></p>
                    </div>
                    <script type="text/javascript">
                        var first_sceen__time = (+new Date());

                        if ("" == 1 && document.getElementById('js_content'))
                            document.getElementById('js_content').addEventListener("selectstart",function(e){ e.preventDefault(); });

                                        (function(){
                            if (navigator.userAgent.indexOf("WindowsWechat") != -1){
                                var link = document.createElement('link');
                                var head = document.getElementsByTagName('head')[0];
                                link.rel = 'stylesheet';
                                link.type = 'text/css';
                                link.href = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_winwx2a9cd9.css";
                                head.appendChild(link);
                            }
                        })();
                    </script>
                    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_combo2a7a3f.css">
                    
                    
                                        <a class="original_tool_area" id="copyright_info" href="javascript:void(0);">
                        <p class="tips_global">内容转载自公众号</p>
                        <div class="flex_cell original_cell">
                            <div class="flex_cell_hd">
                                <span class="radius_avatar">
                                                                        <img class="avatar" src="http://wx.qlogo.cn/mmhead/Q3auHgzwzM4DkCqSIEoCCu1zKRml7uqGvKdYV2Z2KHyFjuydwib6dNA/0" alt="高可用架构">
                                                                    </span>
                            </div>
                            <div class="flex_cell_bd flex_cell_primary">
                                高可用架构                            </div>
                            <div class="flex_cell_ft icon_access">了解更多</div>
                        </div>
                    </a>                  
                                        
                                        
                                        <div class="rich_media_tool" id="js_toobar3">
                                                                    <div id="js_read_area3" class="media_tool_meta tips_global meta_primary" style="display:none;">阅读 <span id="readNum3"></span></div>

                        <span style="display:none;" class="media_tool_meta meta_primary tips_global meta_praise" id="like3">
                            <i class="icon_praise_gray"></i><span class="praise_num" id="likeNum3"></span>
                        </span>

                        <a id="js_report_article3" style="display:none;" class="media_tool_meta tips_global meta_extra" href="javascript:void(0);">举报</a>

                    </div>
                </div>

                <div class="rich_media_area_extra">

                    
                                        <div class="mpda_bottom_container" id="js_bottom_ad_area">
                        
                    </div>
                                        
                    <div id="js_iframetest" style="display:none;"></div>

                    
                                        <div class="rich_media_extra" id="js_cmt_area" style="display:none">

                        <div class="discuss_container" id="js_cmt_main" style="display:none">
                            <div class="rich_tips with_line title_tips discuss_title_line">
                                <span class="tips">精选留言</span>
                            </div>
                            <p class="tips_global tc title_bottom_tips" id="js_cmt_nofans1" style="display:none;">关注该公众号可参与留言</p>
                            <p class="discuss_icon_tips title_bottom_tips tr" id="js_cmt_addbtn1" style="display:none">
                                
                                                                <a href="#comment">写留言<img class="icon_edit" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/icon_edit25ded2.png" alt=""></a>
                                                            </p>
                            <ul class="discuss_list" id="js_cmt_list"></ul>
                        </div>


                        <div class="tips_global rich_split_tips tc" id="js_cmt_nofans2" style="display:none;">
                            关注该公众号可参与留言
                        </div>

                        <p class="discuss_icon_tips rich_split_tips tr" id="js_cmt_addbtn2" style="display:none">
                            
                                                        <a href="#comment">写留言<img class="icon_edit" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/icon_edit25ded2.png" alt=""></a>
                                                    </p>

                        <p class="rich_split_tips tc tips_global" id="js_cmt_tips" style="display:none;"></p>


                        <div class="rich_tips tips_global loading_tips" id="js_cmt_loading">
                            <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/icon_loading_white2805ea.gif" class="rich_icon icon_loading_white" alt="">
                            <span class="tips">加载中</span>
                        </div>

                        <div class="rich_tips with_line tips_global" id="js_cmt_statement" style="display:none">
                            <span class="tips">以上留言由公众号筛选后显示</span>
                        </div>

                        <p class="rich_split_tips tc" id="js_cmt_qa" style="display:none;">
                            <a href="http://kf.qq.com/touch/sappfaq/150211YfyMVj150313qmMbyi.html?scene_id=kf264">
                                了解留言功能详情
                            </a>
                        </p>

                    </div>
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


        
        <script>window.moon_map = {"appmsg/emotion/caret.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/caret278965.js","appmsg/emotion/map.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/map278965.js","appmsg/emotion/textarea.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/textarea27cdc5.js","appmsg/emotion/nav.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/nav278965.js","appmsg/emotion/common.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/common278965.js","appmsg/emotion/slide.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/slide2a9cd9.js","biz_wap/jsapi/cardticket.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/cardticket275627.js","pages/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/report2a26bd.js","pages/music_player.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/music_player298e98.js","pages/loadscript.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/loadscript292ed8.js","appmsg/emotion/dom.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/dom278965.js","appmsg/emotion/emotion.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/emotion2a9cd9.js","biz_wap/utils/hashrouter.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/hashrouter2805ea.js","appmsg/cmt_tpl.html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cmt_tpl.html2a2c13.js","a/gotoappdetail.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/gotoappdetail2a2c13.js","a/ios.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/ios275627.js","a/android.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/android275627.js","a/profile.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/profile29b1f8.js","a/card.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/card29b1f8.js","biz_wap/utils/position.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/position29b1f8.js","appmsg/a_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a_report282222.js","biz_common/utils/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/report275627.js","biz_common/utils/huatuo.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/huatuo293afc.js","biz_common/utils/cookie.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/cookie275627.js","pages/voice_component.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/voice_component2a74ac.js","new_video/ctl.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/ctl292ed8.js","biz_common/utils/monitor.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/monitor2a30ee.js","biz_common/utils/spin.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/spin275627.js","biz_wap/jsapi/pay.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/pay275627.js","appmsg/reward_entry.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/reward_entry2aeba4.js","appmsg/comment.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/comment2a9cd9.js","appmsg/like.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/like2a74ac.js","appmsg/a.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a2a6faf.js","pages/version4video.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/version4video2a6afa.js","biz_wap/utils/storage.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/storage2a74ac.js","biz_common/tmpl.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/tmpl275627.js","appmsg/img_copyright_tpl.html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/img_copyright_tpl.html2a2c13.js","appmsg/a_tpl.html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a_tpl.html2a4dd8.js","biz_common/ui/imgonepx.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/ui/imgonepx275627.js","biz_common/dom/attr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/attr275627.js","biz_wap/utils/ajax.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax297cdb.js","biz_common/utils/string/html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/string/html29f4e9.js","appmsg/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report2a30ee.js","biz_common/dom/class.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/class275627.js","appmsg/report_and_source.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report_and_source29f4e9.js","appmsg/page_pos.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/page_pos2ac32d.js","appmsg/cdn_speed_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_speed_report275627.js","appmsg/voice.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/voice2ab8bd.js","appmsg/qqmusic.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/qqmusic2ab8bd.js","appmsg/iframe.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/iframe2ae6ea.js","appmsg/review_image.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/review_image2a5394.js","appmsg/outer_link.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/outer_link275627.js","biz_wap/jsapi/core.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/core275627.js","biz_common/dom/event.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/event275627.js","appmsg/copyright_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/copyright_report2a2c13.js","appmsg/cache.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cache2a74ac.js","appmsg/pay_for_reading.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/pay_for_reading28f721.js","appmsg/async.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/async2ae6ea.js","biz_wap/ui/lazyload_img.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/ui/lazyload_img2a96fd.js","biz_common/log/jserr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/log/jserr2805ea.js","appmsg/share.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/share2a42af.js","biz_wap/utils/mmversion.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/mmversion275627.js","appmsg/cdn_img_lib.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_img_lib275627.js","biz_common/utils/url/parse.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/url/parse275627.js","biz_wap/utils/device.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/device27f46f.js","biz_wap/jsapi/a8key.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/a8key2a30ee.js","appmsg/index.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/index2a9baf.js"};window.moon_crossorigin = true;</script><script type="text/javascript" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/moon2aba63.js" crossorigin></script>
    <script id="voice_tpl" type="text/html">        
        <span id="voice_main_<#=voiceid#>_<#=posIndex#>" class="db audio_area <#if(!musicSupport){#> unsupport<#}#>">
            <span class="tc tips_global unsupport_tips" <#if(show_not_support!==true){#>style="display:none;"<#}#>>
            当前浏览器不支持播放音乐或语音，请在微信或其他浏览器中播放            </span>
            <span class="audio_wrp db">
                <span id="voice_play_<#=voiceid#>_<#=posIndex#>" class="audio_play_area">
                    <i class="icon_audio_default"></i>
                    <i class="icon_audio_playing"></i>
                    <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/audio/icon_audio_unread26f1f1.png" alt="" class="pic_audio_default">
                </span>
                <span class="audio_length tips_global"><#=duration_str#></span>
                <span class="db audio_info_area">
                    <strong class="db audio_title"><#=title#></strong>
                    <span class="audio_source tips_global"><#if(window.nickname){#>来自<#=window.nickname#><#}#></span>
                </span>
                <span id="voice_progress_<#=voiceid#>_<#=posIndex#>" class="progress_bar" style="width:0px;"></span>
            </span>
        </span>
    </script>

    <script id="qqmusic_tpl" type="text/html">        
        <span id="qqmusic_main_<#=comment_id#>_<#=posIndex#>" class="db qqmusic_area <#if(!musicSupport){#> unsupport<#}#>">
            <span class="tc tips_global unsupport_tips" <#if(show_not_support!==true){#>style="display:none;"<#}#>>
            当前浏览器不支持播放音乐或语音，请在微信或其他浏览器中播放            </span>
            <span class="db qqmusic_wrp">
                <span class="db qqmusic_bd">
                    <span id="qqmusic_play_<#=musicid#>_<#=posIndex#>" class="play_area">
                        <i class="icon_qqmusic_switch"></i>
                        <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/qqmusic/icon_qqmusic_default.2x26f1f1.png" alt="" class="pic_qqmusic_default">
                        <img src="<#=music_img#>" data-autourl="<#=audiourl#>" data-musicid="<#=musicid#>" class="qqmusic_thumb" alt="">
                    </span>
                                        <a id="qqmusic_home_<#=musicid#>_<#=posIndex#>" href="javascript:void(0);" class="access_area">
                        <span class="qqmusic_songname"><#=music_name#></span>
                        <span class="qqmusic_singername"><#=singer#></span>
                        <span class="qqmusic_source"><img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/qqmusic/icon_qqmusic_source263724.png" alt=""></span>
                    </a>
                </span>
            </span>       
        </span>
    </script>
  <script type="text/javascript">
      var not_in_mm_css = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/not_in_mm2a7a3f.css";
      var windowwx_css = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_winwx2a9cd9.css";
      var tid = "";
      var aid = "";
      var clientversion = "0";
      var appuin = "MjM5NzAyNTE0Ng==";

      var source = "0";
      var scene = 75;
      
      var itemidx = "";

      var _copyright_stat = "2";
      var _ori_article_type = "";

      var nickname = "hadoop123";
      var appmsg_type = "9";
      var ct = "1452149913";
      var user_name = "gh_06e89600b70c";
      var user_name_new = "";
      var fakeid   = "";
      var version   = "";
      var is_limit_user   = "0";
      var msg_title = "【年度案例】大数据盘点之Spark篇";
      var msg_desc = "Hulu网谭政分享Spark最新功能、架构调整、实践以及踩过的那些坑、未来的发展趋势。";
      var msg_cdn_url = "http://mmbiz.qpic.cn/mmbiz/zX4KydZIKdAMe97lQqAtdiaK0MhCicf2zXiaTRLBKsExa7d4SflnfL0mN95K44ZMqyK0cDJ2QwFicOam8xHPgQrIrg/0?wx_fmt=jpeg";
      var msg_link = "http://mp.weixin.qq.com/s?__biz=MjM5NzAyNTE0Ng==&amp;mid=401593336&amp;idx=1&amp;sn=5f5daa70f8652d9d5543a497b8cc1707#rd";
      var user_uin = "0"*1;
      var msg_source_url = '';
      var img_format = 'jpeg';
      var srcid = '';
      var networkType;
      var appmsgid = '' || '401593336';
      var comment_id = "3505815946" * 1;
      var comment_enabled = "" * 1;
      var is_need_reward = "0" * 1;
      var is_https_res = ("" * 1) && (location.protocol == "https:");

      var devicetype = "";
      var source_username = "gh_ef1c37a72e61";  
      var profile_ext_signature = "e9976f1b5a46db37b47e12143d347986" || "";
      var reprint_ticket = "bRkPACP%2Ffi7f46v00nS0owTQOvjmlK4KCoJEOTSQ1GaJcR%2FK8OPEmQ9liuZrhoUj";
      var source_mid = "403255855";
      var source_idx = "1";

      var show_comment = "";
      var __appmsgCgiData = {
            can_use_page : "0"*1,
            is_wxg_stuff_uin : "0"*1,
            card_pos : "0",
            copyright_stat : "2",
            source_biz : "3000551159",
            hd_head_img : "http://wx.qlogo.cn/mmhead/Q3auHgzwzM4V3uJBaGmSbJnhia8qbkMYcqefhCURHdhohylEfJOODicA/0"||(window.location.protocol+"//"+window.location.host + "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/pic/appmsg/pic_rumor_link.2x264e76.jpg")
      };
      var _empty_v = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/pic/pages/voice/empty26f1f1.mp3";

      var copyright_stat = "2" * 1;

      var pay_fee = "" * 1;
      var pay_timestamp = "";
      var need_pay = "" * 1;

      var need_report_cost = "0" * 1;
      
            window.wxtoken = "";
          if(!!window.__initErrorReport){
        window.__initErrorReport(84,{
            biz : biz || "",
            mid : mid || "",
            idx : idx || ""
        });
    }
  </script>

  <script type="text/javascript">
      seajs.use('appmsg/index.js');
  </script>


    </body>
</html>

 
