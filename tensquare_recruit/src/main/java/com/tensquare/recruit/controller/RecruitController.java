package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/search/recommend", method = RequestMethod.GET)
    public Result recommend(){
        return new Result(true, StatusCode.OK,"Successful Get", recruitService.recommend());
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/search/newlist",method = RequestMethod.GET)
    public Result newList(){
        return new Result(true, StatusCode.OK,"Successful Get", recruitService.newList());
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"Successful Get", recruitService.findAll());
    }
    @RequestMapping(method = RequestMethod.GET)
    public Result findById(String id){
        return new Result(true, StatusCode.OK,"Successful Get", recruitService.findById(id));
    }


    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap,@PathVariable int page,@PathVariable int size){
        Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK,"Successful POST", new PageResult<Recruit>(pageList.getTotalElements(),pageList.getContent()));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap){
        return new Result(true, StatusCode.OK,"Successful POST", recruitService.findSearch(searchMap) );
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Recruit recruit){
        recruitService.add(recruit);
        return new Result(true,StatusCode.OK,"Successful POST");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result Update(@RequestBody Recruit recruit,@PathVariable String id){
        recruit.setId(id);
        recruitService.add(recruit);
        return new Result(true,StatusCode.OK,"Successful PUT");
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        recruitService.deleteById(id);
        return new Result(true,StatusCode.OK,"Successful DELETE");
    }

}
