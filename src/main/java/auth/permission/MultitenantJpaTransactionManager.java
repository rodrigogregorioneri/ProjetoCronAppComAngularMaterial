package auth.permission;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class MultitenantJpaTransactionManager extends JpaTransactionManager {
  private static final long serialVersionUID = 1L;
  
  @Autowired
  private TenantComponent tenantComponent;

  @Override
  protected void doBegin(Object transaction, TransactionDefinition definition) {
    super.doBegin(transaction, definition);
    final EntityManagerHolder emHolder = (EntityManagerHolder) TransactionSynchronizationManager
        .getResource(getEntityManagerFactory());
    final EntityManager em = emHolder.getEntityManager();

    try {
      if (tenantComponent != null && tenantComponent.getContextIds() != null) {
        for(String key: tenantComponent.getContextIds().keySet()) {
          em.setProperty(key, tenantComponent.getId(key));
        }
      }
    } catch(Exception e) {
      //
    }
  }

  @Override
  protected EntityManager createEntityManagerForTransaction() {
    return super.createEntityManagerForTransaction();
  }
}