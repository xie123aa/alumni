package george.xie.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Message {
    private int id;
    private Timestamp creattime;
    private byte look;
    private UserEntity userEntity;
    private UserEntity cuid;//文章的发布者
    private Content content;
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getCuid() {
        return cuid;
    }

    public void setCuid(UserEntity cuid) {
        this.cuid = cuid;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
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
    @Column(name = "creattime")
    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    @Basic
    @Column(name = "look")
    public byte getLook() {
        return look;
    }

    public void setLook(byte look) {
        this.look = look;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (look != message.look) return false;
        if (creattime != null ? !creattime.equals(message.creattime) : message.creattime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (creattime != null ? creattime.hashCode() : 0);
        result = 31 * result + (int) look;
        return result;
    }
}
