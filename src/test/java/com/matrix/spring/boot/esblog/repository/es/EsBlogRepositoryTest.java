package com.matrix.spring.boot.esblog.repository.es;

import com.matrix.spring.boot.esblog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

/**
 * @Description
 * @Author Matrix[xhyrzldf@foxmail.com]
 * @Date 2017/9/17 0:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void setUp() throws Exception {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣的登鹳雀楼", "白日依山尽黄河入海流欲穷千里目更上一层楼"));
        esBlogRepository.save(new EsBlog("相思", "王维的相思", "红豆生南国春来发几枝愿君多采撷此物最相思"));
        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思", "床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() throws Exception {
        Pageable pageable = new PageRequest(0,20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        System.out.println("---------------------start---------------");
        for (EsBlog esBlog : page.getContent()) {
            System.out.println(esBlog.toString());
        }
        System.out.println("---------------------end---------------");

    }

}