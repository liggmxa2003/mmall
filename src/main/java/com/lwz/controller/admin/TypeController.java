package com.lwz.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lwz.pojo.Type;
import com.lwz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeService typeService;

    //查询展示分类页数据
    @GetMapping("/types")
    public String types(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){
        // 启动分页功能，设置当前页为pagenum，每页显示5条记录
        PageHelper.startPage(pagenum, 5);
        List<Type> allType = typeService.getAllType();
        //得到分页结果对象
        PageInfo<Type> pageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String toAddType(Model model){
        model.addAttribute("type", new Type());  //返回一个type对象给前端th:object
        return "admin/types-input";
    }

    //  编辑
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    //新增
    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if (t != null){
            attributes.addFlashAttribute("msg", "不能添加重复分类");
            return "redirect:/admin/types/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
        }
        typeService.saveType(type);
        return "redirect:/admin/types";//不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }
    //修改
    @PostMapping("/types/{id}")
    public String editType(@PathVariable Long id, Type type, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if (t != null){
            attributes.addFlashAttribute("msg", "不能修改重复分类");
            return "redirect:/admin/types/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        typeService.updateType(type);
        return "redirect:/admin/types";  //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }
    //删除
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/types";
    }
}
