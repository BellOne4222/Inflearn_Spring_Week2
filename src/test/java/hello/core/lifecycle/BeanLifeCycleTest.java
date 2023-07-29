package hello.core.lifecycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    }
    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); // 생성자 호출
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
    //생성자 호출, url = null
    //connect: null
    //call: null message = 초기화 연결 메시지
    //생성자 부분을 보면 url 정보 없이 connect가 호출되는 것을 확인할 수 있다.
    //너무 당연한 이야기이지만 객체를 생성하는 단계에는 url이 없고, 객체를 생성한 다음에 외부에서 수정자 주
    //입을 통해서 setUrl() 이 호출되어야 url이 존재하게 된다.
}