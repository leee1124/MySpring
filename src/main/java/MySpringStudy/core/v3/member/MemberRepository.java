package MySpringStudy.core.v3.member;


public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
