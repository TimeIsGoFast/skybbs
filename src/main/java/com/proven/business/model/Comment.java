package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_comment")
public class Comment implements Serializable {
    @Id
    private Integer id;

    @Column(name = "title_id")
    private Integer titleId;

    @Column(name = "detail_id")
    private Integer detailId;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    private String remark;

    @Column(name = "link_num")
    private Integer linkNum;

    @Column(name = "tread_num")
    private Integer treadNum;

    @Column(name = "create_name")
    private String createName;

    private String comment;

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
     * @return title_id
     */
    public Integer getTitleId() {
        return titleId;
    }

    /**
     * @param titleId
     */
    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    /**
     * @return detail_id
     */
    public Integer getDetailId() {
        return detailId;
    }

    /**
     * @param detailId
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return link_num
     */
    public Integer getLinkNum() {
        return linkNum;
    }

    /**
     * @param linkNum
     */
    public void setLinkNum(Integer linkNum) {
        this.linkNum = linkNum;
    }

    /**
     * @return tread_num
     */
    public Integer getTreadNum() {
        return treadNum;
    }

    /**
     * @param treadNum
     */
    public void setTreadNum(Integer treadNum) {
        this.treadNum = treadNum;
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
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}