<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='houqinrenyuan'"  label='后勤人员姓名' prop="houqinrenyuanName">
               <el-input v-model="ruleForm.houqinrenyuanName"  placeholder='后勤人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='houqinrenyuan'" label='头像' prop="houqinrenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.houqinrenyuanPhoto?ruleForm.houqinrenyuanPhoto:''"
                         @change="houqinrenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='houqinrenyuan'"  label='后勤人员手机号' prop="houqinrenyuanPhone">
               <el-input v-model="ruleForm.houqinrenyuanPhone"  placeholder='后勤人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='houqinrenyuan'"  label='后勤人员身份证号' prop="houqinrenyuanIdNumber">
               <el-input v-model="ruleForm.houqinrenyuanIdNumber"  placeholder='后勤人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='houqinrenyuan'"  label='邮箱' prop="houqinrenyuanEmail">
               <el-input v-model="ruleForm.houqinrenyuanEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='hugong'"  label='护工姓名' prop="hugongName">
               <el-input v-model="ruleForm.hugongName"  placeholder='护工姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='hugong'" label='头像' prop="hugongPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.hugongPhoto?ruleForm.hugongPhoto:''"
                         @change="hugongPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='hugong'"  label='护工手机号' prop="hugongPhone">
               <el-input v-model="ruleForm.hugongPhone"  placeholder='护工手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='hugong'"  label='护工身份证号' prop="hugongIdNumber">
               <el-input v-model="ruleForm.hugongIdNumber"  placeholder='护工身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='hugong'"  label='邮箱' prop="hugongEmail">
               <el-input v-model="ruleForm.hugongEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='tijianyuan'"  label='体检员姓名' prop="tijianyuanName">
               <el-input v-model="ruleForm.tijianyuanName"  placeholder='体检员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='tijianyuan'" label='头像' prop="tijianyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.tijianyuanPhoto?ruleForm.tijianyuanPhoto:''"
                         @change="tijianyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='tijianyuan'"  label='体检员手机号' prop="tijianyuanPhone">
               <el-input v-model="ruleForm.tijianyuanPhone"  placeholder='体检员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='tijianyuan'"  label='体检员身份证号' prop="tijianyuanIdNumber">
               <el-input v-model="ruleForm.tijianyuanIdNumber"  placeholder='体检员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='tijianyuan'"  label='邮箱' prop="tijianyuanEmail">
               <el-input v-model="ruleForm.tijianyuanEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='用户姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='用户手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='用户身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
  },
  methods: {
    houqinrenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.houqinrenyuanPhoto = fileUrls;
    },
    hugongPhotoUploadChange(fileUrls) {
        this.ruleForm.hugongPhoto = fileUrls;
    },
    tijianyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.tijianyuanPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.houqinrenyuanName)&& 'houqinrenyuan'==this.flag){
                             this.$message.error('后勤人员姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.houqinrenyuanPhoto)&& 'houqinrenyuan'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                             if( 'houqinrenyuan' ==this.flag && this.ruleForm.houqinrenyuanPhone&&(!isMobile(this.ruleForm.houqinrenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.houqinrenyuanIdNumber)&& 'houqinrenyuan'==this.flag){
                             this.$message.error('后勤人员身份证号不能为空');
                             return
                         }

                             if( 'houqinrenyuan' ==this.flag && this.ruleForm.houqinrenyuanEmail&&(!isEmail(this.ruleForm.houqinrenyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.hugongName)&& 'hugong'==this.flag){
                             this.$message.error('护工姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.hugongPhoto)&& 'hugong'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                             if( 'hugong' ==this.flag && this.ruleForm.hugongPhone&&(!isMobile(this.ruleForm.hugongPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.hugongIdNumber)&& 'hugong'==this.flag){
                             this.$message.error('护工身份证号不能为空');
                             return
                         }

                             if( 'hugong' ==this.flag && this.ruleForm.hugongEmail&&(!isEmail(this.ruleForm.hugongEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.tijianyuanName)&& 'tijianyuan'==this.flag){
                             this.$message.error('体检员姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.tijianyuanPhoto)&& 'tijianyuan'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                             if( 'tijianyuan' ==this.flag && this.ruleForm.tijianyuanPhone&&(!isMobile(this.ruleForm.tijianyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.tijianyuanIdNumber)&& 'tijianyuan'==this.flag){
                             this.$message.error('体检员身份证号不能为空');
                             return
                         }

                             if( 'tijianyuan' ==this.flag && this.ruleForm.tijianyuanEmail&&(!isEmail(this.ruleForm.tijianyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('用户姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户身份证号不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes)&& this.flag !='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
