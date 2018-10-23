# flat
爱家公寓租赁平台后台管理系统
### 项目介绍

 爱家公寓后台管理

 前后端分离，[爱家公寓中后台管理系统](https://github.com/fikyair/house-admin) 

 [爱家公寓客户端](https://github.com/fikyair/rcs-admin)

 `本项目集成了客户端和管理系统的所有接口`

 ### 项目技术栈：
 - springboot
 - mybatis
 - maven

 ### 项目数据库：
 - mysql 5.7

 ### 接口列表(Updating)

 \* client与admin共用接口

 ##### CLIENT：

 | Definition | function      | args             | type       |
 | -----------|:-------------:|:----------------:|:----------:|
 |  Login     | validate      | name pwd         | get        |
 |  Regist    | add           | name pwd         | post       |
 |  Position  | query         | pName cName      | get        |
 |  FlatSource| query         | price flatType...| get        |
 |  Index     | query         | any...           | get        |
 |  News      | query         | all              | get        |
 |* Message   | add query     | flatId msg       | post       |
 |* Publish   | add           | pos area...      | post       |
 |* Collect   | add           | pos area...      | post       |

 ##### ADMIN:

 | Definition | function      | args             | type       |
 | -----------|:-------------:|:----------------:|:----------:|
 | User       | CRUD          | name pwd         | post       |
 | FlatSource | CRUD          | pos area...      | post       |
 | Position   | CRUD          | pName cName sName| post       |
 |* Message   | CRUD          | flatId msg       | post       |
 | News       | CRUD          | all              | post       |
