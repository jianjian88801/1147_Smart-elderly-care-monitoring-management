package com.dao;

import com.entity.HouqinrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HouqinrenyuanView;

/**
 * 后勤人员 Dao 接口
 *
 * @author 
 */
public interface HouqinrenyuanDao extends BaseMapper<HouqinrenyuanEntity> {

   List<HouqinrenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
