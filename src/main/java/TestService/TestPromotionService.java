package TestService;

import Dao.PromotionDao;
import Model.Promotion;

public class TestPromotionService {

    public static void main(String[] args) {
        PromotionDao pd = new PromotionDao();
        for (Promotion promotion : pd.getAll()) {
            System.out.println(promotion);
        }

        // Add New Promotion
        Promotion P1 = new Promotion("2023-08-01", "HalloweenDay", 0, 5, 0, 0);
        pd.save(P1);
        for (Promotion promotion : pd.getAll()) {
            System.out.println(promotion);
        }

    }
}
