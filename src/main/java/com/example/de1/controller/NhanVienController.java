package com.example.de1.controller;

import com.example.de1.dto.NhanVienDTO;
import com.example.de1.entity.NhanVien;
import com.example.de1.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    private final NhanVienService nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping
    public List<NhanVienDTO> findAll() {
        return nhanVienService.findAll();
    }

    @GetMapping("/page")
    public Page<NhanVienDTO> getAllPage(@RequestParam(defaultValue = "0") int page) {
        return nhanVienService.getAllPage(page);
    }

    @PostMapping
    public ResponseEntity<?> addNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        nhanVienService.addNhanVien(nhanVienDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNhanVien(@PathVariable Integer id, @RequestBody NhanVienDTO nhanVienDTO) {
        nhanVienService.updateNhanVien(nhanVienDTO, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ma}")
    public ResponseEntity<NhanVien> findByMa(@PathVariable String ma) {
        return ResponseEntity.ok(nhanVienService.findByMa(ma));
    }


}
