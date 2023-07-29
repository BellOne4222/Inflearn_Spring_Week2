package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }
    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() { // 의존관계 주입이 끝나면
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close()  {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
//NetworkClient.afterPropertiesSet
//connect: http://hello-spring.dev
//call: http://hello-spring.dev message = 초기화 연결 메시지
//23:28:20.912 [main] DEBUG o.s.c.a.AnnotationConfigApplicationContext -- Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@117159c0, started on Sat Jul 29 23:28:20 KST 2023
//NetworkClient.destroy
//close: http://hello-spring.dev//close: http://hello-spring.dev