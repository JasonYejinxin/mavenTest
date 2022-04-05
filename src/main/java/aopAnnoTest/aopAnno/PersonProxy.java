package aopAnnoTest.aopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value = "execution(* aopAnnoTest.aopAnno.User.add(..))")
    public void before1(){
        System.out.println("before111");
    }
}
