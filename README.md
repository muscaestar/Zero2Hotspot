# Zero2Hotspot
Learn JVM from practice. An implementation of hotspot using Java and C++.
参照JVM虚拟机规范时间，1.8版本。

## 字节码文件解析器
- [x] 常规信息
- [x] 常量池
  - 遗留
    - [ ] CONSTANT_MethodHandle_info结构
    - [ ] CONSTANT_Invoke-Dynamic_info结构
- [x] 接口表
- [x] 字段表
- [x] 方法表
  - 遗留
    - [ ] Code中的指令
    - [ ] RuntimeVisibleParameterAnnotations,RuntimeInvisibleParameterAnnotations
    - [ ] AnnotationDefault
    - [ ] MethodParameters
- [x] 属性表
  - 遗留
    - [ ] InnerClasses
    - [ ] EnclosingMethod
    - [ ] SourceDebugExtension
    - [ ] BootstrapMethods
    - [ ] Synthetic
    - [x] Deprecated
    - [ ] Signature
    - [ ] RuntimeVisibleAnnotations,RuntimeInvisibleAnnotations
    - [ ] RuntimeVisibleTypeAnnotations,RuntimeInvisibleTypeAnnotations
