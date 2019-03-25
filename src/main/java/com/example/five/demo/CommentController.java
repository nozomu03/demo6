package com.example.five.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository cr;
    @Autowired
    private UserRepository ur;

    @GetMapping("/list")
    public List<Comment> list(){
        return this.cr.findAll();
    }

    @GetMapping("/view/{id}")
    public Comment view(@PathVariable Long id){
        return this.cr.findById(id).orElse(null);
    }

    @PostMapping("/list")
    public Comment add(@RequestBody Comment comment){
        return this.cr.save(comment);
    }

    @PutMapping("/update/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        return this.cr.findById(id)
            .map(found->{
                Optional.ofNullable(comment.getUserId()).orElse(found.getUserId());
                found.setComment(Optional.ofNullable(comment.getComment()).orElse(found.getComment()));
                return this.cr.save(found);
            })
            .orElse(null);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable Long id){
        for(Comment temp : this.cr.findAll()){
            if(temp.getId().equals(id)){
                this.cr.delete(temp);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/find/{name}")
    public List<Comment> findByUserName(@PathVariable Long name){
        //return this.cr.findByAuthor(name);
        return this.cr.findByUserId(name);
    }

    @GetMapping("/finduser/{userId}")
    public UserCommentPretocol findbyuser(@PathVariable Long id) {
        return this.ur.findById(id)
        .map(user -> new UserCommentPretocol(
                user,
                this.cr.findByUserId(id)
        ))
        .orElse(null);
    }
}
