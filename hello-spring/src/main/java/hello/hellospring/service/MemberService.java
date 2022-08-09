package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Component
//@Service //service안에 component가 속해있음
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) { //DI주입
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
//        //같은 이름이 있는 중복 회원은 X
        validateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
        
        //aop를 쓰지 않는다면
//        long start = System.currentTimeMillis();
//        try {
//            validateDuplicateMember(member); //중복 회원 검증
//            memberRepository.save(member);
//            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join " + timeMs + "ms");
//        }
    }

    private void validateDuplicateMember(Member member) { //ctrl alt shift t >> 해당 인스턴스 메서드화
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){

        return memberRepository.findAll();
        
        //만들어야 하는 로직들
//        long start = System.currentTimeMillis();
//        try {
//            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers " + timeMs + "ms");
//        }
        
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
