package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component 붙은 클래스를 스캔해서 자동으로 빈으로 등록해준다.
@ComponentScan(
        //컴포넌트 스캔을 어디서부터 할지 세팅 가능 - 보통 지정하지 않음 > 관례적으로 지정하지 않고 프로젝트 최상단에 두는 것
        //basePackages = "hello.core.member",
        //기존 예제 코드들에 @Configuration을 붙인 예제들이 있어서 사용한거 >> 실무에서는 그냥 전부 컴포넌트 스캔 한다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
