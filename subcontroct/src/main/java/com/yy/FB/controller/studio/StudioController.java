package com.yy.FB.controller.studio;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.FB.config.RestResult;
import com.yy.FB.config.ResultGenerator;
import com.yy.FB.entity.User;
import com.yy.FB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/studio")
public class StudioController {
    @Autowired
    UserService userService;
    @Autowired
    ResultGenerator generator;

        //  工作室注册
        @PostMapping("/register")
        public RestResult register(HttpServletRequest request) throws ParseException {

        User user = new User();
        user.setUsername(request.getParameter("username"));//用户名
        user.setPassword(request.getParameter("password"));//密码
        user.setUnitName(request.getParameter("unitName"));//单位名称
        user.setEmail(request.getParameter("email"));//邮箱
        user.setPhone(request.getParameter("phone"));//联系电话
        user.setRole(Integer.valueOf(request.getParameter("role")));//角色(0,1,2)
        user.setDescription(request.getParameter("description"));//企业或工作室描述
        user.setImage(request.getParameter("image"));//头像
        user.setAuditStatus(Integer.valueOf(request.getParameter("auditStatus")));//审核状态(0,1,2)
        user.setEstablishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("establishedTime")));//成立时间
        user.setEvaluateDemand(Float.parseFloat(request.getParameter("evaluateDemand")));//需求指标评分
        user.setEvaluateAbility(Float.parseFloat(request.getParameter("evaluateAbility")));//能力指标评分
        user.setEvaluatePlan(Float.parseFloat(request.getParameter("evaluatePlan")));//计划指标评分
        user.setTypeId(Integer.valueOf(request.getParameter("typeId")));//擅长类型
        user.setNums(Integer.valueOf(request.getParameter("nums")));//服务总数
        user.setBalance(Double.parseDouble(request.getParameter("balance")));//余额
        user.setDeleted(Integer.valueOf(request.getParameter("deleted")));//逻辑删除
        user.setVersion(Integer.valueOf(request.getParameter("version")));//乐观锁
        user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("createTime")));//创建时间
        user.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("updateTime")));//修改时间
        String username = user.getUsername();
        System.out.println(username);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> list = userService.list(wrapper);
        if (!list.isEmpty()) {
            System.out.println("用户名重复,请重新输入");
            return generator.getFailResult("用户名重复,请重新输入");

        }
        boolean save = userService.save(user);
        if (save) {
            return generator.getSuccessResult("注册成功");
        } else {
            return generator.getFailResult("注册失败!!");
        }







    }


}
