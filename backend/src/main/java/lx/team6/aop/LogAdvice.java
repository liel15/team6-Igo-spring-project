package lx.team6.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Controller의 모든 메서드에 대해 호출 전에 로깅
    @Before("execution(* lx.team6.controller.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                logger.debug("Argument: " + arg);
            }
        }
    }

    // 메서드가 정상적으로 종료되었을 때
    @AfterReturning(pointcut = "execution(* lx.team6.controller.*.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: " + joinPoint.getSignature().toShortString());
        logger.debug("Return value: " + result);
    }

    // 메서드 실행 중 예외가 발생했을 때
    @AfterThrowing(pointcut = "execution(* lx.team6.controller.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: " + joinPoint.getSignature().toShortString(), exception);
    }
}
