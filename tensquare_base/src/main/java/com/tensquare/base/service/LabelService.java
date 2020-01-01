package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }
    public void update(Label label){
        labelDao.save(label);
    }
    public void deleteById(String Id){
        labelDao.deleteById(Id);
    }
    public List<Label> findSearch(Label label){
        return labelDao.findAll(new Specification<Label>() {
            /*
            * root, 跟对象，把条件封装到哪个对象中，where 类名id = 。。
            * query 封装查询条件 group by，order by
            * CriteriaBuilder 封装条件对象，如果放回null表示不需要任何条件
            * */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //create new list，存放所有条件
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname()!=null&&!"".equals(label.getLabelname())){
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%");// where labelname like "%..%"
                    list.add(predicate);
                }
                if(label.getState()!=null&&!"".equals(label.getState())){
                    Predicate predicate = criteriaBuilder.like(root.get("state").as(String.class),"%"+label.getState()+"%");// where labelname like "%..%"
                    list.add(predicate);
                }
                //new 一个数组作为最终返回值的条件
                Predicate[] arr = new Predicate[list.size()];
                //把list直接转成数组
                list.toArray(arr);
                return criteriaBuilder.and(arr);
            }
        });
    }
}
