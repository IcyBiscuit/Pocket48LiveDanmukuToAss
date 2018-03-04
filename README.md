# Pocket48LiveDanmukuToAss
B站直播弹幕获取以及ass字幕生成

最基础的模块已经导出jar可直接使用
如有需要自行修改代码
第一次写代码，质量太差请见谅

### JVM版本
> java version "9"
Java(TM) SE Runtime Environment (build 9+181)
Java HotSpot(TM) 64-Bit Server VM (build 9+181, mixed mode)

### 录制B站直播弹幕使用方法
`java -jar filepath/GetXXXDanmuku.jar filepath`

### 弹幕录制文件转ass字幕文件
`java -jar filepath/BilibiliDanmukuProcessor.jar danmukuFilepath yyyy-MM-dd-hh-mm-ss`
or
`java -jar filepath/BilibiliDanmukuProcessor.jar danmukuFilepath yyyy-MM-dd-hh:mm:ss`


### 口袋48弹幕lrc文件转ass
`java -jar filepath/Pocket48*.jar lrcfilepath`
其中Fix为固定弹幕，Move为滚动弹幕

如需对字幕样式进行更改，或者对字幕内容进行过滤，可使用文本处理软件对ass文件进行修改

RegularExpressionFilter有常用的弹幕过滤表达式，Style有常用的字幕样式

下载、转压录播以及烧制字幕可自行使用ffmpeg等软件
