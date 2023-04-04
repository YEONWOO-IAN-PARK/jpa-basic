package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "TBR")    // DB의 TBR이라는 이름의 테이블과 연동

public class Member {

    @Id // PK매핑
    private Long id;
    
    @Column(name = "name", updatable = false)
    private String username;
    
    private Integer age;        // DB에 컬럼이 생성될때 가장 적합한 type으로 생성한다.
    
    @Enumerated(EnumType.STRING)    // 필수로 EnumType.STRING으로 설정한다.
    private RoleType roleType;
    
    @Temporal(TemporalType.TIMESTAMP)   // 자바와는 다르게 DB는 DATE, TIME, TIMESTAMP를 구분해서 사용하기 때문에 매핑정보를 주기위해 TIMESTAMP를 사용한다.
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob // 대용량 컨텐츠에 사용
    private String description;
    
    @Transient  // DB와 별개로 메모리 상에서만 사용할때 사용
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
