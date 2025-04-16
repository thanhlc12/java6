package com.example.de1.service.impl;

import com.example.de1.dto.NhanVienDTO;
import com.example.de1.entity.ChucVu;
import com.example.de1.entity.NhanVien;
import com.example.de1.exception.ResourceNotFoundException;
import com.example.de1.repository.ChucVuRepo;
import com.example.de1.repository.NhanVienRepo;
import com.example.de1.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepo nhanVienRepo;
    private final ChucVuRepo chucVuRepo;

    @Override
    public List<NhanVienDTO> findAll() {
        return nhanVienRepo.findAll().stream().
                map(nv -> new NhanVienDTO(
                        nv.getId(),
                        nv.getMaNhanVien(),
                        nv.getHoTen(),
                        nv.getGioiTinh(),
                        nv.getNgaySinh(),
                        nv.getChucVu().getMaChucVu(),
                        nv.getChucVu().getTenChucVu()
                )).collect(Collectors.toList());
    }

    @Override
    public Page<NhanVienDTO> getAllPage(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<NhanVien> nhanVienPage = nhanVienRepo.findAll(pageable);
        return nhanVienPage.map(nhanVien -> new NhanVienDTO(
                nhanVien.getId(),
                nhanVien.getMaNhanVien(),
                nhanVien.getHoTen(),
                nhanVien.getGioiTinh(),
                nhanVien.getNgaySinh(),
                nhanVien.getChucVu().getMaChucVu(),
                nhanVien.getChucVu().getTenChucVu()
        ));
    }

    @Override
    public NhanVien addNhanVien(NhanVienDTO nhanVienDTO) {
        if (nhanVienDTO.getMaChucVu() == null) {
            throw new IllegalArgumentException("Chức vụ không được để trống");
        }

        ChucVu chucVu = chucVuRepo.findByMaChucVu(nhanVienDTO.getMaChucVu())
                .orElseThrow(() -> new RuntimeException("Chức vụ không tồn tại"));

        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVienDTO, nhanVien);
        nhanVien.setChucVu(chucVu);

        return nhanVienRepo.save(nhanVien);
    }

    @Override
    public NhanVien findByMa(String ma) {
        return nhanVienRepo.findByMaNhanVien(ma).orElseThrow(() -> new RuntimeException("Khong tim thay ma nhan vien: " + ma));
    }

    @Override
    public NhanVien updateNhanVien(NhanVienDTO nhanVienDTO, Integer id) {
        NhanVien nhanVien = nhanVienRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay ma nhan vien: " + id));
        BeanUtils.copyProperties(nhanVienDTO, nhanVien);
        if (nhanVienDTO.getMaChucVu() != null) {
            ChucVu chucVu = chucVuRepo.findByMaChucVu(nhanVienDTO.getMaChucVu()).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay chuc vu voi ma: " + nhanVienDTO.getMaChucVu()));
            nhanVien.setChucVu(chucVu);
        }
        return nhanVienRepo.save(nhanVien);
    }


}
