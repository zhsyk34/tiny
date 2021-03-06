package com.roy.tiny.base.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roy.tiny.base.dao.BaseDAO;
import com.roy.tiny.base.dao.DaoFactory;
import com.roy.tiny.base.dao.cond.Cond;
import com.roy.tiny.base.model.Model;
import com.roy.tiny.base.service.BaseService;
import com.roy.tiny.base.web.Pager;
import com.roy.tiny.base.web.Sorter;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class BaseServiceImpl<T extends Model> implements BaseService<T> {
	
	private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	private DaoFactory daoFactory;
	
	private BaseDAO<T> dao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected BaseDAO<T> getDao() {
		if(dao == null) {
			java.lang.reflect.Type type = this.getClass().getGenericSuperclass();
			ParameterizedType ptype = (ParameterizedType) type;
			Class entityClass = (Class<T>) ptype.getActualTypeArguments()[0];
			dao = daoFactory.getDao(entityClass);
		}
		return dao;
	}

	@Override
	public void save(T object) {
		getDao().save(object);
	}

	@Override
	public void delete(T object) {
		getDao().delete(object);
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Serializable id) {
		return getDao().get(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> query(Cond cond, Pager pager, Sorter sorter) {
		return getDao().query(cond, pager, sorter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> query(Cond cond, Sorter sorter) {
		return getDao().query(cond, sorter);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> query(Cond cond) {
		return getDao().query(cond);
	}
	
	@Override
	@Transactional(readOnly=true)
	public T get(Cond cond) {
		return getDao().get(cond);
	}

}
