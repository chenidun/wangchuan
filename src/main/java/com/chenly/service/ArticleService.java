package com.chenly.service;

import com.chenly.dto.WebResult;
import com.chenly.model.Article;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/11/12.
 */
public interface ArticleService {
    WebResult<Article> create(Article article);

    WebResult<List<Article>> list();
}
