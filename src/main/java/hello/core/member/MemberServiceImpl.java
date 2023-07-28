package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memberRepository = new MemoryMemberRepository(); // DIP 위반
    private final MemberRepository memberRepository;

    @Autowired // 자동 의존 관계 주입, ac.getBean(MemberRepository.class)와 같은 기능
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    } // 구현에만 의존
    
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
