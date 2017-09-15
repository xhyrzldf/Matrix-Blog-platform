package com.matrix.spring.boot.esblog.domain.es;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;
/**
* <h1>class_name: EsBlog</h1>
* <ul>describe: es文档pojo</ul>
* <ul>create_user: LDF(xhyrzldf@foxmail.com)</ul>
* <ul>create_date: 2017/9/15 0015</ul>
* <ul>create_time: 下午 10:37</ul>
**/
@Document(indexName = "blog", type = "blog" )
public class EsBlog implements Serializable {

    private static final long serialVersionUID = -8626905605079815177L;

    @Id// primary Key
    private String id;

    private String title;

    private String summary;

    private String content;

    protected EsBlog() {//jpa 规范要求,防止直接使用
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public EsBlog setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EsBlog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public EsBlog setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EsBlog setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "EsBlog{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", summary='" + summary + '\'' + ", content='" + content + '\'' + '}';
    }
}
