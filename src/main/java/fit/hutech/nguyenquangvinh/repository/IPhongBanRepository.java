package fit.hutech.nguyenquangvinh.repository;

import fit.hutech.nguyenquangvinh.enity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, String> {
}
