package com.dkey.controllers;

import com.dkey.entities.Admin;
import com.dkey.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PutMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/{username}")
    public Admin getAdminById(@PathVariable String username) {
        return adminService.getAdminByUsername(username);
    }

    @DeleteMapping("/{username}")
    public void deleteAdminByUsername(@PathVariable String username) {
        adminService.deleteAdmin(username);
    }

    @PostMapping
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    // learn rest template
    @GetMapping("/mock/{id}")
    public Song getRestTemplate(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:4000/song/" + id;
        return restTemplate.getForEntity(resourceUrl, Song.class).getBody();
    }
}
// class for learn rest template


class Song{
    private Integer id;
    private String title;
    private String songWriter;

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }
}
