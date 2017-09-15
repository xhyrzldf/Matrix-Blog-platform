package com.matrix.spring.boot.esblog.repository.es;

import com.matrix.spring.boot.esblog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
/**
* <h1>class_name: EsBlogRepository</h1>
* <ul>describe: EsBlog Repository 接口</ul>
* <ul>create_user: LDF(xhyrzldf@foxmail.com)</ul>
* <ul>create_date: 2017/9/15 0015</ul>
* <ul>create_time: 下午 10:45</ul>
**/
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 分页查询博客(去重)
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}
