package com.example.de1.repository;

import com.example.de1.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, Integer> {
    Optional<ChucVu> findByMaChucVu(String maChucVu);
}
