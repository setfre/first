package student.ssm.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import wismport.cn.com.webxml.GetMobileCodeInfo;
import student.ssm.pojo.Student;

/**
 * web Service提供向外界暴露一个能通过Web进行调用的API，是跨语言的框架
 * 
 *  c#-----|				|-----c#
 *  php----|web service	服务	|----php
 *         |----------------|
 *  java---|				|---java
 *  phyon--|				|--phyon
 *  
 *  s使用web方式，接受和响应外部系统的某种请求，从而实现远程调用
 * 
 * web service = http + xml
 * 
 * socket --> http协议
 * 
 * 发布web service 服务
 * 
 * jdk1.6以后，通过jax-ws包提供对web service服务支持
 * 
 * jax-ws提供了ws的代理
 * 
 * 1.该方式通过注解方式声明web service
 * 
 * 2.通过jdk EndPoint.publish()发布service服务
 * 
 * @author Administrator
 *
 *	service注解
 *
 **** @WebMethod(operationName="getMObileInfo"): 修改方法名
    * @WebResult(name="phone")：修改返回参数名
    * @WebParam(name="osName")：修改输入参数名
    *
    *
 */
/**
 * a被@WebService修饰的类默认公开所有非静态方法
 * jax-ws不提供private,static,final和被指定不可访问的服务
 * 
 * b被@WebService修饰的类必须有[1,n)个可以公开的方法，否则启动失败
 * 
 *web service名词
 * 
 * XML(Extensible Marup Language):扩展性标记语言
 * 
 * 	xml，用于传输格式化的数据，是web服务的基础
 * 
 * 	namespace:命名空间
 * 
 * 	xmlns:"http://itcast.cn"使用默认的名称空间
 * 
 * 	xmlns:itacst="http://itcast.cn"使用指定的名称空间
 * 
 * 
 * WSDL(WebService Description Language):web服务描述语言
 * 
 * 	通过xml形式说明服务在什么地方-地址
 * 
 * 	通过xml方式说明服务提供什么方法-如何调用
 * 
 * EndPoint服务端点
 * 
 * 
 * soap协议( simple object access protocol)简单对象协议：基于xml编码规范的文本协议。运行在http协议上的协议 (1.1和1.2的命名空间不同)
 * 	Envelope-必须的部分。以xml根元素形式出现
 *  Headers-可选的
 *  Body-必须的。在body部分，包含要执行的服务器的方法。和发送到服务器的数据。
 *  SOAP作为一个基于xml语言的协议可用于网上传输
 * 
 * soa(service-oriented architecture):面向服务的架构。是一种思想，意思是以组装电脑的方式开发应用(可拆卸，即插即用)
 * 
 * uddi(Universal Description,Discovery and Integration)统一描述、发现、继承
 * 
 * 获得其他web应用的服务
 * 
 * http-get方法
 * 
 * 
 * 
 * http-client框架post请求
 * 
 * wsimport
 * 
 *  1.   wsimport uri   				在当前目录解析wsdl
 *  2.   jar -cvf name.jar D:\XXXX    	打包jar文件
 *  3.   								导入工程目录下使用
 *  
 * 
 * WSDL解析
 */
@WebService(serviceName = "helloService",//修改服务名
			targetNamespace = "http://student.ssm.hello.cn")//修改命名空间，默认包名取反
//声明该业务类 对外提供webservice服务   ,默认只是对public 修饰的方法对外以webservice形式发布
public class Hello {

	@WebMethod(operationName = "getStuInfo")
	public @WebResult(name = "student") Student getStudentInfo(@WebParam(name = "stu")String studentN) {
		Student student = new Student();
		student.setAge(12);
		student.setName("hello Service");
		return student;
	}

	@WebMethod(exclude = true)//排除此服务
	public void sayHello() {
		System.out.println("hello");
	}
	private void sayBye() {
		System.out.println("bye");
	}
	void saySaYaoNaLa() {
		System.out.println("byebye");
	}
	protected void sayLuck() {
		System.out.println("Luck");
	}
	public static void main(String[] args) {
		String address = "http://127.0.0.1:8888/student/Hello";
		/**
		 * address:服务地址
		 * implementor:服务的实现对象
		 */
		GetMobileCodeInfo g = new GetMobileCodeInfo();
		Endpoint.publish(address, new Hello());
	}
}
