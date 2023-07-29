package hello.core;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(
//        basePackages = "hello.core",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class)) // 스캔해서 스프링 빈으로 자동으로 등록할 때, 필터에 걸리는 거는 빼고 등록하게 구현
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository(); //  Overriding bean definition for bean 'memoryMemberRepository' with a different definition
        // 이 경우 수동 빈 등록이 우선권을 가진다.
        //(수동 빈이 자동 빈을 오버라이딩 해버린다.)
//    }

}