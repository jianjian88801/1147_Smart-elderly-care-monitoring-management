package com.dao;

import com.entity.LaorenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaorenView;

/**
 * 老人信息预约 Dao 接口
 *
 * @author 
 */
public interface LaorenDao extends BaseMapper<LaorenEntity> {

   List<LaorenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
