package com.example.minhquan.controller;

import com.example.minhquan.model.NhanVien;
import com.example.minhquan.service.NhanVienService;
import com.example.minhquan.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/NhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    // Display a list of all NhanVien
    @GetMapping
    public String showNhanVienList(Model model) {
        model.addAttribute("NhanVien", nhanVienService.getAllNhanVien());
        return "/NhanVien/NhanVien-list";
    }
    // For adding a new NhanVien
    @GetMapping("/add")
    public String showAddForm(Model model) {
        NhanVien nhanvien = new NhanVien();
        model.addAttribute("NhanVien", nhanvien);
//        model.addAttribute("PhongBan", phongBanService.getAllPhongBan());
        return "NhanVien/Them";
    }
    // Process the form for adding a new NhanVien
    @PostMapping("/add")
    public String addNhanVien( NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "/NhanVien/Them";
        }
        nhanVienService.addProduct(nhanVien);
        return "redirect:/NhanVien/NhanVien";
    }
    // For editing a NhanVien
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String MaNV, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(MaNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + MaNV));
        model.addAttribute("NhanVien", nhanVien);
        model.addAttribute("PhongBan", phongBanService.getAllPhongBan());
        return "/NhanVien/Sua-NV";
    }

    @PostMapping("/edit/{id}")
    public String updateNhanVien(@PathVariable("id") String MaNV, NhanVien nhanVien,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            nhanVien.setMaNV(MaNV); // Preserve the ID in case of errors
            model.addAttribute("PhongBan", phongBanService.getAllPhongBan());
            return "/NhanVien/Sua-NV";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/NhanVien/NhanVien";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/NhanVien/NhanVien";
    }
    // Search for products by name
    @GetMapping("/search")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("NhanVien", nhanVienService.searchNhanVienByTenNV(keyword));
        return "NhanVien/NhanVien-list";
    }
}

