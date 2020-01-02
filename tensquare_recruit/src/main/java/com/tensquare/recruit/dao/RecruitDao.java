package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaSpecificationExecutor<Recruit>, JpaRepository<Recruit,String> {
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);  //where state = ? order by createtime

    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);

}
