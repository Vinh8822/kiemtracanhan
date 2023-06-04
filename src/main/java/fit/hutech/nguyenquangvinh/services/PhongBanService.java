package fit.hutech.nguyenquangvinh.services;

import fit.hutech.nguyenquangvinh.enity.PhongBan;
import fit.hutech.nguyenquangvinh.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
/*    public PhongBan getCategoryById(Long id){
        Optional<PhongBan> optionalCategory = phongBanRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        } else {
            throw new RuntimeException("Category Not Found");
        }
    }*/
    public void addPhongBan(PhongBan newCategory){
        phongBanRepository.save(newCategory);
    }
    public PhongBan savePhongBan(PhongBan category) { return phongBanRepository.save(category);}
    public void updateCategory(PhongBan category){
        phongBanRepository.save(category);
    }
    /*public void deleteCategory(String id) {phongBanRepository.deleteById(id);}*/
}
