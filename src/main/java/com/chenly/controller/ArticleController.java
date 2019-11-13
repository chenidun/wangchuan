package com.chenly.controller;

import com.chenly.constand.WebCodeEnum;
import com.chenly.dto.WebResult;
import com.chenly.model.Article;
import com.chenly.service.ArticleService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @author wangchuan
 * @date 2019/11/12.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    @ResponseBody
    public WebResult<Article> add(@RequestBody Article article) {
        WebResult<Article> result = WebResult.build(WebCodeEnum.REQUEST_SUCCESS, null);
        WebResult<Article> webResult = articleService.create(article);
        result.setData(webResult.getData());
        return result;
    }

    @GetMapping("/getList")
    @ResponseBody
    public WebResult<List<Article>> getList(HttpServletRequest request) {
        WebResult<List<Article>> result = WebResult.build(WebCodeEnum.REQUEST_SUCCESS, null);
        WebResult<List<Article>> webResult = articleService.list();
        result.setData(webResult.getData());
        request.setAttribute("articleList", result.getData());
        return result;
    }

    /*@GetMapping("/getList")
//    @ResponseBody
    public String getList(ModelMap mapMode) {
        WebResult<List<Article>> webResult = articleService.list();
        mapMode.put("articleList",webResult.getData());
        return "../webapp/main/list-article.jsp";
    }*/
}
