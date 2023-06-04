package fit.hutech.nguyenquangvinh.controller;

import fit.hutech.nguyenquangvinh.enity.NhanVien;
import fit.hutech.nguyenquangvinh.services.NhanVienService;
import fit.hutech.nguyenquangvinh.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhansu")
public class NhanSuController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", nhanViens);
        model.addAttribute("title", "List Nhan Vien");
        return "nhansu/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "nhansu/add";
    }
    @PostMapping("/add")
    public String addBook( @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhansu";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("nhanvien")NhanVien updateNhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/edit";
        }
        nhanVienService.updateBook(updateNhanVien);
        return "redirect:/nhansu";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        nhanVienService.deleteBook(id);
        return "redirect:/nhansu";
    }
}
