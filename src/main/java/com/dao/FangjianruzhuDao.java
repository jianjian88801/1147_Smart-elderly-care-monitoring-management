package com.dao;

import com.entity.FangjianruzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianruzhuView;

/**
 * 房间入住信息 Dao 接口
 *
 * @author 
 */
public interface FangjianruzhuDao extends BaseMapper<FangjianruzhuEntity> {

   List<FangjianruzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
