package Hello.demo.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // Initializing a variable called store, that can hold key-value paired elements, which is HashMap
    // Initially, it's empty.

    private static long sequence = 0L;
    // private: only MemberRepository can see variable `sequence`
    // static : the `sequence` variable belongs to the class, MemberRepository, itself, not the instances of the class.
    // long   : 64-bit signed integer data ( 2^63 < long < 2^63 - 1 )
    // 0L     : 0 long value

    // singleton purpose: creates a single instance of the `MemberRepository` class.
    private static final MemberRepository instance = new MemberRepository();

    // getInstance() method returns the single instance of `MemberRepository` class that was instantiated above.
    // This method can be used publicly to refer to the instance inside this class.
    public static MemberRepository getInstance() {
        return instance;
    }

    // This line prevents instantiation of the class from outside, enforcing the singleton pattern.
    private MemberRepository() {
    }

    // save() method takes in a Member type argument that does not have id value as a parameter.
    // This method can be used publicly to store the member instance of the Member class to the `MemberRepository` class' single instance.
    public Member save(Member member) {
        member.setId(++sequence);                       // sets the value of the id key as the sequence + 1(like auto-increment)
        store.put(member.getId(), member);              // add an element that has id of the member as the id, and the member instance as the member to the store HashMap
        return member;                                  // returns member instance with id value
    }

    // findById() method returns store's element that has id value
    public Member findById(Long id) {
        return store.get(id);
    }

    // findAll() method returns all the elements of the store HashMap
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
