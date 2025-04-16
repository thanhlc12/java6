package com.example.de1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_nhan_vien", unique = true, nullable = false)
    private String maNhanVien;

    @Column(name = "ho_ten")
    private String hoTen;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu", referencedColumnName = "id", nullable = false)
    private ChucVu chucVu;


}
