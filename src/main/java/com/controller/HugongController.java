
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 护工
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hugong")
public class HugongController {
    private static final Logger logger = LoggerFactory.getLogger(HugongController.class);

    @Autowired
    private HugongService hugongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private HouqinrenyuanService houqinrenyuanService;
    @Autowired
    private TijianyuanService tijianyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("后勤人员".equals(role))
            params.put("houqinrenyuanId",request.getSession().getAttribute("userId"));
        else if("护工".equals(role))
            params.put("hugongId",request.getSession().getAttribute("userId"));
        else if("体检员".equals(role))
            params.put("tijianyuanId",request.getSession().getAttribute("userId"));
        params.put("hugongDeleteStart",1);params.put("hugongDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = hugongService.queryPage(params);

        //字典表数据转换
        List<HugongView> list =(List<HugongView>)page.getList();
        for(HugongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HugongEntity hugong = hugongService.selectById(id);
        if(hugong !=null){
            //entity转view
            HugongView view = new HugongView();
            BeanUtils.copyProperties( hugong , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HugongEntity hugong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hugong:{}",this.getClass().getName(),hugong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HugongEntity> queryWrapper = new EntityWrapper<HugongEntity>()
            .eq("username", hugong.getUsername())
            .or()
            .eq("hugong_phone", hugong.getHugongPhone())
            .or()
            .eq("hugong_id_number", hugong.getHugongIdNumber())
            .andNew()
            .eq("hugong_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HugongEntity hugongEntity = hugongService.selectOne(queryWrapper);
        if(hugongEntity==null){
            hugong.setHugongDelete(1);
            hugong.setCreateTime(new Date());
            hugong.setPassword("123456");
            hugongService.insert(hugong);
            return R.ok();
        }else {
            return R.error(511,"账户或者护工手机号或者护工身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HugongEntity hugong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hugong:{}",this.getClass().getName(),hugong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HugongEntity> queryWrapper = new EntityWrapper<HugongEntity>()
            .notIn("id",hugong.getId())
            .andNew()
            .eq("username", hugong.getUsername())
            .or()
            .eq("hugong_phone", hugong.getHugongPhone())
            .or()
            .eq("hugong_id_number", hugong.getHugongIdNumber())
            .andNew()
            .eq("hugong_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HugongEntity hugongEntity = hugongService.selectOne(queryWrapper);
        if("".equals(hugong.getHugongPhoto()) || "null".equals(hugong.getHugongPhoto())){
                hugong.setHugongPhoto(null);
        }
        if(hugongEntity==null){
            hugongService.updateById(hugong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者护工手机号或者护工身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<HugongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HugongEntity hugongEntity = new HugongEntity();
            hugongEntity.setId(id);
            hugongEntity.setHugongDelete(2);
            list.add(hugongEntity);
        }
        if(list != null && list.size() >0){
            hugongService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HugongEntity> hugongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HugongEntity hugongEntity = new HugongEntity();
//                            hugongEntity.setUsername(data.get(0));                    //账户 要改的
//                            //hugongEntity.setPassword("123456");//密码
//                            hugongEntity.setHugongName(data.get(0));                    //护工姓名 要改的
//                            hugongEntity.setHugongPhoto("");//照片
//                            hugongEntity.setHugongPhone(data.get(0));                    //护工手机号 要改的
//                            hugongEntity.setHugongIdNumber(data.get(0));                    //护工身份证号 要改的
//                            hugongEntity.setHugongEmail(data.get(0));                    //邮箱 要改的
//                            hugongEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            hugongEntity.setHugongDelete(1);//逻辑删除字段
//                            hugongEntity.setCreateTime(date);//时间
                            hugongList.add(hugongEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //护工手机号
                                if(seachFields.containsKey("hugongPhone")){
                                    List<String> hugongPhone = seachFields.get("hugongPhone");
                                    hugongPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> hugongPhone = new ArrayList<>();
                                    hugongPhone.add(data.get(0));//要改的
                                    seachFields.put("hugongPhone",hugongPhone);
                                }
                                //护工身份证号
                                if(seachFields.containsKey("hugongIdNumber")){
                                    List<String> hugongIdNumber = seachFields.get("hugongIdNumber");
                                    hugongIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hugongIdNumber = new ArrayList<>();
                                    hugongIdNumber.add(data.get(0));//要改的
                                    seachFields.put("hugongIdNumber",hugongIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HugongEntity> hugongEntities_username = hugongService.selectList(new EntityWrapper<HugongEntity>().in("username", seachFields.get("username")).eq("hugong_delete", 1));
                        if(hugongEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HugongEntity s:hugongEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //护工手机号
                        List<HugongEntity> hugongEntities_hugongPhone = hugongService.selectList(new EntityWrapper<HugongEntity>().in("hugong_phone", seachFields.get("hugongPhone")).eq("hugong_delete", 1));
                        if(hugongEntities_hugongPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HugongEntity s:hugongEntities_hugongPhone){
                                repeatFields.add(s.getHugongPhone());
                            }
                            return R.error(511,"数据库的该表中的 [护工手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //护工身份证号
                        List<HugongEntity> hugongEntities_hugongIdNumber = hugongService.selectList(new EntityWrapper<HugongEntity>().in("hugong_id_number", seachFields.get("hugongIdNumber")).eq("hugong_delete", 1));
                        if(hugongEntities_hugongIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HugongEntity s:hugongEntities_hugongIdNumber){
                                repeatFields.add(s.getHugongIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [护工身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hugongService.insertBatch(hugongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HugongEntity hugong = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("username", username));
        if(hugong==null || !hugong.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(hugong.getHugongDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(hugong.getId(),username, "hugong", "护工");
        R r = R.ok();
        r.put("token", token);
        r.put("role","护工");
        r.put("username",hugong.getHugongName());
        r.put("tableName","hugong");
        r.put("userId",hugong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HugongEntity hugong){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HugongEntity> queryWrapper = new EntityWrapper<HugongEntity>()
            .eq("username", hugong.getUsername())
            .or()
            .eq("hugong_phone", hugong.getHugongPhone())
            .or()
            .eq("hugong_id_number", hugong.getHugongIdNumber())
            .andNew()
            .eq("hugong_delete", 1)
            ;
        HugongEntity hugongEntity = hugongService.selectOne(queryWrapper);
        if(hugongEntity != null)
            return R.error("账户或者护工手机号或者护工身份证号已经被使用");
        hugong.setHugongDelete(1);
        hugong.setCreateTime(new Date());
        hugongService.insert(hugong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HugongEntity hugong = new HugongEntity();
        hugong.setPassword("123456");
        hugong.setId(id);
        hugongService.updateById(hugong);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HugongEntity hugong = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("username", username));
        if(hugong!=null){
            hugong.setPassword("123456");
            boolean b = hugongService.updateById(hugong);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHugong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HugongEntity hugong = hugongService.selectById(id);
        if(hugong !=null){
            //entity转view
            HugongView view = new HugongView();
            BeanUtils.copyProperties( hugong , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
