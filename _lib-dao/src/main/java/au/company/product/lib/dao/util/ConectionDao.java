package au.company.product.lib.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ConectionDao {
    @PersistenceContext
    protected EntityManager entityManager;
}
