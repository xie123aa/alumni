package george.xie.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {
    private String content;
    private int id;
    private Timestamp creatTime;
    private UserEntity userEntity;
    private Content content1;
    private UserEntity userEntity2;

    public UserEntity getUserEntity2() {
        return userEntity2;
    }

    public void setUserEntity2(UserEntity userEntity2) {
        this.userEntity2 = userEntity2;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Content getContent1() {
        return content1;
    }

    public void setContent1(Content content1) {
        this.content1 = content1;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "creat_time")
    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (creatTime != null ? !creatTime.equals(comment.creatTime) : comment.creatTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        return result;
    }
}
