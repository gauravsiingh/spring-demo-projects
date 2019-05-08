package com.gaurav.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
		//System.out.println("Advice ran, the get() method called");
		//System.out.println(joinPoint.toString());
		//System.out.println(joinPoint.getTarget());
		
		//Circle circle = (Circle) joinPoint.getTarget();
		
		

	}
	
	/*@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string arguments has been called " + name);
	}*/
	
	/*@After("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string arguments has been called " + name);
	}*/
	
	@AfterReturning("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string arguments has been called " + name);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name) {
		System.out.println("Exception thrown");
	}
	
/*	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Second Advice Executed");
	}*/
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {}
	
	//@Pointcut("execution(* * com.gaurav.springAOP.model.Circel.*(..))")
	@Pointcut("within(com.gaurav.springAOP.model.Circle)")
	public void allCircleMethods() {}
	
	//@Pointcut(args())

}
