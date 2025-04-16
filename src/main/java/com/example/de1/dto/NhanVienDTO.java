package com.example.de1.dto;

import com.example.de1.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@Data
public class NhanVienDTO {
    private Integer id;

    @NotBlank(message = "Ma nhan vien khong duoc de trong")
    private String maNhanVien;

    @NotBlank(message = "Ho ten nhan vien khong duoc de trong")
    private String hoTen;

    @NotNull(message = "Gioi tinh khong duoc de trong")
    private Boolean gioiTinh;

    @NotNull(message = "Ngay sinh khong duoc de trong")
    @Past(message = "Ngay sinh phai trong qua khu")
    private Date ngaySinh;

    private String maChucVu;

    private String tenChucVu;

    public NhanVienDTO(Integer id, String maNhanVien, String hoTen, Boolean gioiTinh, Date ngaySinh, String maChucVu, String tenChucVu) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }
}
