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
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(length = 2)
    private String MaPhong;
    @Column(length = 30)
    private String name;
}
