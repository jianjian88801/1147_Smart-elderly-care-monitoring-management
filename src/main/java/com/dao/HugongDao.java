package com.dao;

import com.entity.HugongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HugongView;

/**
 * 护工 Dao 接口
 *
 * @author 
 */
public interface HugongDao extends BaseMapper<HugongEntity> {

   List<HugongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
