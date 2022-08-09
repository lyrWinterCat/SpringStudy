package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest { //스프링 통합테스트
    // @SpringBootTest : 스프링 컨테이너와 함께 테스트 실행
    // @Transactional : 테스트케이스에 해당 어노테이션이 붙으면
    // 테스트가 끝나면 해당 데이터를 항상 rollback 해 줌 (데이터 초기화 할 필요가 없음)
    // >> 테스트를 반복해도 데이터가 DB에 쌓이지 않음
    
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    //MemoryMemberRepository memberRepository;
    // test는 필드주입도 가능 (편함)


//    @BeforeEach
//    public void beforeEach(){
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }

//    @AfterEach
//    public void afterEach(){
//        memberRepository.clearStore();// 각각의 테스트가 끝난 후 메서드 초기화 + 어노테이션
//        // 공용데이터를 지워주는 역할
//    }

    @Test
    //@Commit >>db에 저장됨
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

       /* try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then
    }


//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
}