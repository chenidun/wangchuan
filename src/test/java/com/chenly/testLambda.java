package com.chenly;

import com.chenly.model.Article;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangchuan
 * @date 2019/12/5.
 */
public class testLambda {
    @Test
    public void testLambda() {
        Article article1 = new Article();
        article1.setId(1);
        article1.setTitle("title1");
        article1.setContent("content1");
        Article article2 = new Article();
        article2.setId(2);
        article2.setTitle("title2");
        article2.setContent("content2");
        Article article3 = new Article();
        article3.setId(3);
        article3.setTitle("title3");
        article3.setContent("content3");
        List<Article> articles = new ArrayList<Article>(){{add(article1);add(article2);add(article3);}};



        // test filter
        List<Article> collect = articles.stream().filter(article -> article.getId() >= 2).collect(Collectors.toList());
        List<Integer> ids = articles.stream().filter(article -> article.getId() >= 2).map(article -> {return article.getId();}).collect(Collectors.toList());
        List<Integer> ids1 = articles.stream().filter(article -> article.getId() >= 2).map(Article::getId).collect(Collectors.toList());
        // list--》map
//        articles.stream().filter(article -> article.getId() >= 2).map(article -> new HashMap<Integer, Article>(article.getId(), article))




    }
}
