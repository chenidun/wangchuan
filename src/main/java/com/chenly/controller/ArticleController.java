package com.chenly.controller;

import com.chenly.constand.WebCodeEnum;
import com.chenly.dto.WebResult;
import com.chenly.model.Article;
import com.chenly.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public WebResult add(@RequestBody Article article) {
        WebResult<Article> result = WebResult.build(WebCodeEnum.REQUEST_SUCCESS, null);
        WebResult<Article> webResult = articleService.create(article);
        result.setData(webResult.getData());
        return result;
    }
}
