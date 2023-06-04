package fit.hutech.nguyenquangvinh.repository;

import fit.hutech.nguyenquangvinh.enity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}
