package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 
* @ClassName: PostDetail  
* @author Administrator  
* @date 2019年7月18日
 */
@Table(name = "t_t_post_detail")
public class PostDetail implements Serializable {
    @Id
    private Integer id;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "attach_url")
    private String attachUrl;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "watch_number")
    private Integer watchNumber;

    @Column(name = "repeat_num")
    private Integer repeatNum;

    @Column(name = "attach_name")
    private String attachName;

    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return post_id
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * @return attach_url
     */
    public String getAttachUrl() {
        return attachUrl;
    }

    /**
     * @param attachUrl
     */
    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl == null ? null : attachUrl.trim();
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return create_name
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * @param createName
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * @return watch_number
     */
    public Integer getWatchNumber() {
        return watchNumber;
    }

    /**
     * @param watchNumber
     */
    public void setWatchNumber(Integer watchNumber) {
        this.watchNumber = watchNumber;
    }

    /**
     * @return repeat_num
     */
    public Integer getRepeatNum() {
        return repeatNum;
    }

    /**
     * @param repeatNum
     */
    public void setRepeatNum(Integer repeatNum) {
        this.repeatNum = repeatNum;
    }

    /**
     * @return attach_name
     */
    public String getAttachName() {
        return attachName;
    }

    /**
     * @param attachName
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}