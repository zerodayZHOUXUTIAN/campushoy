# 安徽师范大学今日校园自动填报
![](https://img.shields.io/badge/build-passing-brightgreen) ![](https://img.shields.io/badge/Powered%20by-Damon-green)
### 写在前面

今日校园安师大每日自动提交疫情上报JAVA脚本（如果能重来我要选PYTHON），如果参考了本项目或者喜欢本项目可以点个star。本项目仅供学习交流使用，如作他用所承受的任何直接、间接法律责任一概与作者无关。如果此项目侵犯了您或者您公司的权益，请立即联系我删除。


每天早上七点起床提交今日校园真的好麻烦，参考了一些项目写出了这个脚本，欢迎大家提需求，互相交流学习。

**实现技术细节：[https://blog.csdn.net/ZERODAY_GI/article/details/107861326](https://blog.csdn.net/ZERODAY_GI/article/details/107861326)**

### 项目介绍
- 每日提交表单（表单内容需要自己修改代码配置，安师大的同学可能不用配置）
- 发送提交信息的邮件

### 所需环境
- 一台服务器（[阿里云服务器学生几块钱一个月](https://www.aliyun.com/minisite/goods?userCode=ems3fhvr)，当然你也可以用自己电脑，不过电脑需要一直开机）
- JDK1.8
- IDEA

### 组织结构

``` lua
campushoy
	├──── bean -- 最后提交的表单模型
	├──── common -- 工具类和一些地址常量等
	├──── dao -- 用于发送邮件数据和http请求数据的文件
	├──── service -- 业务逻辑层
	└─ Application -- 启动入口
```


### 项目流程图

![liuchengtu](https://gitee.com/csdn-ZERODAY_GI/Image/raw/048453ec1fcc6e46c7cc4223d3e9a30889429ea7/files/liuchengtu.png)

### 使用方式
1. 从github导入项目到IDEA
![1pic](https://gitee.com/csdn-ZERODAY_GI/Image/raw/048453ec1fcc6e46c7cc4223d3e9a30889429ea7/files/1picture.png)

2. 找到UserConstant文件修改自己的CPDAILY_EXTENSION和Cookie的值(这个需要用户通过抓包获得)。
![2pic](https://gitee.com/csdn-ZERODAY_GI/Image/raw/048453ec1fcc6e46c7cc4223d3e9a30889429ea7/files/2picture.png)
还需要修改用户邮箱的信息
![3pic](https://gitee.com/csdn-ZERODAY_GI/Image/raw/048453ec1fcc6e46c7cc4223d3e9a30889429ea7/files/3picture.png)

3. 用maven打包  项目出现target文件夹，删除campushoy-1.0.jar，找到campushoy-1.0-jar-with-dependencies.jar文件改名为campushoy-1.0.jar
![4pic](https://gitee.com/csdn-ZERODAY_GI/Image/raw/048453ec1fcc6e46c7cc4223d3e9a30889429ea7/files/4picture.png)

4. 将campushoy-1.0.jar上传到有java环境的服务器
启动项目（这个命令表示后台启动项目，关闭窗口也不会中断）
```shell
[root@iZ2p15w3d5xbru9mj3sZ ~]# nohup java -jar campushoy-1.0.jar >temp.out &
```
查看日志
```shell
[root@iZ2p15w3d5xbru9mj3sZ ~]# more temp.out 
--------------------------------------
----------------start-----------------
--------------------------------------
```
启动成功！


