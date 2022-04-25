package chatbot.main.dto;

public class MemberDTO {

    private Long mno;
    private String id;
    private String password;
    private String name;
    private String mobile;

    public MemberDTO() {
    }

    public MemberDTO(String id, String password, String name, String mobile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
    }

    public MemberDTO(Long mno, String id, String password, String name, String mobile) {
        this.mno = mno;
        this.id = id;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
