package com.chenly.service.impl;

import com.chenly.constand.WebCodeEnum;
import com.chenly.dao.ArticleMapper;
import com.chenly.dto.WebResult;
import com.chenly.model.Article;
import com.chenly.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/11/12.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 添加 纪事
     * @return
     */
    @Override
    public WebResult<Article> create(Article article) {
        WebResult<Article> ret = WebResult.build(WebCodeEnum.REQUEST_SUCCESS, null);
        int i = articleMapper.insertSelective(article);
        ret.setData(article);
        return ret;
    }

    /**
     * 查询纪事列表
     * @return
     */
    @Override
    public WebResult<List<Article>> list() {
        WebResult<List<Article>> ret = WebResult.build(WebCodeEnum.REQUEST_SUCCESS, null);
        List<Article> articleList = articleMapper.selectList();
        ret.setData(articleList);
        return ret;
    }
}
