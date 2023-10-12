package Service;

import Dao.PromotionDao;
import Model.Promotion;
import java.util.List;

public class PromotionService {

    public Promotion getById(int id) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.get(id);
    }

    public List<Promotion> getPromotions() {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.getAll(" prom_id asc");
    }

    public Promotion addNew(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.save(editedPromotion);
    }

    public Promotion update(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.update(editedPromotion);
    }

    public int delete(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.delete(editedPromotion);
    }
}
