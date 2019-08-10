package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.domain.SysLog;
import com.jxau.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;


    /**
     * 查询所有日志
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "4")Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogList= sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogList);

       mv.addObject("pageInfo",pageInfo);
       mv.setViewName("syslog-list");
        return mv;
    }

    /**
     *
     * 清空日志
     */

    @RequestMapping(path = "/delLog.do")
    public String delLog(){

        try {
            sysLogService.delLog();
        } catch (Exception e) {
            return "redirect:error.do";
        }
        return "redirect:findAll.do";
    }

    /**
     * 跳转出错界面
     * @return
     */
    @RequestMapping(path = "/error.do")
    public String error(){

        return "error";
    }


}
