package mod2.aspects;

import mod2.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
    @Pointcut("execution(* mod2.UniLibrary.get*(..))")
    private void allGetMethods(){}

    @Pointcut("execution(* mod2.UniLibrary.return*(..))")
    private void allReturnMethods(){}

    @Pointcut("allGetMethods() && !allReturnMethods()")
    private void allMethodsExceptReturn(){}

    @Before("allMethodsExceptReturn()")
    public void beforeAllMethodsExceptReturnAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAllMethodsExceptReturnAdvice: " +
                "Logging Get method without Return");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Absolutly signature of method: " + methodSignature.getMethod());

        if (methodSignature.getName().equals("getBook")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj: arg) {
                if (obj instanceof Book) {
                   Book myBook = (Book) obj;
                    System.out.println("Информация о книге: " +
                            "\n   Название - " + myBook.getName() +
                            "\n   Автор - " + myBook.getAuthor() +
                            "\n   Год издания - " + myBook.getYear());
                }
            }
        }
    }

    @Around("allReturnMethods()")
    public Object aroundAllReturnMethodsLoggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundAllReturnMethodsLoggingAdvice: start method");

        Object targetMethodResult = null;


        try {
            targetMethodResult = pjp.proceed();

        }
        catch (Exception e) {
            System.out.println("aroundAllReturnMethodsLoggingAdvice: Logging exception " + e);
            throw e;
        }

        System.out.println("aroundAllReturnMethodsLoggingAdvice: end method");
        System.out.println("-------------------------------------------------");

        return targetMethodResult;

    }
}
