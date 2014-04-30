## 开始配置

打开AndroidStudio [File]->[Settings]->[Compiler]->[Annotation Processors],勾选"Enable annotation processing"

## ID命名规则

1. 为避免不同的VIEW命名冲突，ID的命名以可以辨别VIEW的字母开关，例如activity_demo.xml里面的TextView,可命名为android:id="@id+/demo\_txt", Button可命名为android:id="@id+/demo\_ok\_btn"