package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_reply")
public class Reply implements Serializable {
    @Id
    private Integer id;

    /**
     * 评论ID
     */
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 回复目标ID
     */
    @Column(name = "reply_id")
    private Integer replyId;

    @Column(name = "reply_type")
    private String replyType;

    private String content;

    @Column(name = "from_uid")
    private String fromUid;

    @Column(name = "to_uid")
    private String toUid;

    @Column(name = "to_name")
    private String toName;

    @Column(name = "from_name")
    private String fromName;

    @Column(name = "create_date")
    private Date createDate;

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
     * 获取评论ID
     *
     * @return comment_id - 评论ID
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论ID
     *
     * @param commentId 评论ID
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取回复目标ID
     *
     * @return reply_id - 回复目标ID
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * 设置回复目标ID
     *
     * @param replyId 回复目标ID
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * @return reply_type
     */
    public String getReplyType() {
        return replyType;
    }

    /**
     * @param replyType
     */
    public void setReplyType(String replyType) {
        this.replyType = replyType == null ? null : replyType.trim();
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

    /**
     * @return from_uid
     */
    public String getFromUid() {
        return fromUid;
    }

    /**
     * @param fromUid
     */
    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }

    /**
     * @return to_uid
     */
    public String getToUid() {
        return toUid;
    }

    /**
     * @param toUid
     */
    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    /**
     * @return to_name
     */
    public String getToName() {
        return toName;
    }

    /**
     * @param toName
     */
    public void setToName(String toName) {
        this.toName = toName == null ? null : toName.trim();
    }

    /**
     * @return from_name
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * @param fromName
     */
    public void setFromName(String fromName) {
        this.fromName = fromName == null ? null : fromName.trim();
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
}