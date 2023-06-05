package MySpringStudy.core.v4.member;


public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
