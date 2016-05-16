# mall-parent

# 商城框架初次搭建
# created by 2016/05/05


# index-service 配置打包

# index-web 集成spingmvc ， freemarker

# pom 文件替换，添加core

# parent pom 包依赖管理，修改成包依赖


#freemaker 取值的问题，取决于controller 写的是model  还是 modelMap
1、model  如果为model 那么在则可以直接写 model.setAttribute 的属性名称

2、modelMap 如果为modelMap的话，他的值则为Key,Value 所以在前端取值的时候，需要像map一样 取Key
    a、假如我传值为users（集合）
    方法定义 public String getAllList(@ModelAttribute ModelMap modelMap) {}
    上面方法，我设置一个modelMap 为命名  那么他的默认key则为 modelMap
     在页面上取值则为：modelMap[users]

    b、方法二
    方法定义：public String getAllList(@ModelAttribute("myList") ModelMap modelMap) {}
    上面方法，我设置modelMap 名称为 myList 那么他的key为 MyList
    取值为：myList[users]