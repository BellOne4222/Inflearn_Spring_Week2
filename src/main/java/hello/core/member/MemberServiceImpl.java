package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memberRepository = new MemoryMemberRepository(); // DIP 위반
    private final MemberRepository memberRepository;

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
}
