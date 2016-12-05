package com.crawler;

import cn.wanghaomiao.seimi.annotation.Queue;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.core.SeimiQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;


@Queue
public class MySelfRedisQueueImpl implements SeimiQueue {
    private static LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
    private Logger logger = LoggerFactory.getLogger(MySelfRedisQueueImpl.class);
    
    @Override
    public Request bPop(String crawlerName) {
        return queue.peek();
    }

    @Override
    public boolean push(Request req) {
        return queue.add(req);
    }

    @Override
    public long len(String crawlerName) {
        return queue.size();
    }

    @Override
    public boolean isProcessed(Request req) {
        return false;
    }

    @Override
    public void addProcessed(Request req) {
        logger.info("{}",req);
    }

    @Override
    public long totalCrawled(String crawlerName) {
        return -1;
    }

}
