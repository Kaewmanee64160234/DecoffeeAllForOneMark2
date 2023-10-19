package TestService;

import Dao.CheckMaterialDao;
import Model.CheckMaterial;

public class TestCheckMaterial {

    public static void main(String[] args) {
        CheckMaterialDao cm = new CheckMaterialDao();

        CheckMaterial cmk = cm.get(1);
        System.out.println(cmk.toString());

        CheckMaterial cc = new CheckMaterial(1);
        cm.save(cc);

        for (CheckMaterial arg : cm.getAll()) {
            System.out.println(arg.toString());

        }

    }
}
