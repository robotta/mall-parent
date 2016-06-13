package com.malaysia.mongo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.List;

/**
 * mongo 操作类
 * 
 * @author zhaoyun
 * @create 2015年1月22日
 */
public class MongoManager {

	private static Logger logger = Logger.getLogger(MongoManager.class);
	private MongoTemplate mongoTemplate;

	/**
	 * 日志插入
	 * 
	 * @author zhaoyun
	 * @create 2015年1月23日
	 * @param logBean
	 *            存入log日志的信息
	 * @param collectionName
	 *            存储空间名称：一般指当前类名，可为空
	 * @return
	 */
	public boolean insert(MongoLogBean logBean, String collectionName) {
		try {
			mongoTemplate.insert(logBean, collectionName);
			return true;
		} catch (Exception e) {
			logger.error("插入日志失败",e);
		}
		return false;
	}

	/**
	 * 查询日志文件
	 * 
	 * @author zhaoyun
	 * @create 2015年1月23日
	 * @param map
	 * @param collectionName
	 * @return
	 */
	public List<MongoLogBean> findByOperator(HashMap<String, String> map,
			String collectionName) {
		Query query = new Query();
		Criteria criteria = Criteria.where("operator").is(map.get("operator"));
		query.addCriteria(criteria);
		List<MongoLogBean> mongoLogs = null;
		try {
			mongoLogs = mongoTemplate.find(query, MongoLogBean.class,
					collectionName);
		} catch (Exception e) {
			logger.error("查询日志失败",e);
		}
		return mongoLogs;
	}

	/**
	 * 分页查询日志文件
	 * 
	 * @author zhaoyun
	 * @create 2015年1月23日
	 * @param collectionName
	 * @return
	 */
	public Pagination findLogsLimit(int pageNo, int pageSize,
			String collectionName) {
		Pagination page = null;
		try {
			Query query = new Query();
			long totalCount = mongoTemplate.count(query, collectionName);
			page = new Pagination(pageNo, pageSize, totalCount);
			query.skip(page.getFirstResult());// skip相当于从那条记录开始
			query.limit(pageSize);// 从skip开始,取多少条记录
			List<MongoLogBean> datas = mongoTemplate.find(query,
					MongoLogBean.class, collectionName);
			page.setDatas(datas);
		} catch (Exception e) {
			logger.error("日志查询失败",e);
		}
		return page;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Autowired
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
