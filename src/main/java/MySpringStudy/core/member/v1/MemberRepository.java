package MySpringStudy.core.member.v1;


public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
