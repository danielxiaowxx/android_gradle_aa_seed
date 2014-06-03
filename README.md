## 开始配置

打开AndroidStudio [File]->[Settings]->[Compiler]->[Annotation Processors],勾选"Enable annotation processing"

## ID命名规则

1. 为避免不同的VIEW命名冲突，ID的命名以可以辨别VIEW的字母开关，例如activity_demo.xml里面的TextView,可命名为android:id="@id+/demo\_txt", Button可命名为android:id="@id+/demo\_ok\_btn"

## 开始前的一些修改

1. 修改common/MyApplication  
	根据实际情况修改crash日志的处理方式    
    (请参考https://github.com/ACRA/acra/wiki/AdvancedUsage#User_Interaction)
    
2. 修改common/CommonService  
	根据实际的出错信息提示交互设计，修改handleErrorResponse方法
    
3. 修改common/DxJsonHttpResponseHandler    
	这里假定服务器返回数据格式为{error:false, result:...}和{error:true, message:""}。如果格式不同，请修改该类
    
4. 修改res/values/config.xml  
	根据实际情况对配置进行修改
    
5. 全局替换		
	将com.daniel.android_gradle_aa_seed替换成实际的包名，如com.globalmarket.like