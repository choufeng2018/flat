
### 项目介绍

爱家公寓后台管理

前后端分离，前端项目请见  [rcs-admin](https://github.com/fikyair/rcs-admin)

### 项目技术栈：
- springboot
- mybatis
- maven

### 项目数据库：
- mysql 5.7

### 效果图

<img width="800" height="373" src="http://oziqlv1ur.bkt.clouddn.com/%E5%9C%B0%E5%9F%9F%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.png"/>

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
