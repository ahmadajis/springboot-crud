package com.alkahficode.web.controller;

import com.alkahficode.web.model.Mahasiswa;
import com.alkahficode.web.services.MahasiswaService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MahasiswaController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping("/index")
    public String MahasiswaList(Model model){
        model.addAttribute("mahasiswa",mahasiswaService.Listmahasiswa());
        return "mahasiswa";
    }

    @RequestMapping(value = "/formInput/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model){
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "formInput";
    }

    @RequestMapping(value = "/formInput/create", method = RequestMethod.POST)
    public String simpanDataMahasiswa(Model model, Mahasiswa mahasiswa){
        model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdate(mahasiswa));
        return "redirect:/index";
    }

    @RequestMapping(value = "/formEdit/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("mahasiswa", mahasiswaService.getIdMahasiswa(id));
        return "formInput";
    }
    @RequestMapping(value = "/mahasiswa/hapus/{id}")
    public String hapus(@PathVariable Integer id){
        mahasiswaService.hapus(id);
        return "redirect:/index";
    }
}
