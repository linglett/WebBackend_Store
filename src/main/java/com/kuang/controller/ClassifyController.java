package com.kuang.controller;

import com.kuang.pojo.Classify;
import com.kuang.service.ClassifyService;
import javafx.collections.ObservableList;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.jar.JarOutputStream;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    @Qualifier("ClassifyServicelmpl")
    private ClassifyService classifyService;

    @ResponseBody
    @RequestMapping("/getClassify")
    public List<Classify> getClassify(Model model,String iniClassify){
        System.out.println("getClassify:"+iniClassify);
        if(iniClassify.equals("start")){
            List<Classify> classifies= classifyService.queryClassifyByParentId();
            System.out.println(classifies);
            System.out.println("classifyIsOk");
            return classifies;
        }
      return null;
    }
}
