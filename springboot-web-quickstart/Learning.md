# @RequestMapping

>  [理解@RequestMapping-CSDN博客](https://blog.csdn.net/m0_70287148/article/details/143670554)

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





## 响应状态码

### 状态码大类

| 1XX  | 响应中—临时状态码，表示请求已经接收，告诉客户端应该继续请求或者如果它已经完成则忽略它。 |
| ---- | ------------------------------------------------------------ |
| 2XX  | 成功——表示请求已经被成功接受，处理已经完成                   |
| 3XX  | 重定向——重定向到其他地方；让客户端再发起一次请求以完成整个处理。 |
| 4XX  | 客户端错误——处理发生错误，责任在客户端。如：请求了不存在的资源、客户端未被授权、禁止访问等。 |
| 5XX  | 服务器错误——处理发生错误，责任在服务器。如：程序跑出异常等。 |


1、信息响应
- 100 Continue：表示客户端应当继续发送请求的剩余部分。
- 101 Switching Protocols：服务器正在切换协议。

2：成功（Successful）
- 200 OK：请求已成功处理，请求所希望的响应头或数据体将随此响应返回。
- 201 Created：请求已经被实现，并且有一个新的资源已经依据请求的需要而创建。
- 202 Accepted：请求已被接受处理，但未完成。
- 204 No Content：请求已成功处理，但没有内容需要返回。

3：重定向（Redirection）
- 301:永久重定向，目标网站已经永久转移到其他网址，浏览器将会缓存响应的URL。
- 302：临时重定向，目标网站暂时转移到其他网址，浏览器不会缓存响应的URL。
- 304： 使用的是缓存的数据
- 305： 使用代理，当前服务器并不负责返回响应，它只是转发请求的，让别的服务器去返回响应，然后它在转回数据

4、4xx    (Client Error) 客户端错误状态码，表示服务器无法处理请求。
- 400:请求包含语法错误
- 401:当前请求需要进行用户验证
- 403:服务端成功接收请求，但拒绝执行。
- 404:用户端请求资源未找到

5、5xx    (Server Error) 服务器错误状态码，表示服务器处理请求出错。
- 500:后台处理出错
- 502:网关接收到无效响应
- 503:暂时无法提供服务
- 504:网关长时间未接收到响应