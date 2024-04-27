package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.po.*;
import com.example.service.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    private IndexService indexService;
    @Resource
    private DetailService detailService;
    @Resource
    private DictService dictService;
    @Resource
    private ExperienceService experienceService;
    @Resource
    private LinksService linksService;
    @Resource
    private SourceService sourceService;




    @GetMapping("/")
    public String home(Model model) {
        getIndexValue(model);

        return "index";
    }

//    @GetMapping("/download")
//    public void downloadFile(@RequestParam("code") String code, HttpServletResponse response) {
//        // 根据code 查取dict 得到value，为路径，下载。
//        String filePath = getByCode(code);
//        Path path = Paths.get(filePath);
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition", "attachment; filename= " + path.getFileName()+"\"" );  // 设置下载文件的名称
//
//        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
//             OutputStream outputStream = response.getOutputStream()) {
//
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            // 处理文件不存在或读取错误等问题
//        }
//    }


    @GetMapping("/download")
    public void downloadFile(@RequestParam("code") String code, HttpServletResponse response) {
        String filePath = getByCode(code);
        if (filePath == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.reset();  // 清除可能存在的任何数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.setContentLength((int) file.length());  // 设置正确的内容长度

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    // 跳转 detail页面
    @GetMapping("/blog-detail/{id}")
    public String showBlogDetail(@PathVariable("id") Integer id, Model model) {
        getDetailValue(id,model);
        return "detail-white";
    }

    // 获取所需数据，并装填
    private void getIndexValue(Model model){
        QueryWrapper<SourcePO> sourceQuery = new QueryWrapper<>();
        sourceQuery.eq("state",1)
                .orderByAsc("sort");
        QueryWrapper<DetailPO> detailQuery = new QueryWrapper<>();
        detailQuery.eq("state",1)
                .orderByAsc("sort");
        QueryWrapper<ExperiencePO> experienceQuery = new QueryWrapper<>();
        experienceQuery.eq("state",1)
                .orderByAsc("sort");

        IndexPO index = indexService.getById(1);
        List<SourcePO> sources = sourceService.list(sourceQuery);
        List<SourcePO> webs = sources.stream().filter(po -> po.getType().equals("web")).toList();
        List<SourcePO> skills = sources.stream().filter(po -> po.getType().equals("skill")).toList();
        List<DetailPO> details = detailService.list(detailQuery);
        List<ExperiencePO> experiences = experienceService.list(experienceQuery);

        System.out.println(skills.isEmpty());

        model.addAttribute("index", index);
        model.addAttribute("webs", webs);
        model.addAttribute("skills", skills);
        model.addAttribute("details", details);
        model.addAttribute("experiences", experiences);

    }

    private void getDetailValue(Integer id, Model model){
        QueryWrapper<LinksPO> linksQuery = new QueryWrapper<>();
        linksQuery.eq("detail_id",id)
                .eq("state",1)
                .orderByAsc("sort");
        QueryWrapper<SourcePO> sourceQ = new QueryWrapper<>();
        sourceQ.eq("state",1).orderByAsc("sort");

        IndexPO index = indexService.getById(1);
        List<SourcePO> sources = sourceService.list(sourceQ);
        // 网站信息
        List<SourcePO> webs = sources.stream().filter(sourcePO -> sourcePO.getType().equals("web")).toList();
        List<LinksPO> links = linksService.list(linksQuery);
        // 图片轮播
        List<LinksPO> imgs = links.stream().filter(po -> po.getType().equals("image")).toList();
        // 项目地址
        List<LinksPO> projectLinks = links.stream().filter(po -> po.getType().equals("project")).toList();
        DetailPO detail = detailService.getById(id);

        model.addAttribute("index", index);
        model.addAttribute("webs", webs);
        model.addAttribute("imgs", imgs);
        model.addAttribute("project_links", projectLinks);
        model.addAttribute("detail", detail);
    }

    private String getByCode(String code){
        QueryWrapper<DictPO> query = new QueryWrapper<>();
        query.eq("code",code);
        return dictService.getOne(query).getValue();
    }

}
