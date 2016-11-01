package com.imlc.demo.service;

import java.util.List;

import com.imlc.demo.dao.ModelDao;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.exception.MsgException;

public class ModelService {
	
	private static ModelService ModelService=null;

	public static ModelService getInstance(){
		if(ModelService == null){
			ModelService = new ModelService();
		}
		return ModelService;
	}

	private ModelService(){
		
	}
	
	private  ModelDao dao = new ModelDao();

	
	/**
	 * 统计总记录数
	 * @return
	 */
	public int  countrecord() {
		return dao.countrecord();
	}
	
	
	/**
	 * 分页查询所有的样机信息
	 * 
	 * @return
	 */
	public List<T_Model> findAllModel(int pageIndex, int pageSize) {
		return dao.findAllModel( pageIndex,  pageSize);
	}
	
	/**
	 * 添加样机
	 * 
	 * @param
	 * @throws MsgException
	 */
	public void registModel( T_Model model) throws MsgException {
		// 检查样机名是否存在，存在则提示
		if (dao.findModelName(model.getModelName()) != null) {
			throw new MsgException("样机名已经存在");
		}
		// 如果不存在，调用dao方法添加样机
		dao.AddModel(model);
	}

	/**
	 * 查询所有的样机信息
	 * 
	 * @return
	 */
	public List< T_Model> findAllModel() {
		return dao.findAllModel();
	}

	/**
	 * 通过ID查询样机
	 * 
	 * @param id
	 * @return
	 */
	public  T_Model findModelById(Integer id) {
		return dao.findByModelID(id);
	}

	/**
	 * 修改样机信息
	 * 
	 * @param model
	 */
	public void updateModels( T_Model model) {
		dao.updateModels(model);
	}

	/**
	 * 删除样机信息
	 * 
	 * @param model
	 */
	public void DeleteModels( T_Model model) {
		dao.deleteModels(model);
	}

	/**
	 * 通过样机姓名模糊查询
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List< T_Model> findByModelName( String modelName) throws Exception {
		return dao.findByModelName(modelName);

	}

}
