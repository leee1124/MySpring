package MySpringStudy.core.member.v1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    //HashMap은 동시성 이슈가 가능함 -> ConcurrentHashMap

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
