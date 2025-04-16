package com.example.de1.repository;

import com.example.de1.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
    Optional<NhanVien> findByMaNhanVien(String ma);
}
