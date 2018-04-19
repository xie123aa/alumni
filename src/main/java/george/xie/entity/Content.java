package george.xie.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Content {
    private Timestamp creatTime;
    private String imgurl;
    private String description;
    private String title;
    private int id;
    private int totalComment;
    private Timestamp finalComments;
    private int clickCount;
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Basic
    @Column(name = "creat_time")
    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Basic
    @Column(name = "imgurl")
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "total_comment")
    public int getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(int totalComment) {
        this.totalComment = totalComment;
    }

    @Basic
    @Column(name = "final_comments")
    public Timestamp getFinalComments() {
        return finalComments;
    }

    public void setFinalComments(Timestamp finalComments) {
        this.finalComments = finalComments;
    }

    @Basic
    @Column(name = "click_count")
    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        if (id != content.id) return false;
        if (totalComment != content.totalComment) return false;
        if (clickCount != content.clickCount) return false;
        if (creatTime != null ? !creatTime.equals(content.creatTime) : content.creatTime != null) return false;
        if (imgurl != null ? !imgurl.equals(content.imgurl) : content.imgurl != null) return false;
        if (description != null ? !description.equals(content.description) : content.description != null) return false;
        if (title != null ? !title.equals(content.title) : content.title != null) return false;
        if (finalComments != null ? !finalComments.equals(content.finalComments) : content.finalComments != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creatTime != null ? creatTime.hashCode() : 0;
        result = 31 * result + (imgurl != null ? imgurl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + totalComment;
        result = 31 * result + (finalComments != null ? finalComments.hashCode() : 0);
        result = 31 * result + clickCount;
        return result;
    }
}
