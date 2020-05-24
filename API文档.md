# 监测应用开发文档

## 一.数据库建立

~~~sql
/*用户表*/
CREATE TABLE user(
		user_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'用户编号',
		user_name VARCHAR(12) NOT NULL UNIQUE KEY COMMENT'用户名',
		user_password VARCHAR(15) NOT NULL COMMENT'密码',
  	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*员工表*/
CREATE TABLE staff(
		staff_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'员工编号',
		staff_name VARCHAR(12) NOT NULL UNIQUE KEY COMMENT'员工名',
		sex VARCHAR(5) COMMENT'性别 男/女',
		age SMALLINT(2) COMMENT '年龄',
		phone VARCHAR(12) COMMENT'手机号',
		department VARCHAR(20) COMMENT'所属部门',
		position VARCHAR(20) COMMENT'所属职位',
  	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*部门表*/
CREATE TABLE department(
		dept_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'部门编号',
		dept_name VARCHAR(12) NOT NULL UNIQUE KEY COMMENT'部门名称',
		dept_phone VARCHAR(20) NOT NULL COMMENT'部门电话',
		dept_leader VARCHAR(15) NOT NULL COMMENT'负责人',
		leader_phone VARCHAR(20) NOT NULL COMMENT'负责人电话',
		dept_remark VARCHAR(100) COMMENT'备注',
  	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*测量表*/
CREATE TABLE monitor_plan(
		id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'监测方案编号',
  	monitor_type VARCHAR(20) NOT NULL COMMENT '监测类型',
		monitor_place VARCHAR(20) NOT NULL COMMENT '监测点名',
		monitor_name VARCHAR(12) NOT NULL COMMENT'监测指标名',
		min_value DECIMAL(5,2) COMMENT'下限值',
		max_value DECIMAL(5,2) COMMENT'上限值',
		monitor_unit VARCHAR(10) COMMENT '测量单位',
		monitor_frequency VARCHAR(10) NOT NULL COMMENT'监测频率'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*设备表*/
CREATE TABLE device(
		device_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'设备编号',
		device_code VARCHAR(12) COMMENT'设备编码',
		device_name VARCHAR(12) NOT NULL COMMENT'设备名称',
		device_size VARCHAR(12) COMMENT'型号规格',
		device_category VARCHAR(12) COMMENT'类别',
		item VARCHAR(12) COMMENT'适用项目',
		check_frequency VARCHAR(12) COMMENT'检验周期',
		device_producer VARCHAR(30) NOT NULL COMMENT'生产商',
		create_time VARCHAR(15) NOT NULL COMMENT'生产日期'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*模拟检测数据表*/
CREATE TABLE analog_data(
		id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'模拟检测编号',
		monitor_id SMALLINT(5) NOT NULL COMMENT '监测方案编号',
		monitor_value DECIMAL(5,2) COMMENT'实测值',
		monitor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT'监测时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE analog_data ADD CONSTRAINT FOREIGN KEY(monitor_id) REFERENCES monitor_plan(id) ON UPDATE CASCADE;

/*实时检测数据表*/
CREATE TABLE real_time_data(
		id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'实时检测生成编号',
		monitor1 DECIMAL(5,2) COMMENT '监测方案1',
		monitor2 DECIMAL(5,2) COMMENT '监测方案2',
		monitor3 DECIMAL(5,2) COMMENT '监测方案3',
		monitor4 DECIMAL(5,2) COMMENT '监测方案4',
		monitor5 DECIMAL(5,2) COMMENT '监测方案5',
		monitor6 DECIMAL(5,2) COMMENT '监测方案6',
		monitor7 DECIMAL(5,2) COMMENT '监测方案7',
		monitor8 DECIMAL(5,2) COMMENT '监测方案8',
		monitor9 DECIMAL(5,2) COMMENT '监测方案9',
		monitor10 DECIMAL(5,2) COMMENT '监测方案10',
		monitor11 DECIMAL(5,2) COMMENT '监测方案11',
		monitor12 DECIMAL(5,2) COMMENT '监测方案12',
		monitor13 DECIMAL(5,2) COMMENT '监测方案13',
		monitor14 DECIMAL(5,2) COMMENT '监测方案14',
		monitor15 DECIMAL(5,2) COMMENT '监测方案15',
		monitor16 DECIMAL(5,2) COMMENT '监测方案16',
		monitor17 DECIMAL(5,2) COMMENT '监测方案17',
		monitor18 DECIMAL(5,2) COMMENT '监测方案18',
		monitor19 DECIMAL(5,2) COMMENT '监测方案19',
		monitor20 DECIMAL(5,2) COMMENT '监测方案20',
		monitor21 DECIMAL(5,2) COMMENT '监测方案21',
		monitor22 DECIMAL(5,2) COMMENT '监测方案22',
		monitor23 DECIMAL(5,2) COMMENT '监测方案23',
		monitor24 DECIMAL(5,2) COMMENT '监测方案24',
		monitor25 DECIMAL(5,2) COMMENT '监测方案25',
		monitor26 DECIMAL(5,2) COMMENT '监测方案26',
		monitor27 DECIMAL(5,2) COMMENT '监测方案27',
		monitor28 DECIMAL(5,2) COMMENT '监测方案28',
		monitor29 DECIMAL(5,2) COMMENT '监测方案29',
		monitor30 DECIMAL(5,2) COMMENT '监测方案30',
		monitor31 DECIMAL(5,2) COMMENT '监测方案31',
		monitor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'监测时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*清运表*/
CREATE TABLE clearance(
		cle_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'清运单位编号',
		cle_name VARCHAR(50) NOT NULL UNIQUE KEY COMMENT'清运单位名称',
		cle_leader VARCHAR(15) COMMENT'负责人',
		leader_phone VARCHAR(20) COMMENT'负责人电话',
		cle_place VARCHAR(50) COMMENT'地址',
		cle_remark VARCHAR(100) COMMENT'备注',
  	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*维修记录表*/
CREATE TABLE maintenance(
		maint_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT'检修编号',
		maint_name VARCHAR(50) NOT NULL COMMENT'设备名称',
		use_time VARCHAR(15) NOT NULL COMMENT'使用时间',
		maint_time VARCHAR(15) COMMENT'检修日期', 
		maint_status VARCHAR(50) NOT NULL COMMENT'检查状态',
		report_status VARCHAR(50) NOT NULL COMMENT'报备情况',
		maint_person VARCHAR(15) NOT NULL COMMENT'检修人'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
~~~

监测方案如下图所示

![image-20200512132022440](/Users/ming/Library/Application Support/typora-user-images/image-20200512132022440.png)



## 二.API接口

### 1.用户

##### 1.0 登录

[POST] / user / login

参数

| 参数名称 | 是否必须 | 说明   |
| -------- | -------- | ------ |
| username | Y        | 用户名 |
| password | Y        | 密码   |

返回

```json
{
	"code":0,
	"msg":"success",
	"data":"用户名"
}

{
	"code":1,
	"msg":"用户名或密码错误"
}
```

##### 1.1 注册

[POST] / user / regist

参数

| 参数名称 | 是否必须 | 说明            |
| -------- | -------- | --------------- |
| username | Y        | 用户名（>=5位） |
| password | Y        | 密码（>=6位）   |

返回

```json
{
	"code":0,
	"msg":"success"
  "data":"用户名"
}

{
	"code":1,
	"msg":"用户名不可用"
}
{
  "code":2,
  "msg":"密码长度小于6位"
}
```

##### 1.2 删除账号

[POST] / user / delete

参数

| 参数名称 | 是否必须 | 说明   |
| -------- | -------- | ------ |
| username | Y        | 用户名 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 1.3 修改账号密码

[POST] / user / update

参数

| 参数名称 | 是否必须 | 说明   |
| -------- | -------- | ------ |
| username | Y        | 用户名 |
| password | Y        | 新密码 |
| id       | Y        | 用户ID |

返回

```json
{
	"code":0,
	"msg":"success"
}
{
	"code":1,
  "msg":"密码长度小于6位"
}
```

##### 1.4 获取全部用户信息

[GET] / user / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 3,
        "user_list": [
            {
                "user_id": 1,
                "user_name": "hahaahbbc",
                "user_pass": "123213213",
                "update_time": "2020-05-14 17:07:25",
                "create_time": "2020-05-12 14:20:16"
            },
            {
                "user_id": 4,
                "user_name": "djgdf",
                "user_pass": "abcsdf",
                "update_time": "2020-05-12 16:17:57",
                "create_time": "2020-05-12 16:17:57"
            },
            {
                "user_id": 5,
                "user_name": "bbcddf",
                "user_pass": "abcs200",
                "update_time": "2020-05-12 16:19:32",
                "create_time": "2020-05-12 16:19:32"
            }
        ]
    }
}
```

### 2.员工

##### 2.0 新增一个员工

[POST] / staff / add

参数

| 参数名称   | 是否必须 | 说明   |
| ---------- | -------- | ------ |
| name       | Y        | 员工名 |
| sex        | N        | 性别   |
| age        | N        | 年龄   |
| phone      | N        | 手机号 |
| department | N        | 部门   |
| position   | N        | 职位   |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 2.1 通过员工ID删除

[POST] / staff / delete

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 员工编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 2.2 更新员工信息

[POST] / staff / update

参数

| 参数名称   | 是否必须 | 说明     |
| ---------- | -------- | -------- |
| name       | Y        | 员工名   |
| sex        | N        | 性别     |
| age        | N        | 年龄     |
| phone      | N        | 手机号   |
| department | N        | 部门     |
| position   | N        | 职位     |
| id         | Y        | 员工编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 2.3 查询所有员工

[GET] / staff / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

~~~json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 6,
        "staff_list": [
            {
                "id": 1,
                "name": "陈同学",
                "sex": "男",
                "age": 23,
                "phone": "13800138000",
                "department": "技术部",
                "position": "初级工程师",
                "update_time": "2020-05-14 16:45:36",
                "create_time": "2020-05-14 16:45:06"
            },
            {
                "id": 2,
                "name": "何同学",
                "sex": "女",
                "age": 25,
                "phone": "13800138001",
                "department": "管理部",
                "position": "高级经理",
                "update_time": "2020-05-14 16:46:04",
                "create_time": "2020-05-14 16:46:04"
            }
        ]
    }
}
~~~



##### 2.3 查询单个员工信息

[POST] / staff / getById

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 员工编号 |

返回

~~~json
{
    "code": 0,
    "msg": "success",
    "data": {
        "id": 1,
        "name": "陈同学",
        "sex": "男",
        "age": 23,
        "phone": "13800138000",
        "department": "技术部",
        "position": "初级工程师",
        "update_time": "2020-05-14 16:45:36",
        "create_time": "2020-05-14 16:45:06"
    }
}
~~~



### 3.获取监测数据

##### 3.0 获取全部数据

[GET] / monitor / getAll

参数

| 参数名称 | 是否必须 | 说明                       |
| -------- | -------- | -------------------------- |
| type     | Y        | 检测类型名[废气/废水/噪声] |
| pageNum  | Y        | 当前页数（1开始）          |
| pageSize | Y        | 一页返回多少条             |

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 1,
        "monitor_list": [
            {
                "update_time": "2020-05-13 00:37:00",
                "monitor_item_list": [
                    {
                        "id": 10,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "化学需氧量",
                        "min_value": 0.00,
                        "max_value": 90.00,
                        "real_value": 52.00,
                        "unit": "mg/L",
                        "frequency": "1次/2小时"
                    },
                    {
                        "id": 11,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "氨氮",
                        "min_value": 0.00,
                        "max_value": 8.00,
                        "real_value": 108.00,
                        "unit": "mg/L",
                        "frequency": "1次/2小时"
                    },
                    {
                        "id": 12,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "ph值",
                        "min_value": 6.00,
                        "max_value": 9.00,
                        "real_value": 303.00,
                        "unit": "",
                        "frequency": "1次/2小时"
                    },
                    {
                        "id": 13,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "流量",
                        "min_value": null,
                        "max_value": null,
                        "real_value": 2.00,
                        "unit": "",
                        "frequency": "1次/2小时"
                    },
                    {
                        "id": 14,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "悬浮物",
                        "min_value": 0.00,
                        "max_value": 30.00,
                        "real_value": 8.30,
                        "unit": "mg/L",
                        "frequency": "1次/1天"
                    },
                    {
                        "id": 15,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "色度",
                        "min_value": 0.00,
                        "max_value": 50.00,
                        "real_value": 48.00,
                        "unit": "倍",
                        "frequency": "1次/1天"
                    },
                    {
                        "id": 16,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "总氮",
                        "min_value": 0.00,
                        "max_value": 12.00,
                        "real_value": 259.00,
                        "unit": "mg/L",
                        "frequency": "1次/1周"
                    },
                    {
                        "id": 17,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "总磷",
                        "min_value": 0.00,
                        "max_value": 0.80,
                        "real_value": 367.00,
                        "unit": "mg/L",
                        "frequency": "1次/1周"
                    },
                    {
                        "id": 18,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "五日生化需氧量",
                        "min_value": 0.00,
                        "max_value": 20.00,
                        "real_value": 2.00,
                        "unit": "mg/L",
                        "frequency": "1次/1周"
                    },
                    {
                        "id": 19,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "二噁英",
                        "min_value": 0.00,
                        "max_value": 30.00,
                        "real_value": 111.00,
                        "unit": "mg/L",
                        "frequency": "1次/1年"
                    },
                    {
                        "id": 20,
                        "place": "废水总排放口",
                        "type": "废水",
                        "name": "可吸附有机卤化物",
                        "min_value": 0.00,
                        "max_value": 12.00,
                        "real_value": 1.00,
                        "unit": "mg/L",
                        "frequency": "1次/1年"
                    }
                ]
            }
        ]
    }
}
```

### 4.设备

##### 4.0 新增一个设备

[POST] / device / add

参数

| 参数名称   | 是否必须 | 说明     |
| ---------- | -------- | -------- |
| code       | N        | 设备编码 |
| name       | Y        | 设备名称 |
| size       | N        | 设备规格 |
| category   | N        | 手机号   |
| item       | N        | 适用项目 |
| frequency  | N        | 职位     |
| producer   | Y        | 生产商   |
| creat_time | N        | 生产日期 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 4.1 通过设备ID删除

[POST] / device / delete

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 员工编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 4.2 更新设备信息

[POST] / device / update

参数

| 参数名称   | 是否必须 | 说明     |
| ---------- | -------- | -------- |
| code       | N        | 设备编码 |
| name       | Y        | 设备名称 |
| size       | N        | 设备规格 |
| category   | N        | 类别     |
| item       | N        | 适用项目 |
| frequency  | N        | 检验周期 |
| producer   | Y        | 生产商   |
| creat_time | N        | 生产日期 |
| id         | Y        | 设备ID   |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 4.3 查询所有设备信息

[GET] / device / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

~~~Json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 4,
        "device_list": [
            {
                "device_id": 2,
                "device_code": "ICT24G",
                "device_name": "机车",
                "device_size": "20*20",
                "device_category": "类别1",
                "device_item": "项目1",
                "check_frequency": "1周/次",
                "device_producer": "一汽重工",
                "create_time": "2020-05-19 12:27:00"
            }
        ]
    }
}
~~~

### 5.部门

##### 5.0 新增一个部门

[POST] / department / add

参数

| 参数名称     | 是否必须 | 说明     |
| ------------ | -------- | -------- |
| name         | Y        | 部门名   |
| dept_phone   | Y        | 部门电话 |
| leader       | Y        | 部门主管 |
| leader_phone | Y        | 主管电话 |
| remark       | N        | 备注     |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 5.1 通过部门ID删除

[POST] / department / delete

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 部门编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 

##### 5.2 通过部门ID更新

[POST] / department / update

参数

| 参数名称     | 是否必须 | 说明     |
| ------------ | -------- | -------- |
| name         | Y        | 部门名   |
| dept_phone   | Y        | 部门电话 |
| leader       | Y        | 部门主管 |
| leader_phone | Y        | 主管电话 |
| remark       | N        | 备注     |
| id           | Y        | 部门编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 5.3 查询所有部门信息

[GET] / device / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

~~~json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 1,
        "device_list": [
            {
                "dept_id": 2,
                "dept_name": "纪律部",
                "dept_phone": "13800138000",
                "dept_leader": "张同学",
                "leader_phone": "13800138001",
                "dept_remark": "666",
                "update_time": "2020-05-19 13:37:09",
                "create_time": "2020-05-19 13:36:47"
            }
        ]
    }
}
~~~

### 6.清算

##### 6.0 新增一条清算记录

[POST] / clearance / add

参数

| 参数名称 | 是否必须 | 说明         |
| -------- | -------- | ------------ |
| name     | Y        | 清运单位名称 |
| leader   | N        | 部门电话     |
| phone    | N        | 部门主管     |
| place    | N        | 地址         |
| remark   | N        | 适用项目     |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 6.1 通过清算ID删除

[POST] / clearance / delete

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 部门编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 

##### 6.2 通过清算ID更新

[POST] / clearance / update

参数

| 参数名称 | 是否必须 | 说明         |
| -------- | -------- | ------------ |
| name     | Y        | 清运单位名称 |
| leader   | N        | 负责人       |
| phone    | N        | 负责人电话   |
| place    | N        | 地址         |
| remark   | N        | 备注         |
| id       | Y        | 清算编号     |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 6.3 查询所有清算信息

[GET] / clearance / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

~~~json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 1,
        "clearance_list": [
            {
                "cle_id": 4,
                "cle_name": "清算名2",
                "cle_leader": "负责人2",
                "leader_phone": "13800138000",
                "cle_place": "地址",
                "cle_remark": "备注",
                "update_time": "2020-05-19 14:18:36",
                "create_time": "2020-05-19 14:17:48"
            }
        ]
    }
}
~~~

### 7.检修

##### 7.0 新增一条检修记录

[POST] / maintenance / add

参数

| 参数名称      | 是否必须 | 说明             |
| ------------- | -------- | ---------------- |
| name          | Y        | 检修设备名       |
| use_time      | Y        | 使用时间(String) |
| maint_time    | Y        | 检修时间(Date)   |
| maint_status  | Y        | 检修状态         |
| report_status | Y        | 报备状态         |
| person        | Y        | 检修人           |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 7.1 通过检修ID删除

[POST] / maintenance / delete

参数

| 参数名称 | 是否必须 | 说明     |
| -------- | -------- | -------- |
| id       | Y        | 部门编号 |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 

##### 7.2 通过检修ID更新

[POST] / maintenance / update

参数

| 参数名称      | 是否必须 | 说明             |
| ------------- | -------- | ---------------- |
| name          | Y        | 检修设备名       |
| user_time     | Y        | 使用时间(String) |
| maint_time    | Y        | 检修时间(Date)   |
| maint_status  | Y        | 检修状态         |
| report_status | Y        | 报备状态         |
| person        | Y        | 检修人           |
| id            | Y        | 检修ID           |

返回

```json
{
	"code":0,
	"msg":"success"
}
```

##### 7.3 查询所有检修记录

[GET] / maintenance / getAll

参数

| 参数名称 | 是否必须 | 说明           |
| -------- | -------- | -------------- |
| pageNum  | Y        | 当前页数 0开始 |
| pageSize | Y        | 一页显示多少条 |

返回

~~~json
{
    "code": 0,
    "msg": "success",
    "data": {
        "total_num": 1,
        "clearance_list": [
            {
                "maint_id": 3,
                "maint_name": "检修记录1",
                "user_time": "55小时",
                "maint_time": "2019-05-30 00:00:00",
                "maint_status": "报废",
                "report_status": "等待上报",
                "maint_person": "小李"
            }
        ]
    }
}
~~~

