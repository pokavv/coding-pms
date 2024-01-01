package com.dev.pms.service;

import com.dev.pms.domain.PostSearchCond;
import com.dev.pms.domain.PostVo;
import com.dev.pms.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public String getWriterInfo(PostVo postVo) {
        Long writerId = postVo.getWriterId();
        return postMapper.getWriter(writerId);
    }

    public List<PostVo> getPostList(PostSearchCond cond) {
        return postMapper.getPostsByCond(cond);
    }
}
