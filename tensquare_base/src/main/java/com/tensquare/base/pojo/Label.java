package com.tensquare.base.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
    @Id
    private String id;
    private String labelname;
    private String state;
    private Long count;
    private Long fans;
    private String recommend;

    public void setId(String id) {
        this.id = id;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getId() {
        return id;
    }

    public String getLabelname() {
        return labelname;
    }

    public String getState() {
        return state;
    }

    public Long getCount() {
        return count;
    }

    public Long getFans() {
        return fans;
    }

    public String getRecommend() {
        return recommend;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id='" + id + '\'' +
                ", labelname='" + labelname + '\'' +
                ", state='" + state + '\'' +
                ", count=" + count +
                ", fans=" + fans +
                ", recommend='" + recommend + '\'' +
                '}';
    }
}
