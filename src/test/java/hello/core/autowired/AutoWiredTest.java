package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        //자동 주입 대상을 옵션으로 처리하는 방법은 다음과 같다.


        //@Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        //호출 안됨
        @Autowired(required = false) // false로 해두면 메서드 자체가 호출이 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("NoBean1 = " + noBean1);
        }
        //null 호출
        //org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("NoBean2 = " + noBean2);
        }
        //Optional.empty 호출
        //Optional<> : 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("NoBean3 = " + noBean3);
        }
    }
}
