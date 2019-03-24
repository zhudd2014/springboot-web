package com.szxfd.springboot.web.entity;

/**
 * 抽奖活动
 */
public class Lottery {

    private int id;
    private String title;
    private String banner;
    private String desc;
    private int open_type;
    private String open_date;
    private int open_participator_num;
    private String sponsor;
    private int status;
    private String award;//奖项
    private String create_time;
    private String update_time;
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
