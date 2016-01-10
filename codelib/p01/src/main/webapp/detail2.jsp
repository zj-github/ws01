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
  <title>${art.title }</title> 
  <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve2a7a3f.css"> 
  <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_combo2a7a3f.css"> 

<link rel="stylesheet" type="text/css" href="http://www.oschina.net/js/syntax-highlighter-2.1.382/styles/shThemeDefault.css?t=1451964199000">
 </head> 
 <body id="activity-detail" class="zh_CN mm_appmsg" ontouchstart=""> 
  
  <div id="js_article" class="rich_media"> 
 
   <div class="rich_media_inner"> 
    <div id="page-content"> 
     <div id="img-content" class="rich_media_area_primary"> 
      <h2 class="rich_media_title" id="activity-name">${art.h2 } </h2> 

<!-- content start -->
	  <%-- <jsp:include page="inc01.jsp"></jsp:include> --%>
	<!--content end-->
<div class="Body" style="position:relative;">
								                    <div id="translate_46306" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;" rowspan="2"><div class="TextContent"><p>大家都知道 Redis 是单线程的。真正的内行会告诉你，实际上 Redis 并不是完全单线程，因为在执行磁盘上的特定慢操作时会有多线程。目前为止多线程操作绝大部分集中在 I/O 上以至于在不同线程执行异步任务的小型库被称为 bio.c: 也就是 Background I/O。<br><br>然而前阵子我提交了一个问题，在问题里我承诺提供一个很多人（包括我自己）都想要的功能，叫做“免费懒加载”。原始的问题在这</p>
<p><a href="https://github.com/antirez/redis/issues/1748" rel="nofollow">https://github.com/antirez/redis/issues/1748</a><br><br>问题的根本在于，Redis 的 DEL 操作通常是阻塞的。因此如果你发送 Redis “DEL mykey” 命令，碰巧你的 key 有 5000万个对象，那么服务器将会阻塞几秒钟，在此期间服务器不会处理其他请求。历史上这被当做 Redis 设计的副作用而被接受，但是在特定的用例下这是一个局限。DEL 不是唯一的阻塞式命令，却是特殊的一个命令，因为我们认为：Redis 非常快，只要你用复杂度为 O(1) 和 O(log_N) 的命令。你可以自由使用 O(N) 的命令，但是要知道这不是我们优化的用例，你需要做好延迟的准备。<br><br>这听起来很合理，但是同时即便用快速操作创建的对象也需要被删除。在这种情况下，Redis 会阻塞。</p></div></td>
        
    </tr>
        <tr>
        <td class="translater" valign="bottom">
                        <a id="btn_show_other_46306" class="showOthers" href="javascript:show_other(46306,46327);">其它翻译版本(1)</a>
        </td>
    </tr>
    </tbody></table>
<div id="other_translate_46306" style="display:none;">
	<div style="text-align:center;margin:10px 0;"><img src="/img/loading.gif?t=1451964198000" alt="loading..."><strong>正在加载...</strong></div>
</div>
</div>
        		                    <div id="translate_46307" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>第一次尝试<br>—</p>
