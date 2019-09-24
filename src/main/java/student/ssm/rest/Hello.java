package student.ssm.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import wismport.cn.com.webxml.GetMobileCodeInfo;
import student.ssm.pojo.Student;

/**
 * web Service�ṩ����籩¶һ����ͨ��Web���е��õ�API���ǿ����ԵĿ��
 * 
 *  c#-----|				|-----c#
 *  php----|web service	����	|----php
 *         |----------------|
 *  java---|				|---java
 *  phyon--|				|--phyon
 *  
 *  sʹ��web��ʽ�����ܺ���Ӧ�ⲿϵͳ��ĳ�����󣬴Ӷ�ʵ��Զ�̵���
 * 
 * web service = http + xml
 * 
 * socket --> httpЭ��
 * 
 * ����web service ����
 * 
 * jdk1.6�Ժ�ͨ��jax-ws���ṩ��web service����֧��
 * 
 * jax-ws�ṩ��ws�Ĵ���
 * 
 * 1.�÷�ʽͨ��ע�ⷽʽ����web service
 * 
 * 2.ͨ��jdk EndPoint.publish()����service����
 * 
 * @author Administrator
 *
 *	serviceע��
 *
 **** @WebMethod(operationName="getMObileInfo"): �޸ķ�����
    * @WebResult(name="phone")���޸ķ��ز�����
    * @WebParam(name="osName")���޸����������
    *
    *
 */
/**
 * a��@WebService���ε���Ĭ�Ϲ������зǾ�̬����
 * jax-ws���ṩprivate,static,final�ͱ�ָ�����ɷ��ʵķ���
 * 
 * b��@WebService���ε��������[1,n)�����Թ����ķ�������������ʧ��
 * 
 *web service����
 * 
 * XML(Extensible Marup Language):��չ�Ա������
 * 
 * 	xml�����ڴ����ʽ�������ݣ���web����Ļ���
 * 
 * 	namespace:�����ռ�
 * 
 * 	xmlns:"http://itcast.cn"ʹ��Ĭ�ϵ����ƿռ�
 * 
 * 	xmlns:itacst="http://itcast.cn"ʹ��ָ�������ƿռ�
 * 
 * 
 * WSDL(WebService Description Language):web������������
 * 
 * 	ͨ��xml��ʽ˵��������ʲô�ط�-��ַ
 * 
 * 	ͨ��xml��ʽ˵�������ṩʲô����-��ε���
 * 
 * EndPoint����˵�
 * 
 * 
 * soapЭ��( simple object access protocol)�򵥶���Э�飺����xml����淶���ı�Э�顣������httpЭ���ϵ�Э�� (1.1��1.2�������ռ䲻ͬ)
 * 	Envelope-����Ĳ��֡���xml��Ԫ����ʽ����
 *  Headers-��ѡ��
 *  Body-����ġ���body���֣�����Ҫִ�еķ������ķ������ͷ��͵������������ݡ�
 *  SOAP��Ϊһ������xml���Ե�Э����������ϴ���
 * 
 * soa(service-oriented architecture):�������ļܹ�����һ��˼�룬��˼������װ���Եķ�ʽ����Ӧ��(�ɲ�ж�����弴��)
 * 
 * uddi(Universal Description,Discovery and Integration)ͳһ���������֡��̳�
 * 
 * �������webӦ�õķ���
 * 
 * http-get����
 * 
 * 
 * 
 * http-client���post����
 * 
 * wsimport
 * 
 *  1.   wsimport uri   				�ڵ�ǰĿ¼����wsdl
 *  2.   jar -cvf name.jar D:\XXXX    	���jar�ļ�
 *  3.   								���빤��Ŀ¼��ʹ��
 *  
 * 
 * WSDL����
 */
@WebService(serviceName = "helloService",//�޸ķ�����
			targetNamespace = "http://student.ssm.hello.cn")//�޸������ռ䣬Ĭ�ϰ���ȡ��
//������ҵ���� �����ṩwebservice����   ,Ĭ��ֻ�Ƕ�public ���εķ���������webservice��ʽ����
public class Hello {

	@WebMethod(operationName = "getStuInfo")
	public @WebResult(name = "student") Student getStudentInfo(@WebParam(name = "stu")String studentN) {
		Student student = new Student();
		student.setAge(12);
		student.setName("hello Service");
		return student;
	}

	@WebMethod(exclude = true)//�ų��˷���
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
		 * address:�����ַ
		 * implementor:�����ʵ�ֶ���
		 */
		GetMobileCodeInfo g = new GetMobileCodeInfo();
		Endpoint.publish(address, new Hello());
	}
}
