package MySpringStudy.core.v5.member;


public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