<p>对于单线程服务器，为了让操作不阻塞，最简单的方式就是用增量的方式一点点来，而不是一下子把整个世界都搞定。例如，如果要释放一个百万级的对象，可以每一个毫秒释放1000个元素，而不是在一个 for() 循环里一次性全做完。CPU 的耗时是差不多的，也许会稍微多一些，因为逻辑更多一些，但是从用户来看延时更少一些。当然也许实际上并没有每毫秒删除1000个元素，这只是个例子。重点是如何避免秒级的阻塞。在 Redis 内部做了很多事情：最显然易见的是 LRU 淘汰机制和 key 的过期，还有其他方面的，例如增量式的对 hash 表进行重排。</p>
<p>刚开始我们是这样尝试的：创建一个新的定时器函数，在里面实现淘汰机制。对象只是被添加到一个链表里，每次定时器调用的时候，会逐步的、增量式的去释放。这需要一些小技巧，例如，那些用哈希表实现的对象，会使用 Redis 的 SCAN 命令里相同的机制去增量式的释放：在字典里设置一个游标来遍历和释放元素。通过这种方式，在每次定时器调用的时候我们不需要释放整个哈希表。在重新进入定时器函数时，游标可以告诉我们上次释放到哪里了。</p>
<p><br></p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46331">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46331);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46308" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p> 适配是困难的<br> — </p> 
<p> 你知道这里最困难的部分是哪里吗？这次我们是在增量式的做一件很特别的事情：释放内存。如果内存的释放是增量式的，服务器的内容增长将会非常快，最后为了得到更少的延时，会消耗调无限的内存。这很糟，想象一下，有下面的操作：&nbsp; </p> 
<p> &nbsp; &nbsp; WHILE 1<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SADD myset element1 element2 … many many many elements<br> &nbsp; &nbsp; &nbsp; &nbsp; DEL myset<br> &nbsp;&nbsp;&nbsp; END </p> 
<p> 如果慢慢的在后台去删除myset，同时SADD调用又在不断的添加大量的元素，内存使用量将会一直增长。 </p> 
<p> 好在经过一段尝试之后，我找到一种可以工作的很好的方式。定时器函数里使用了两个想法来适应内存的压力： </p> 
<p> &nbsp; &nbsp; 1.检测内存趋势：增加还是减少？以决定释放的力度。 </p> 
<p> &nbsp; &nbsp; 2.同时适配定时器的频率，避免在只有很少需要释放的时候去浪费CPU，不用频繁的去中断事件循环。当确实需要的时候，定时器也可以达到大约300HZ的频率。 </p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46332">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46332);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46309" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>这里有一小段代码，不过这个想法现在已经不再实现了：</p>
<div><div id="highlighter_879563" class="syntaxhighlighter  java"><div class="toolbar"><span><a href="#" class="toolbar_item command_help help">?</a></span></div><table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td class="gutter"><div class="line number1 index0 alt2">1</div><div class="line number2 index1 alt1">2</div><div class="line number3 index2 alt2">3</div><div class="line number4 index3 alt1">4</div><div class="line number5 index4 alt2">5</div><div class="line number6 index5 alt1">6</div><div class="line number7 index6 alt2">7</div><div class="line number8 index7 alt1">8</div><div class="line number9 index8 alt2">9</div><div class="line number10 index9 alt1">10</div><div class="line number11 index10 alt2">11</div><div class="line number12 index11 alt1">12</div><div class="line number13 index12 alt2">13</div><div class="line number14 index13 alt1">14</div><div class="line number15 index14 alt2">15</div><div class="line number16 index15 alt1">16</div><div class="line number17 index16 alt2">17</div></td><td class="code"><div class="container"><div class="line number1 index0 alt2"><code class="java comments">/*计算内存趋势，只要是上次和这次内存都在增加，就倾向于认为内存趋势 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;是增加的&nbsp;*/</code></div><div class="line number2 index1 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;</code>&nbsp;</div><div class="line number3 index2 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">if</code>&nbsp;<code class="java plain">(prev_mem&nbsp;&lt;&nbsp;mem)&nbsp;mem_trend&nbsp;=&nbsp;</code><code class="java value">1</code><code class="java plain">; &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number4 index3 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">mem_trend&nbsp;*=&nbsp;</code><code class="java value">0.9</code><code class="java plain">;&nbsp;</code><code class="java comments">/*&nbsp;逐渐衰减&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number5 index4 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">int</code>&nbsp;<code class="java plain">mem_is_raising&nbsp;=&nbsp;mem_trend&nbsp;&gt;&nbsp;.</code><code class="java value">1</code><code class="java plain">;  &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number6 index5 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java comments">/*&nbsp;释放一些元素&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number7 index6 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">size_t&nbsp;workdone&nbsp;=&nbsp;lazyfreeStep(LAZYFREE_STEP_SLOW);  &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number8 index7 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java comments">/*&nbsp;根据现有状态调整定时器频率&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number9 index8 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">if</code>&nbsp;<code class="java plain">(workdone)&nbsp;{ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number10 index9 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">if</code>&nbsp;<code class="java plain">(timer_period&nbsp;==&nbsp;</code><code class="java value">1000</code><code class="java plain">)&nbsp;timer_period&nbsp;=&nbsp;</code><code class="java value">20</code><code class="java plain">; </code></div><div class="line number11 index10 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">if</code>&nbsp;<code class="java plain">(mem_is_raising&nbsp;&amp;&amp;&nbsp;timer_period&nbsp;&gt;&nbsp;</code><code class="java value">3</code><code class="java plain">) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number12 index11 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">timer_period--;&nbsp;</code><code class="java comments">/*&nbsp;Raise&nbsp;call&nbsp;frequency.&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number13 index12 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java keyword">else</code>&nbsp;<code class="java keyword">if</code>&nbsp;<code class="java plain">(!mem_is_raising&nbsp;&amp;&amp;&nbsp;timer_period&nbsp;&lt;&nbsp;</code><code class="java value">20</code><code class="java plain">) </code></div><div class="line number14 index13 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">timer_period++;&nbsp;</code><code class="java comments">/*&nbsp;Lower&nbsp;call&nbsp;frequency.&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number15 index14 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">}&nbsp;</code><code class="java keyword">else</code>&nbsp;<code class="java plain">{ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number16 index15 alt1"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">timer_period&nbsp;=&nbsp;</code><code class="java value">1000</code><code class="java plain">;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java comments">/*&nbsp;1&nbsp;HZ&nbsp;*/</code><code class="java plain"> &nbsp;&nbsp;&nbsp;&nbsp;</code></div><div class="line number17 index16 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">}  </code></div></div></td></tr></tbody></table></div></div>
<p>这是一个小技巧，工作的也很好。不过郁闷的是我们还是不得不在单线程里执行。要做好需要有很多的逻辑，而且当延迟释放（lazy free）周期很繁忙的时候，每秒能完成的操作会降到平时的65%左右。<br>如果是在另一个线程去释放对象，那就简单多了：如果有一个线程只做释放操作的话，释放总是要比在数据集里添加数据来的要快。</p>
<p>当然，主线程和延迟释放线程直接对内存分配器的使用肯定会有竞争，不过 Redis 在内存分配上只用到一小部分时间，更多的时间用在I/O、命令分发、缓存失败等等。<br><br></p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46334">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46334);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46310" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>不过，要实现线程化的延迟释放有一个大问题，那就是 Redis 自身。内部实现完全是追求对象的共享，最终都是些引用计数。干嘛不尽可能的共享呢？这样可以节省内存和时间。例如：SUNIONSTORE 命令最后得到的是目标集合的共享对象。类似的，客户端的输出缓存包含了作为返回结果发送给socket的对象的列表，于是在类似 SMEMBERS 这样的命令调用之后，集合的所有成员都有可能最终在输出缓存里被共享。看上去对象共享是那么有效、漂亮、精彩，还特别酷。</p>
<p>但是，嘿，还需要再多说一句的是，如果在 SUNIONSTORE 命令之后重新加载了数据库，对象都取消了共享，内存也会突然回复到最初的状态。这可不太妙。接下来我们发送应答请求给客户端，会怎么样？当对象比较小时，我们实际上是把它们拼接成线性的缓存，要不然进行多次 write() 调用效率是不高的！（友情提示，writev() 并没有帮助）。于是我们大部分情况下是已经复制了数据。对于编程来说，没有用的东西却存在，通常意味着是有问题的。</p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46348">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46348);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46311" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent">事实上，访问一个包含聚合类型数据的key，需要经过下面这些遍历过程：
<div><div id="highlighter_637260" class="syntaxhighlighter  java"><div class="toolbar"><span><a href="#" class="toolbar_item command_help help">?</a></span></div><table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td class="gutter"><div class="line number1 index0 alt2">1</div></td><td class="code"><div class="container"><div class="line number1 index0 alt2"><code class="java spaces">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class="java plain">key&nbsp;-&gt;&nbsp;value_obj&nbsp;-&gt;&nbsp;hash&nbsp;table&nbsp;-&gt;&nbsp;robj&nbsp;-&gt;&nbsp;sds_string</code></div></div></td></tr></tbody></table></div></div>如果去掉整个 tobj 结构体，把聚合类型转换成 SDS 字符串类型的哈希表（或者跳表）会怎么样？（SDS是Redis内部使用的字符串类型）。
<br>这样做有个问题，假设有个命令：SADD myset myvalue，举个例子来说，我们做不到通过client-&gt;argv[2] 来引用用来实现集合的哈希表的某个元素。我们不得不很多次的把值复制出来，即使数据已经在客户端命令解析后创建的参数 vector 里，也没办法去复用。Redis的性能受控于缓存失效，我们也许可以用稍微间接一些的办法来弥补一下。
<br>于是我在这个 lazyfree 的分支上开始了一项工作，并且在 Twitter 上聊了一下，但是没有公布上下文的细节，结果所有的人都觉得我像是绝望或者疯狂了（甚至有人喊道 lazyfree 到底是什么玩意）。那么，我到底做了什么呢？
<br>
<br>
<br></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46368">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46368);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46312" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>1. 把客户端的输出缓存由 robj 结构体改成动态字符串。在创建 reply 的时候总是复制值的内容。<br>2. 把所有的 Redis 数据类型转换成 SDS 字符串，而不是使用共享对象结构。听上去很简单？实际上这花费了数周的时间，涉及到大约800行高风险的代码修改。不过现在全都测试通过了。<br>3. 把 lazyfree 重写成线程化的。</p>
<p> 结果是 Redis 现在在内存使用上更加高效，因为在数据结构的实现上不再使用 robj 结构体（不过由于某些代码还涉及到大量的共享，所以 robj 依然存在，例如在命令分发和复制部分）。线程化的延迟释放工作的很好，比增量的方式更能减少内存的使用，虽然增量方式在实现上与线程化的方式相似，并且也没那么糟糕。现在，你可以删除一个巨大的 key，性能损失可以忽略不计，这非常有用。不过，最有趣的事情是，在我测过的一些操作上，Redis 现在都要更快一些。消除间接引用（Less indirection）最后胜出，即使在不相关的一些测试上也更快一些，还是因为客户端的输出缓存现在更加简单和高效。</p>
<p> 最后，我把增量式的延迟释放实现从分支里删除，只保留了线程化的实现。</p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46377">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46377);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46313" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>关于 API 的一点备注<br></p>
<p>不过 API 又怎么样了呢？DEL 命令仍然是阻塞的，默认还跟以前一样，因为在 Redis 中 DEL 命令就意味着释放内存，我并不打算改变这一点。所以现在你可以用新的命令 UNLINK，这个命令更清晰的表明了数据的状态。</p>
<p>UNLINK 是一个聪明的命令：它会计算释放对象的开销，如果开销很小，就会直接按 DEL 做的那样立即释放对象，否则对象会被放到后台队列里进行处理。除此之外，这两个命令在语义上是相同的。</p>
<p>我们也实现了 FLUSHALL/FLUSHDB 的非阻塞版本，不过没有新增的 API，而是增加了一个 LAZY 选项，说明是否更改命令的行为。</p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46378">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46378);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46314" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>不只是延迟释放<br></p>
<p>—</p>
<p>现在聚合数据类型的值都不再共享了，客户端的输出缓存也不再包含共享对象了，这一点有很多文章可做。例如，现在终于可以在 Redis 里实现线程化的 I/O，从而不同的客户端可以由不同的线程去服务。也就是说，只有访问数据库才需要全局的锁，客户端的读写系统调用，甚至是客户端发送的命令的解析，都可以在线程中去处理。这跟 memcached 的设计理念类似，我比较期待能够被实现和测试。</p>
<p>还有，现在也可以在其他线程实现针对聚合数据类型的特定的慢操作，可以让某些 key 被“阻塞”，但是所有其他的客户端不会被阻塞。这个可以用很类似现在的阻塞操作的方式去完成（参考blocking.c），只是增加一个哈希表保存那些正在处理的 key 和对应的客户端。于是一个客户端请求类似 SMEMBERS 这样的命令，可能只是仅仅阻塞住这一个 key，然后会创建输出缓存处理数据，之后在释放这个 key。只有那些尝试访问相同的 key 的客户端，才会在这个 key 被阻塞的时候被阻塞住。</p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46419">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46419);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46315" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p>所有这些需求起了更激烈的内部变化，但这里的底线我们已很少顾忌。我们可以补偿对象复制时间来减少高速缓存的缺失，以更小的内存占用聚合数据类型，所以我们现在可依照线程化的 Redis 来进行无共享化设计，这一设计，可以很容易超越我们的单线程。在过去，一个线程化的 Redis 看起来总像是一个坏主意，因为为了实现并发访问数据结构和对象其必定是一组互斥锁，但幸运的是还有别的选择获得这两个环境的优势。如果我们想要，我们依然可以选择快速操作服务，就像我们过去在主线程所做的那样。这包含在复杂的代价之上，获取执行智能（performance-wise）。</p>
<p><br></p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/crooner" title="无若" target="_blank"><img src="http://static.oschina.net/uploads/user/276/553781_50.jpg?t=1374799191000" align="absmiddle" alt="无若" title="无若" class="SmallPortrait" user="553781"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/crooner" target="_blank">无若</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46374">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46374);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        		                    <div id="translate_46316" class="translate_chs">
<table class="paragraph_chs">
    <tbody><tr>
        <td style="border-right:1px solid #E3E3E3;"><div class="TextContent"><p> 计划表<br><span style="font-family:Verdana, sans-serif, 宋体;font-size:13.3333px;line-height:21.3333px;background-color:#F6F6F6;">—</span><span style="line-height:1.5;font-size:10pt;"></span></p>
