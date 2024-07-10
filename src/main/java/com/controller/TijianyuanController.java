
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
 * 体检员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijianyuan")
public class TijianyuanController {
    private static final Logger logger = LoggerFactory.getLogger(TijianyuanController.class);

    @Autowired
    private TijianyuanService tijianyuanService;


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
    private HugongService hugongService;


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
        params.put("tijianyuanDeleteStart",1);params.put("tijianyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = tijianyuanService.queryPage(params);

        //字典表数据转换
        List<TijianyuanView> list =(List<TijianyuanView>)page.getList();
        for(TijianyuanView c:list){
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
        TijianyuanEntity tijianyuan = tijianyuanService.selectById(id);
        if(tijianyuan !=null){
            //entity转view
            TijianyuanView view = new TijianyuanView();
            BeanUtils.copyProperties( tijianyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody TijianyuanEntity tijianyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijianyuan:{}",this.getClass().getName(),tijianyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TijianyuanEntity> queryWrapper = new EntityWrapper<TijianyuanEntity>()
            .eq("username", tijianyuan.getUsername())
            .or()
            .eq("tijianyuan_phone", tijianyuan.getTijianyuanPhone())
            .or()
            .eq("tijianyuan_id_number", tijianyuan.getTijianyuanIdNumber())
            .andNew()
            .eq("tijianyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianyuanEntity tijianyuanEntity = tijianyuanService.selectOne(queryWrapper);
        if(tijianyuanEntity==null){
            tijianyuan.setTijianyuanDelete(1);
            tijianyuan.setCreateTime(new Date());
            tijianyuan.setPassword("123456");
            tijianyuanService.insert(tijianyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者体检员手机号或者体检员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianyuanEntity tijianyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tijianyuan:{}",this.getClass().getName(),tijianyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<TijianyuanEntity> queryWrapper = new EntityWrapper<TijianyuanEntity>()
            .notIn("id",tijianyuan.getId())
            .andNew()
            .eq("username", tijianyuan.getUsername())
            .or()
            .eq("tijianyuan_phone", tijianyuan.getTijianyuanPhone())
            .or()
            .eq("tijianyuan_id_number", tijianyuan.getTijianyuanIdNumber())
            .andNew()
            .eq("tijianyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianyuanEntity tijianyuanEntity = tijianyuanService.selectOne(queryWrapper);
        if("".equals(tijianyuan.getTijianyuanPhoto()) || "null".equals(tijianyuan.getTijianyuanPhoto())){
                tijianyuan.setTijianyuanPhoto(null);
        }
        if(tijianyuanEntity==null){
            tijianyuanService.updateById(tijianyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者体检员手机号或者体检员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<TijianyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TijianyuanEntity tijianyuanEntity = new TijianyuanEntity();
            tijianyuanEntity.setId(id);
            tijianyuanEntity.setTijianyuanDelete(2);
            list.add(tijianyuanEntity);
        }
        if(list != null && list.size() >0){
            tijianyuanService.updateBatchById(list);
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
            List<TijianyuanEntity> tijianyuanList = new ArrayList<>();//上传的东西
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
                            TijianyuanEntity tijianyuanEntity = new TijianyuanEntity();
//                            tijianyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //tijianyuanEntity.setPassword("123456");//密码
//                            tijianyuanEntity.setTijianyuanName(data.get(0));                    //体检员姓名 要改的
//                            tijianyuanEntity.setTijianyuanPhoto("");//照片
//                            tijianyuanEntity.setTijianyuanPhone(data.get(0));                    //体检员手机号 要改的
//                            tijianyuanEntity.setTijianyuanIdNumber(data.get(0));                    //体检员身份证号 要改的
//                            tijianyuanEntity.setTijianyuanEmail(data.get(0));                    //邮箱 要改的
//                            tijianyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            tijianyuanEntity.setTijianyuanDelete(1);//逻辑删除字段
//                            tijianyuanEntity.setCreateTime(date);//时间
                            tijianyuanList.add(tijianyuanEntity);


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
                                //体检员手机号
                                if(seachFields.containsKey("tijianyuanPhone")){
                                    List<String> tijianyuanPhone = seachFields.get("tijianyuanPhone");
                                    tijianyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> tijianyuanPhone = new ArrayList<>();
                                    tijianyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("tijianyuanPhone",tijianyuanPhone);
                                }
                                //体检员身份证号
                                if(seachFields.containsKey("tijianyuanIdNumber")){
                                    List<String> tijianyuanIdNumber = seachFields.get("tijianyuanIdNumber");
                                    tijianyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tijianyuanIdNumber = new ArrayList<>();
                                    tijianyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("tijianyuanIdNumber",tijianyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<TijianyuanEntity> tijianyuanEntities_username = tijianyuanService.selectList(new EntityWrapper<TijianyuanEntity>().in("username", seachFields.get("username")).eq("tijianyuan_delete", 1));
                        if(tijianyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TijianyuanEntity s:tijianyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //体检员手机号
                        List<TijianyuanEntity> tijianyuanEntities_tijianyuanPhone = tijianyuanService.selectList(new EntityWrapper<TijianyuanEntity>().in("tijianyuan_phone", seachFields.get("tijianyuanPhone")).eq("tijianyuan_delete", 1));
                        if(tijianyuanEntities_tijianyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TijianyuanEntity s:tijianyuanEntities_tijianyuanPhone){
                                repeatFields.add(s.getTijianyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [体检员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //体检员身份证号
                        List<TijianyuanEntity> tijianyuanEntities_tijianyuanIdNumber = tijianyuanService.selectList(new EntityWrapper<TijianyuanEntity>().in("tijianyuan_id_number", seachFields.get("tijianyuanIdNumber")).eq("tijianyuan_delete", 1));
                        if(tijianyuanEntities_tijianyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TijianyuanEntity s:tijianyuanEntities_tijianyuanIdNumber){
                                repeatFields.add(s.getTijianyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [体检员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tijianyuanService.insertBatch(tijianyuanList);
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
        TijianyuanEntity tijianyuan = tijianyuanService.selectOne(new EntityWrapper<TijianyuanEntity>().eq("username", username));
        if(tijianyuan==null || !tijianyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(tijianyuan.getTijianyuanDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(tijianyuan.getId(),username, "tijianyuan", "体检员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","体检员");
        r.put("username",tijianyuan.getTijianyuanName());
        r.put("tableName","tijianyuan");
        r.put("userId",tijianyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody TijianyuanEntity tijianyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<TijianyuanEntity> queryWrapper = new EntityWrapper<TijianyuanEntity>()
            .eq("username", tijianyuan.getUsername())
            .or()
            .eq("tijianyuan_phone", tijianyuan.getTijianyuanPhone())
            .or()
            .eq("tijianyuan_id_number", tijianyuan.getTijianyuanIdNumber())
            .andNew()
            .eq("tijianyuan_delete", 1)
            ;
        TijianyuanEntity tijianyuanEntity = tijianyuanService.selectOne(queryWrapper);
        if(tijianyuanEntity != null)
            return R.error("账户或者体检员手机号或者体检员身份证号已经被使用");
        tijianyuan.setTijianyuanDelete(1);
        tijianyuan.setCreateTime(new Date());
        tijianyuanService.insert(tijianyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        TijianyuanEntity tijianyuan = new TijianyuanEntity();
        tijianyuan.setPassword("123456");
        tijianyuan.setId(id);
        tijianyuanService.updateById(tijianyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        TijianyuanEntity tijianyuan = tijianyuanService.selectOne(new EntityWrapper<TijianyuanEntity>().eq("username", username));
        if(tijianyuan!=null){
            tijianyuan.setPassword("123456");
            boolean b = tijianyuanService.updateById(tijianyuan);
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
    public R getCurrTijianyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        TijianyuanEntity tijianyuan = tijianyuanService.selectById(id);
        if(tijianyuan !=null){
            //entity转view
            TijianyuanView view = new TijianyuanView();
            BeanUtils.copyProperties( tijianyuan , view );//把实体数据重构到view中

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
