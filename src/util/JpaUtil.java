package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf = null;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("PersistenceEComJPA");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}

