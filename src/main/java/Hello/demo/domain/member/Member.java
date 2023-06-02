package Hello.demo.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;
    private String email;
    private String password;

    public Member() {   // 기본 생성자

    }

    public Member(String username, int age, String email, String password) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
