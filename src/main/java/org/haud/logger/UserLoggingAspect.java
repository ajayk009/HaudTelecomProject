package org.haud.logger;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.haud.model.Customer;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLoggingAspect {

	@Pointcut("execution(* org.haud.service.addCustomer..*(..))")
	public void saveReader() {
	}

	@AfterReturning("saveReader()")
	public void saveNewReader(JoinPoint joinPoint) {

		Object[] lArgs = joinPoint.getArgs();
		Customer user = (Customer) lArgs[0];

		ThreadContext.put("username", user.getEmail());
		ThreadContext.put("field", "ALL");
		ThreadContext.put("from_value", "");
		ThreadContext.put("to_value", user.toString());
		
	       System.out.println("i am in aspect class");
		ThreadContext.clearAll();
	}

}
