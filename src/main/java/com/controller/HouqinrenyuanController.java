
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
 * 后勤人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/houqinrenyuan")
public class HouqinrenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(HouqinrenyuanController.class);

    @Autowired
    private HouqinrenyuanService houqinrenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private HugongService hugongService;
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
        params.put("houqinrenyuanDeleteStart",1);params.put("houqinrenyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = houqinrenyuanService.queryPage(params);

        //字典表数据转换
        List<HouqinrenyuanView> list =(List<HouqinrenyuanView>)page.getList();
        for(HouqinrenyuanView c:list){
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
        HouqinrenyuanEntity houqinrenyuan = houqinrenyuanService.selectById(id);
        if(houqinrenyuan !=null){
            //entity转view
            HouqinrenyuanView view = new HouqinrenyuanView();
            BeanUtils.copyProperties( houqinrenyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody HouqinrenyuanEntity houqinrenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,houqinrenyuan:{}",this.getClass().getName(),houqinrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HouqinrenyuanEntity> queryWrapper = new EntityWrapper<HouqinrenyuanEntity>()
            .eq("username", houqinrenyuan.getUsername())
            .or()
            .eq("houqinrenyuan_phone", houqinrenyuan.getHouqinrenyuanPhone())
            .or()
            .eq("houqinrenyuan_id_number", houqinrenyuan.getHouqinrenyuanIdNumber())
            .andNew()
            .eq("houqinrenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HouqinrenyuanEntity houqinrenyuanEntity = houqinrenyuanService.selectOne(queryWrapper);
        if(houqinrenyuanEntity==null){
            houqinrenyuan.setHouqinrenyuanDelete(1);
            houqinrenyuan.setCreateTime(new Date());
            houqinrenyuan.setPassword("123456");
            houqinrenyuanService.insert(houqinrenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者后勤人员手机号或者后勤人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HouqinrenyuanEntity houqinrenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,houqinrenyuan:{}",this.getClass().getName(),houqinrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HouqinrenyuanEntity> queryWrapper = new EntityWrapper<HouqinrenyuanEntity>()
            .notIn("id",houqinrenyuan.getId())
            .andNew()
            .eq("username", houqinrenyuan.getUsername())
            .or()
            .eq("houqinrenyuan_phone", houqinrenyuan.getHouqinrenyuanPhone())
            .or()
            .eq("houqinrenyuan_id_number", houqinrenyuan.getHouqinrenyuanIdNumber())
            .andNew()
            .eq("houqinrenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HouqinrenyuanEntity houqinrenyuanEntity = houqinrenyuanService.selectOne(queryWrapper);
        if("".equals(houqinrenyuan.getHouqinrenyuanPhoto()) || "null".equals(houqinrenyuan.getHouqinrenyuanPhoto())){
                houqinrenyuan.setHouqinrenyuanPhoto(null);
        }
        if(houqinrenyuanEntity==null){
            houqinrenyuanService.updateById(houqinrenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者后勤人员手机号或者后勤人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<HouqinrenyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HouqinrenyuanEntity houqinrenyuanEntity = new HouqinrenyuanEntity();
            houqinrenyuanEntity.setId(id);
            houqinrenyuanEntity.setHouqinrenyuanDelete(2);
            list.add(houqinrenyuanEntity);
        }
        if(list != null && list.size() >0){
            houqinrenyuanService.updateBatchById(list);
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
            List<HouqinrenyuanEntity> houqinrenyuanList = new ArrayList<>();//上传的东西
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
                            HouqinrenyuanEntity houqinrenyuanEntity = new HouqinrenyuanEntity();
//                            houqinrenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //houqinrenyuanEntity.setPassword("123456");//密码
//                            houqinrenyuanEntity.setHouqinrenyuanName(data.get(0));                    //后勤人员姓名 要改的
//                            houqinrenyuanEntity.setHouqinrenyuanPhoto("");//照片
//                            houqinrenyuanEntity.setHouqinrenyuanPhone(data.get(0));                    //后勤人员手机号 要改的
//                            houqinrenyuanEntity.setHouqinrenyuanIdNumber(data.get(0));                    //后勤人员身份证号 要改的
//                            houqinrenyuanEntity.setHouqinrenyuanEmail(data.get(0));                    //邮箱 要改的
//                            houqinrenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            houqinrenyuanEntity.setHouqinrenyuanDelete(1);//逻辑删除字段
//                            houqinrenyuanEntity.setCreateTime(date);//时间
                            houqinrenyuanList.add(houqinrenyuanEntity);


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
                                //后勤人员手机号
                                if(seachFields.containsKey("houqinrenyuanPhone")){
                                    List<String> houqinrenyuanPhone = seachFields.get("houqinrenyuanPhone");
                                    houqinrenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> houqinrenyuanPhone = new ArrayList<>();
                                    houqinrenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("houqinrenyuanPhone",houqinrenyuanPhone);
                                }
                                //后勤人员身份证号
                                if(seachFields.containsKey("houqinrenyuanIdNumber")){
                                    List<String> houqinrenyuanIdNumber = seachFields.get("houqinrenyuanIdNumber");
                                    houqinrenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> houqinrenyuanIdNumber = new ArrayList<>();
                                    houqinrenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("houqinrenyuanIdNumber",houqinrenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HouqinrenyuanEntity> houqinrenyuanEntities_username = houqinrenyuanService.selectList(new EntityWrapper<HouqinrenyuanEntity>().in("username", seachFields.get("username")).eq("houqinrenyuan_delete", 1));
                        if(houqinrenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HouqinrenyuanEntity s:houqinrenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //后勤人员手机号
                        List<HouqinrenyuanEntity> houqinrenyuanEntities_houqinrenyuanPhone = houqinrenyuanService.selectList(new EntityWrapper<HouqinrenyuanEntity>().in("houqinrenyuan_phone", seachFields.get("houqinrenyuanPhone")).eq("houqinrenyuan_delete", 1));
                        if(houqinrenyuanEntities_houqinrenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HouqinrenyuanEntity s:houqinrenyuanEntities_houqinrenyuanPhone){
                                repeatFields.add(s.getHouqinrenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [后勤人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //后勤人员身份证号
                        List<HouqinrenyuanEntity> houqinrenyuanEntities_houqinrenyuanIdNumber = houqinrenyuanService.selectList(new EntityWrapper<HouqinrenyuanEntity>().in("houqinrenyuan_id_number", seachFields.get("houqinrenyuanIdNumber")).eq("houqinrenyuan_delete", 1));
                        if(houqinrenyuanEntities_houqinrenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HouqinrenyuanEntity s:houqinrenyuanEntities_houqinrenyuanIdNumber){
                                repeatFields.add(s.getHouqinrenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [后勤人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        houqinrenyuanService.insertBatch(houqinrenyuanList);
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
        HouqinrenyuanEntity houqinrenyuan = houqinrenyuanService.selectOne(new EntityWrapper<HouqinrenyuanEntity>().eq("username", username));
        if(houqinrenyuan==null || !houqinrenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(houqinrenyuan.getHouqinrenyuanDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(houqinrenyuan.getId(),username, "houqinrenyuan", "后勤人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","后勤人员");
        r.put("username",houqinrenyuan.getHouqinrenyuanName());
        r.put("tableName","houqinrenyuan");
        r.put("userId",houqinrenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HouqinrenyuanEntity houqinrenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HouqinrenyuanEntity> queryWrapper = new EntityWrapper<HouqinrenyuanEntity>()
            .eq("username", houqinrenyuan.getUsername())
            .or()
            .eq("houqinrenyuan_phone", houqinrenyuan.getHouqinrenyuanPhone())
            .or()
            .eq("houqinrenyuan_id_number", houqinrenyuan.getHouqinrenyuanIdNumber())
            .andNew()
            .eq("houqinrenyuan_delete", 1)
            ;
        HouqinrenyuanEntity houqinrenyuanEntity = houqinrenyuanService.selectOne(queryWrapper);
        if(houqinrenyuanEntity != null)
            return R.error("账户或者后勤人员手机号或者后勤人员身份证号已经被使用");
        houqinrenyuan.setHouqinrenyuanDelete(1);
        houqinrenyuan.setCreateTime(new Date());
        houqinrenyuanService.insert(houqinrenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HouqinrenyuanEntity houqinrenyuan = new HouqinrenyuanEntity();
        houqinrenyuan.setPassword("123456");
        houqinrenyuan.setId(id);
        houqinrenyuanService.updateById(houqinrenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HouqinrenyuanEntity houqinrenyuan = houqinrenyuanService.selectOne(new EntityWrapper<HouqinrenyuanEntity>().eq("username", username));
        if(houqinrenyuan!=null){
            houqinrenyuan.setPassword("123456");
            boolean b = houqinrenyuanService.updateById(houqinrenyuan);
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
    public R getCurrHouqinrenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HouqinrenyuanEntity houqinrenyuan = houqinrenyuanService.selectById(id);
        if(houqinrenyuan !=null){
            //entity转view
            HouqinrenyuanView view = new HouqinrenyuanView();
            BeanUtils.copyProperties( houqinrenyuan , view );//把实体数据重构到view中

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
