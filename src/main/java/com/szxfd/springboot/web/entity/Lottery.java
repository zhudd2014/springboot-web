package com.szxfd.springboot.web.entity;

import java.sql.Timestamp;

/**
 * 抽奖活动
 */
public class Lottery {

    private int id;
    /**
     * 活动能够标题
     */
    private String title;
    /**
     * 活动图片
     */
    private String banner;
    /**
     * 活动图片
     */
    private String desc;
    /**
     * 开奖方式：0-手动开奖，1-按时间开奖，2-按人数开奖
     */
    private int open_type;
    /**
     * 按时间开奖时，开奖日期时间
     */
    private String open_date;
    private Timestamp open_date_timestamp;
    /**
     * 按人数开奖时，开奖人数
     */
    private int open_participator_num;
    /**
     * 赞助者
     */
    private String sponsor;
    /**
     * 开奖状态：0-未开始，1-待开奖，已开奖
     */
    private int status;
    /**
     * 奖项
     */
    private String award;
    /**
     * 创建时间
     */
    private String create_time;
    /**
     * 更新时间
     */
    private String update_time;
    /**
     * 是否逻辑删除
     */
    private boolean is_delete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getOpen_type() {
        return open_type;
    }

    public void setOpen_type(int open_type) {
        this.open_type = open_type;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public Timestamp getOpen_date_timestamp() {
        return open_date_timestamp;
    }

    public void setOpen_date_timestamp(Timestamp open_date_timestamp) {
        this.open_date_timestamp = open_date_timestamp;
    }

    public int getOpen_participator_num() {
        return open_participator_num;
    }

    public void setOpen_participator_num(int open_participator_num) {
        this.open_participator_num = open_participator_num;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", banner='" + banner + '\'' +
                ", desc='" + desc + '\'' +
                ", open_type=" + open_type +
                ", open_date='" + open_date + '\'' +
                ", open_participator_num=" + open_participator_num +
                ", sponsor='" + sponsor + '\'' +
                ", status=" + status +
                ", award='" + award + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }
}