<p> 我在内部增加了很多东西，明天就上线看上去是不现实的。我的计划是先让3.2版（已经是unstable状态）成为候选版本（RC）状态，然后把我们的分支合并到进入unstable的3.4版本。</p>
<p> 不过在合并之前，需要对速度做细致的回归测试，这有不少工作要做。</p>
<p> 如果你现在就想尝试的话，可以从Github上下载lazyfree分支。不过要注意的是，当前我并不是很频繁的更新这个分支，所以有些地方可能会不能工作。</p></div></td>
        <td class="translater" valign="top">
                        <a href="http://my.oschina.net/linuxqueen" title="zicode" target="_blank"><img src="http://static.oschina.net/uploads/user/458/916494_50.jpg?t=1374809710000" align="absmiddle" alt="zicode" title="zicode" class="SmallPortrait" user="916494"></a>
            <div class="info">
                <h6><a href="http://my.oschina.net/linuxqueen" target="_blank">zicode</a><br>翻译于 3个月前</h6>
                <p><em id="vote_count_46379">0</em>人顶</p>
            </div>
            <div class="clear"></div>
            <p class="vote">
            <a href="javascript:vote_block(46379);" class="rndbutton"><span>顶</span></a>&nbsp;翻译的不错哦!
            			            </p>
        </td>
    </tr>
    </tbody></table>
</div>
        				<div class="copyright">
			本文中的所有译文仅用于学习和交流目的，转载请务必注明文章译者、出处、和本文链接<br>
			我们的翻译工作遵照 <a href="http://zh.wikipedia.org/wiki/Wikipedia:CC" target="_blank">CC 协议</a>，如果我们的工作有侵犯到您的权益，请及时联系我们
		</div>
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
 
 </body>
</html>
