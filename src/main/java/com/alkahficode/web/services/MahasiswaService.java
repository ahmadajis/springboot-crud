package com.alkahficode.web.services;


import com.alkahficode.web.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

    List <Mahasiswa> Listmahasiswa();

    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa getIdMahasiswa(Integer id);

    void hapus (Integer id);
}
