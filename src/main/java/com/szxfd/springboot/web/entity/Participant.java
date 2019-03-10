/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Participant
 * Author:   admin
 * Date:     2019/3/10 21:27
 * Description: 活动参与人列表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈活动参与人列表〉
 *
 * @author admin
 * @create 2019/3/10
 * @since 1.0.0
 */
public class Participant {

    private int id;
    private int lottery_id;
    private String lottery_title;
    private int user_id;
    private String username;
    private int prize_level;
    private String jion_time;
    private String create_time;
    private String update_time;
    private String is_delete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLottery_id() {
        return lottery_id;
    }

    public void setLottery_id(int lottery_id) {
        this.lottery_id = lottery_id;
    }

    public String getLottery_title() {
        return lottery_title;
    }

    public void setLottery_title(String lottery_title) {
        this.lottery_title = lottery_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrize_level() {
        return prize_level;
    }

    public void setPrize_level(int prize_level) {
        this.prize_level = prize_level;
    }

    public String getJion_time() {
        return jion_time;
    }

    public void setJion_time(String jion_time) {
        this.jion_time = jion_time;
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

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", lottery_id=" + lottery_id +
                ", lottery_title='" + lottery_title + '\'' +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", prize_level=" + prize_level +
                ", jion_time='" + jion_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", is_delete='" + is_delete + '\'' +
                '}';
    }
}