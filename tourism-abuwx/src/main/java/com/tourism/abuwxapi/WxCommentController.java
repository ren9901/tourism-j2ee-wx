package com.tourism.abuwxapi;

import com.tourism.abuwx.domain.CommentTable;
import com.tourism.abuwx.service.ICommentTableService;
import com.tourism.common.core.controller.BaseController;
import com.tourism.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wxapi/")
public class WxCommentController extends BaseController {

    @Autowired
    private ICommentTableService commentService;

    /**
     * 查询评论内容通过景点id
     */
    @GetMapping(value = "commentListByJdID/{jdid}")
    public AjaxResult getCommentListByJdID(@PathVariable("jdid") Long jdid){
        List<CommentTable> list = commentService.getCommentListByJdID(jdid);
        return AjaxResult.success(list);
    }

    /**
     * 添加评论信息
     */
    @PostMapping("addComment")
    public AjaxResult addComment(@RequestBody CommentTable commentTable){
        return toAjax(commentService.insertCommentTable(commentTable));
    }

}
