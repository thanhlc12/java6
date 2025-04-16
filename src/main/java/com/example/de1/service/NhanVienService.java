package com.example.de1.service;

import com.example.de1.dto.NhanVienDTO;
import com.example.de1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhanVienService {
    List<NhanVienDTO> findAll();

    Page<NhanVienDTO> getAllPage(int page);

    NhanVien addNhanVien(NhanVienDTO nhanVienDTO);

    NhanVien findByMa(String ma);

    NhanVien updateNhanVien(NhanVienDTO nhanVienDTO, Integer id);

    void deleteNhanVien(Integer id);
}
