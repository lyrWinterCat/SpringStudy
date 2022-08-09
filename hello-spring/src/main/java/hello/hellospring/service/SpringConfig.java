package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;


//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    //    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

    // spring data jpa가 springDataJpaMemberRepository를 스프링빈으로 자동 등록해줌
    // 따라서 밑의 memberRepository가 없어도 작동! 
    /*
    스프링 데이터 JPA 제공 기능
    : 인터페이스를 통한 기본적인 CRUD
    findByName(), findByEmail()처럼 메서드 이름만으로 조회 기능 제공
    페이징 기능 자동제공
    
    ** 실무에서는 jpa와 스프링데이터 jpa를 기본으로 사용 / 복잡한 동적쿼리는 Querydsl이라는 라이브러리 사용.
    두 조합으로도 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리를 사용하거나, jdbc Template를 사용하면 됨
    
     */


//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//
//        /*
//        다형성 활용!! (구현체 바꿔끼우기)
//        개방폐쇄 원칙(OCP)
//        스프링의 DI(Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고,
//        설정만으로 구현 클래스를 변경할 수 있다 !
//         */
//    }




}
