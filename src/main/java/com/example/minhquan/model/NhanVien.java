package com.example.minhquan.model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    @Id
    @Column(length = 3)
    private String MaNV;
    @Column(length = 100)
    private String tenNV;
    @Column(length = 3)
    private String Phai;
    @Column(length = 200)
    private String NoiSinh;
    @ManyToOne
    @JoinColumn(name = "PhongBan_id")
    private PhongBan pb;
    private int Luong;
}
