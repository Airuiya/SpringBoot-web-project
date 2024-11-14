> [理解@RequestMapping-CSDN博客](https://blog.csdn.net/m0_70287148/article/details/143670554)

@RequestMapping 是 Spring 框架中的一个核心注解，用于处理 HTTP 请求和控制器方法之间的映射关系。它是一个非常强大的注解，可以用来指定请求路径、HTTP 方法、请求头和参数等。

###基本概念
@RequestMapping 注解可以应用于类或方法上，用于定义请求到控制器方法的映射关系。

- **类级别**：当应用在类上时，表示该类下的所有方法都会继承这个路径。
- 方法级别：当应用在方法上时，表示该方法处理的具体请求路径。

###常用属性
##### 1. `value` 或 `path`

- **描述**：指定请求的 URI。
- **类型**：String[]，可以指定多个路径。
- **默认值**：无

```java
@RequestMapping(value = "/users")
public class UserController {
    @RequestMapping(value = "/list")
    public String listUsers() {
        return "userList";
    }
}
```

##### 2. `method`

- **描述**：指定请求的方法类型（GET、POST、PUT、DELETE 等）。
- **类型**：RequestMethod[]，可以指定多个方法。
- **默认值**：所有 HTTP 方法

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public String getUsers() {
    return "userList";
}
 
@RequestMapping(value = "/users", method = RequestMethod.POST)
public String createUser(@ModelAttribute User user) {
    // 处理用户创建逻辑
    return "redirect:/users";
}
```

##### 3. `params`

- **描述**：指定请求必须包含的参数及其值。
- **类型**：String[]，可以指定多个参数条件。
- **默认值**：无

```java
@RequestMapping(value = "/search", params = {"name=John"})
public String searchByName() {
    return "searchResults";
}
```

##### 4. `headers`

- **描述**：指定请求必须包含的请求头及其值。
- **类型**：String[]，可以指定多个请求头条件。
- **默认值**：无

```java
@RequestMapping(value = "/api/data", headers = {"Content-Type=application/json"})
public String getData() {
    return "jsonData";
}
```

##### 5. `consumes`

- **描述**：指定请求的内容类型（Content-Type），例如 `application/json`。
- **类型**：String[]，可以指定多个内容类型。
- **默认值**：无

```java
@RequestMapping(value = "/api/save", consumes = "application/json")
public String saveData(@RequestBody User user) {
    // 处理保存逻辑
    return "saveSuccess";
}
```

##### 6. `produces`

- **描述**：指定响应的内容类型（Content-Type），例如 `application/json`。
- **类型**：String[]，可以指定多个内容类型。
- **默认值**：无

```java
@RequestMapping(value = "/api/getUser", produces = "application/json")
public @ResponseBody User getUser() {
    User user = new User();
    user.setId(1L);
    user.setName("John Doe");
    return user;
}
```
