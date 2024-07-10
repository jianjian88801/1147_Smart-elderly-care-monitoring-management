package com.dao;

import com.entity.TijianyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianyuanView;

/**
 * 体检员 Dao 接口
 *
 * @author 
 */
public interface TijianyuanDao extends BaseMapper<TijianyuanEntity> {

   List<TijianyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
