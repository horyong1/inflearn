package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
* */

public class MemberRepository {
    //싱글톤으로 생성해서 static 지워도 상관없음
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();
    //싱클톤으로 만들땐 private 로 막아줘야함

    public static MemberRepository getInstance(){
        return instance;
    }

    private  MemberRepository(){

    }
    // 아이디 저장
    public Member save(Member member){
        member.setId(++sequence);   // 시퀀스값 하나 증가시킴
        store.put(member.getId(), member); // 아이디저장
        return member;
    }
    // 회원 아이디 찾기
    public Member findById(Long id){
        return store.get(id);
    }
    // 모든 회원 찾기
    public List<Member> findAll(){
        // store 값을 직접적으로 접근하지않고 ArrayList 에 넣어서 보냄
        return new ArrayList<>(store.values());
    }
    // 모두 지우기
    public void clearStore(){
        store.clear();
    }
}
