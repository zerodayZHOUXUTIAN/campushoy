# 安徽师范大学今日校园自动填报
![](https://img.shields.io/badge/build-passing-brightgreen) ![](https://img.shields.io/badge/Powered%20by-Damon-green)
### 写在前面

今日校园安师大每日自动提交疫情上报java脚本（如果能重来我要选python），如果参考了本项目或者喜欢本项目可以点个star。本项目仅供学习交流使用，如作他用所承受的任何直接、间接法律责任一概与作者无关。如果此项目侵犯了您或者您公司的权益，请立即联系我删除。


每天早上七点起床提交今日校园真的好麻烦，写出这个脚本参考了一些项目，欢迎大家提需求，互相交流学习。

### 项目介绍
- 每日提交表单（表单内容需要自己修改代码配置，安师大的可能不用配置）
- 发送提交信息的邮件

### 所需环境
- 一台服务器（[阿里云服务器学生几块钱一个月](https://www.aliyun.com/minisite/goods?userCode=ems3fhvr "阿里云服务器学生几块钱一个月")，当然你也可以用自己电脑，不过电脑需要一直开机
- jdk1.8
- IDEA

### 组织结构

``` lua
campushoy
	├── bean -- 最后提交的表单模型
	├── common -- 工具类和一些地址常量等
	├── dao -- 用于发送邮件数据和http请求数据的文件
	├── service -- 逻辑业务层
	└── Application -- 启动入口
