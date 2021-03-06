package com.crawler;

import java.util.List;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import cn.wanghaomiao.xpath.model.JXDocument;

@Crawler(name = "basic")
public class Basic extends BaseSeimiCrawler{

	public void start(Response response) {
		// TODO Auto-generated method stub
		JXDocument doc = response.document();
		try {
            List<Object> urls = doc.sel("//a[@class='titlelnk']/@href");
            logger.info("{}", urls.size());
            for (Object s:urls){
                push(new Request(s.toString(),"getTitle"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public String[] startUrls() {
		// TODO Auto-generated method stub
		return new String[]{"http://www.runoob.com/"};
	}

	public void getTitle(Response response){
		JXDocument doc = response.document();
        try {
            logger.info("url:{} {}", response.getUrl(), doc.sel("//h1[@class='postTitle']/a/text()|//a[@id='cb_post_title_url']/text()"));
            //do something
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
