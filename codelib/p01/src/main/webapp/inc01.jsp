<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <!--content start-->
      <div class="rich_media_content " id="js_content"> 
       <p>从0开始做垂直O2O个性化推荐</p>
       <p><br></p>
       <p>上次以58转转为例，介绍了如何<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=402978440&amp;idx=1&amp;sn=f0ec24d9f3c81fe49868d12a5128fcc9&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=402978440&amp;idx=1&amp;sn=f0ec24d9f3c81fe49868d12a5128fcc9&amp;scene=21#wechat_redirect"><strong>从0开始如何做互联网推荐产品</strong></a>（<span style="color: rgb(255, 41, 65);">回复“推荐”阅读</span>），58转转的宝贝为闲置物品，<strong>品类多种多样，要做统一的宝贝画像比较难</strong>，而分类别做宝贝画像成本又非常高，所以更多的是进行用户画像、分类预测推荐、协同过滤推荐等个性化推荐。</p>
       <p>有些同学反馈，他们的产品是垂直类的O2O产品，分类单一，<strong>可以简单的实现宝贝画像，这类垂直O2O产品怎么从零开始做个性化推荐呢？</strong>这是本文要讨论的问题</p>
       <p><br></p>
       <p><span style="font-size: 18px;"><strong>一、58到家美甲简介</strong></span></p>
       <p>58到家有三大自营业务“家政”“美甲”和“速运” ，美甲能够实现“足不出户，享品质服务，做美丽女人”，目前提供上门美甲、修复与卸甲、美睫、化妆等服务。</p>
       <p>http://bj.daojia.com/liren/</p>
       <p><br></p>
       <p><span style="font-size: 18px;"><strong>二、从0开始设计垂直O2O推荐框架</strong></span></p>
       <p>（1）<strong>列表页推荐</strong>：用户既然进入到了美甲，成交意愿是非常强烈的，首页的推荐至关重要</p>
       <p>（2）<strong>宝贝详情页推荐</strong>：买了还买，看了还看类的关联宝贝推荐</p>
       <p>（3）<strong>下单成功页推荐</strong>：既然下单了某个甲样，可能会喜欢相近的甲样哟</p>
       <p>（4）<strong>召回推荐</strong>：在用户退出系统后，通过RFM模型做优惠券推送或者消息推送做客户挽留与召回</p>
       <p><strong>RFM模型</strong>：根据用户最近一次<span style="color: rgb(255, 41, 65);">购买时间Recency</span>，最近一段时间的<span style="color: rgb(255, 41, 65);">购买频率Frequency</span>，最近一段时间的<span style="color: rgb(255, 41, 65);">购买金额Monetary</span>，加权得到的一个代表用户成交意愿的一个分值。</p>
       <p><br></p>
       <p><span style="font-size: 18px;"><strong>三、甲样列表页推荐详细流程</strong></span></p>
       <p>（1）用户点击进入甲样列表页</p>
       <p>（2）画像用户的消费能力</p>
       <p>（3）抽取购买、收藏、喜欢、浏览的历史数据</p>
       <p>（4）根据历史数据，对所有甲样进行打分，综合一些产品策略，推荐出首屏的4个甲样，例如：<span style="font-size: 16px; line-height: 1.6;"> </span><img data-s="300,640" data-type="jpeg" data-src="http://mmbiz.qpic.cn/mmbiz/YrezxckhYOzGeeBhsyKcRkz2j6tp0yyjNbbcDGAG3pYtJrYUCbWGR9OA06W7jRnibY6Jfzia0ib05Fe2praic1xLXQ/0?wx_fmt=jpeg" style="font-size: 16px; line-height: 1.6;" data-ratio="1.776978417266187" data-w=""></p>
       <p><span style="font-size: 16px; line-height: 1.6;">（5）如果用户下单，以被下单的相似甲样做推荐</span></p>
       <p>（6）如果用户跳出，可以根据信用评级、消费等级做优惠券召回推荐</p>
       <p><br></p>
       <p><span style="font-size: 18px;"><strong>四、与业务紧密结合的策略规则</strong></span></p>
       <p><span style="color: rgb(255, 41, 65);">推荐系统并不是一个单纯的算法问题，而是一个与产品、工程架构都相关的综合性问题</span>，不同的业务会有不同的产品策略，这些是在做推荐时需要考虑的，以美甲为例，需要考虑：</p>
       <p>（1）排序前2名要推荐<strong>最符合用户消费能力的甲样</strong>（例如“价格小于150”）</p>
       <p>（2）被推荐的4个甲样要<strong>覆盖尽可能多的消费区间</strong>（例如“两个甲样价格小于150，两个甲样价格大于150”）</p>
       <p>（3）被推荐的4个甲样要<strong>覆盖最火的产品、旧产品、新产品</strong>（例如“1个爆品，2个旧加油，1个新甲样”）</p>
       <p>（4）垂直相邻的甲样，颜色不同（为了视觉体验）</p>
       <p>（5）水平相邻的甲样，颜色不同（原因同上）</p>
       <p>（6）垂直相邻的甲样，款式不同（为了视觉体验，以及产品覆盖度、受众度）</p>
       <p>（7）水平相邻的甲样，款式不同（原因同上）</p>
       <p>（8）…</p>
       <p><br></p>
       <p><span style="font-size: 18px;"><strong>五、如何利用甲样画像与用户购买、收藏、喜欢、浏览的历史数据对所有甲样进行打分？</strong></span></p>
       <p><strong>【宝贝画像】</strong></p>
       <p>垂直O2O的相对比较容易做宝贝画像，宝贝品类比较单一（甲样），宝贝的品种也比较少（几千几万种甲样），熟悉业务的人可以对宝贝进行画像（不需要复杂的机器学习方法），以甲样为例，可以抽象出：</p>
       <p>款式</p>
       <p>颜色</p>
       <p>风格</p>
       <p>场景</p>
       <p>图案</p>
       <p>其他</p>
       <p>等多个核心属性</p>
       <p><br></p>
       <p><strong>【核心属性赋值，标签化】</strong></p>
       <p>宝贝画像完毕之后，对于每一个核心属性，可以进行赋值，实施标签化</p>
       <p><strong>款式</strong>：纯色，法式，渐变，彩绘，贴饰</p>
       <p><strong>颜色</strong>：红色，粉色，蓝色，白色</p>
       <p><strong>风格</strong>：简约，甜美，复古，可爱</p>
       <p><strong>场景</strong>：派对，旅行，约会，晚宴，夜店</p>
       <p><strong>图案</strong>：卡通，小碎花，动物，桃心，五角星</p>
       <p><br></p>
       <p><strong>【抽取用户历史行为】</strong></p>
       <p>抽取购买、收藏、喜欢、浏览的历史行为数据，得到一些甲样ID集合set&lt;bb-id&gt;</p>
       <p><br></p>
       <p><strong>【查询所有历史行为甲样ID的画像属性，对标签进行频率统计】</strong></p>
       <p>用户U历史行为某买了甲样1：bb-id1，收藏了甲样2：bb-id2</p>
       <p>从库中查询出所有甲样的详细属性</p>
       <p>bb-id1：彩绘，红色，可爱，夜店，桃心</p>
       <p>bb-id2：彩绘，粉色，可爱，夜店，桃心</p>
       <p>对标签进行统计</p>
       <p>款式：{彩绘：2}</p>
       <p>颜色：{红色：1，粉色：1}</p>
       <p>风格：{可爱：2}</p>
       <p>场景：{夜店：2}</p>
       <p>图案：{桃心：2}</p>
       <p><br></p>
       <p><strong>【根据标签统计，量化对标签的喜爱程度】</strong></p>
       <p>例如，标签量化打分公式可以为：score=同类标签出现频率</p>
       <p>那么，对于“款式”这个属性，依据上述统计，各标签的打分是：</p>
       <p>纯色=0分，法式=0分，渐变=0分，彩绘=1分，晕染=0分，贴饰=0分（假设只有5种款式）</p>
       <p>同理，对于“颜色”这个属性，依据上述统计，各标签的打分是：</p>
       <p>红色=0.5分，粉色=0.5分，蓝色=0分，白色=0分（假设只有4种颜色）</p>
       <p>…</p>
       <p>这个打分是一个简单举例，实际上的打分公式会复杂很多（例如购买与收藏贡献的分值不一样）</p>
       <p><br></p>
       <p><strong>【根据上述量化标签，<strong style="white-space: normal;">量化</strong>用户对每个甲样的喜爱程度】</strong></p>
       <p>例如，对于一个甲样X{纯色，红色，简约，夜店，卡通}，可以计算出用户对它的喜爱分值为</p>
       <p>socre-X = 0(纯色) + 0.5(红色) + 0(简约) + 1(夜店) + 0(卡通) = 1.5分</p>
       <p>这个打分是一个简单举例，实际上打分公式会复杂很多（例如各个属性的权重是不一样的）</p>
       <p><br></p>
       <p><strong>【对所有甲样计算分值，排序】</strong></p>
       <p><br></p>
       <p><strong>【从高到底进行甲样推荐】</strong></p>
       <p>推荐的过程中注意，4款甲样<span style="color: rgb(255, 41, 65);">要符合第四个大步骤中提到的产品策略</span>（要覆盖各个价格范围，相邻颜色与样式不同等）</p>
       <p><br></p>
       <p><strong>【个性化推荐完成】</strong></p>
       <p><br></p>
       <p>好了，暂时先到这里，上面的思路绝对是能落地的，希望58到家美甲的推荐，对其他刚开始做垂直O2O互联网产品的同学有帮助。</p>
       <p><br></p>
       <p>注：本文是58到家推荐负责人@王洪权 做58到家美甲推荐技术交流时，@58沈剑 做的纪要，内容“略”有修改。</p>
       <p><span style="font-size: 12px;">==【完】==</span></p>
       <p><span style="font-size: 12px;">回【拍卖】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=201042653&amp;idx=1&amp;sn=2b2489baf140668c693033a1b9daaeb8&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=201042653&amp;idx=1&amp;sn=2b2489baf140668c693033a1b9daaeb8&amp;scene=21#wechat_redirect">互联网广告之拍卖理论</a></span></p>
       <p><span style="font-size: 12px;">回【广告】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=201272878&amp;idx=1&amp;sn=2b48fdffc59408493ad7f6d431611361&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=201272878&amp;idx=1&amp;sn=2b48fdffc59408493ad7f6d431611361&amp;scene=21#wechat_redirect">一分钟读懂互联网广告竞价策略</a></span></p>
       <p><span style="font-size: 12px;">回【kkkk】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202623552&amp;idx=1&amp;sn=cad4495ecc83da74fdc3d8054f78db75&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202623552&amp;idx=1&amp;sn=cad4495ecc83da74fdc3d8054f78db75&amp;scene=21#wechat_redirect">3分钟懂K-means聚类算法</a>（附源码）</span></p>
       <p><span style="font-size: 12px;">回【回归】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202722882&amp;idx=1&amp;sn=d5395c53d7453222fbd7e06d2e51bc9d&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202722882&amp;idx=1&amp;sn=d5395c53d7453222fbd7e06d2e51bc9d&amp;scene=21#wechat_redirect">3分钟懂线性回归预测算法</a>（附源码）</span></p>
       <p><span style="font-size: 12px;">回【宝马】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202849985&amp;idx=1&amp;sn=b921c34be65ebd9f5adfe178dd36ead7&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=202849985&amp;idx=1&amp;sn=b921c34be65ebd9f5adfe178dd36ead7&amp;scene=21#wechat_redirect">如何在微信刷出宝马广告</a></span></p>
       <p><span style="font-size: 12px;">回【红包】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=203616226&amp;idx=1&amp;sn=02e5e7a827ba867849db513a96446fa9&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=203616226&amp;idx=1&amp;sn=02e5e7a827ba867849db513a96446fa9&amp;scene=21#wechat_redirect">抢红包统计学</a>（技术贴，知道为啥自己越抢越穷了吧）</span></p>
       <p><span style="font-size: 12px;">回【推荐】<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=402978440&amp;idx=1&amp;sn=f0ec24d9f3c81fe49868d12a5128fcc9&amp;scene=21#wechat_redirect" target="_blank" data_ue_src="http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&amp;mid=402978440&amp;idx=1&amp;sn=f0ec24d9f3c81fe49868d12a5128fcc9&amp;scene=21#wechat_redirect">从0开始做互联网推荐</a></span></p>
       <p><br></p>
       <p><strong><span style="font-size: 12px;">回大于10的整数，返回随机好文（猜猜怎么实现的）</span></strong></p>
       <p><br></p>
       <p><span style="font-size: 12px;">每个字都是作者码的，帮忙<span style="font-size: 12px; color: rgb(255, 41, 65);">转发</span>一下嘛。</span></p> 
      </div> 