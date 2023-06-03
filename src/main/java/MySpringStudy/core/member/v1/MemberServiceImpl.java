package MySpringStudy.core.member.v1;

public class MemberServiceImpl implements MemberService{
    /**
     * OCP와 DIP를 위반함 => 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존함
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
