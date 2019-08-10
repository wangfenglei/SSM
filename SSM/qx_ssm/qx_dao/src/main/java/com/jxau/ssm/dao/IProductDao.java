package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wfl
 * @date
 * @description
 *
 * 产品持久层
 */
public interface IProductDao {

    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */

    //@Select("select * from product")
    public List<Product> findAll() throws Exception;


    /**
     * 产品添加
     * @param product
     */
    public void saveProduct(Product product) throws Exception;

    /**
     * 产品更新
     * @param product
     * @throws Exception
     */
    public void updateProduct(@Param("product") Product product, @Param("id") String id) throws Exception;


    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws Exception
     */
    public Product findById(String id) throws Exception;


    /**
     * 开启产品状态
     * @throws Exception
     */
    public  void  updateStatus(List list)throws Exception;

    /**
     * 关闭产品状态
     * @throws Exception
     */
    public  void  updateDownStatus(List list)throws Exception;

    /**
     * 删除产品
     * @throws Exception
     */
    public  void  deleteProduct(List list)throws Exception;

}
