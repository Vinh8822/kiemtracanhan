package fit.hutech.nguyenquangvinh.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "ma_phong")
    private String ma_phong;
    @Column(name = "ten_phong")
    private String ten_phong;
    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
