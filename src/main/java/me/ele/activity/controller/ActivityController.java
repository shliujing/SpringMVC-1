package me.ele.activity.controller;

import me.ele.activity.model.ActivityEntity;
import me.ele.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by lj on 2016/12/13 0024.
 */
@Controller
public class ActivityController {

    // 自动装配
    @Autowired
    private ActivityRepository activityRepository;

    // 首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "activity/index";
    }

    // 活动管理
    @RequestMapping(value = "/activitys", method = RequestMethod.GET)
    public String activitys(ModelMap modelMap){
        // 找到activity表里面的所有记录
        List<ActivityEntity> activityEntityList = activityRepository.findAll();

        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("activityList", activityEntityList);

        // 返回pages目录下的activityManage.jsp
        return "activity/activityManage";
    }

    // 添加活动表单页面
    @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
    public String addActivity(){
        return "activity/addActivity";
    }

    // 添加活动处理
    @RequestMapping(value = "/addActivityPost", method = RequestMethod.POST)
    public String addActivityPost(@ModelAttribute("activity") ActivityEntity activityEntity){
        // 向数据库添加一个活动
        activityRepository.save(activityEntity);

        // 向数据库添加一个活动，并将内存中缓存区的数据刷新，立即写入数据库，之后才可以进行访问读取
//        activityRepository.saveAndFlush(activityEntity);

        // 返回重定向页面
        return "redirect:/activitys";
    }

    // 查看活动详细信息
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/showActivity/1 ，将匹配 activityId = 1
    @RequestMapping(value = "/showActivity/{activityId}", method = RequestMethod.GET)
    public String showActivity( @PathVariable("activityId") Integer activityId, ModelMap modelMap ){
        ActivityEntity activityEntity = activityRepository.findOne(activityId);
        modelMap.addAttribute("activity", activityEntity);
        return "activity/activityDetail";
    }

    // 更新活动信息页面
    @RequestMapping(value = "/updateActivity/{activityId}", method = RequestMethod.GET)
    public String updateActivity(@PathVariable("activityId") Integer activityId, ModelMap modelMap){
        ActivityEntity activityEntity = activityRepository.findOne(activityId);
        modelMap.addAttribute("activity", activityEntity);
        return "activity/updateActivity";
    }

    // 处理活动修改请求
    @RequestMapping(value = "/updateActivityPost", method = RequestMethod.POST)
    public String updateActivityPost(@ModelAttribute("activity") ActivityEntity activityEntity){
        activityRepository.updateActivity(
                activityEntity.getName(),
                activityEntity.getDate().toString(),
                activityEntity.getSpend(),
                activityEntity.getDepartment(),
                activityEntity.getId()
        );
        return "redirect:/activitys";
    }

    // 删除活动
    @RequestMapping(value = "/deleteActivity/{activityId}", method = RequestMethod.GET)
    public String deleteActivity(@PathVariable("activityId") Integer activityId){
        // 删除id为activityId的活动
        activityRepository.delete(activityId);
        // 立即刷新数据库
        activityRepository.flush();
        return "redirect:/activitys";
    }
}