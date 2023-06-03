package MySpringStudy.core.v1.member;


import MySpringStudy.core.v1.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
