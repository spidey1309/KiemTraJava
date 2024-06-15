package com.example.minhquan.repository;

import com.example.minhquan.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien searchNhanVienByTenNV(String keyword);
}
