## 开始配置

打开AndroidStudio [File]->[Settings]->[Compiler]->[Annotation Processors],勾选"Enable annotation processing"


## 遵守的规范

1. 为避免不同的VIEW命名冲突，ID的命名以可以辨别VIEW的字母开关，例如activity_demo.xml里面的TextView,可命名为android:id="@id+/demo\_txt", Button可命

2. 通用的组件样式写在styles.xml里面，如
        <style name="com.globalmarket.like.style.primaryBtn" parent="android:Widget.Button">
            <item name="android:textSize">@dimen/text_size_normal</item>
            <item name="android:background">@drawable/bg_login_btn</item>
            <item name="android:textColor">@color/white</item>
        </style>       
        
        #引用样式
        <Button
            android:id="@+id/login_signin_btn"
            android:text="@string/sign_in"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="20dp"
            style="@style/com.globalmarket.like.style.primaryBtn" />

3. 字体大小等定义在dimens.xml里面，如
		<dimen name="text_size_normal">18sp</dimen>
        
4. 结构划分与类	
  	controller：存放\*\*\*Activity类	
    对应着activity_\*\*\*.xml布局，负责处理用户的交互事件
    
    service: 存放\*\*\*LogicService类和\*\*\*ViewService类		
    \*\*\*LogicService负责接收\*\*\*Activity的调用，处理完成后调用\*\*\*ViewService更新UI
        

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
    
5. 全局替换并且更改文件夹名称		
	将com.daniel.android_gradle_aa_seed替换成实际的包名，如com.globalmarket.like