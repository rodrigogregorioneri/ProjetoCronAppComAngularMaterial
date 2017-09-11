package app.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;

/**
 * Classe que representa a camada de negócios de UserRoleBusiness
 * 
 * @generated
 **/
@Service("UserRoleBusiness")
public class UserRoleBusiness {

  private static final Logger log = LoggerFactory.getLogger(UserRoleBusiness.class);


  /**
   * Instância da classe UserRoleDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("UserRoleDAO")
  protected UserRoleDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public UserRole post(final UserRole entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    UserRole result = null;
    result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public UserRole put(final UserRole entity) throws Exception {
    // begin-user-code  
    // end-user-code
    UserRole result = null;
    result = repository.saveAndFlush(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public void delete(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    UserRole entity = this.get(id);
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public UserRole get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    UserRole result = repository.findOne(id);
    // begin-user-code
    // end-user-code
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<UserRole> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<UserRole> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<UserRole> findByUser( User user, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<UserRole> result = repository.findByUser( user, pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<UserRole> findByEmail( java.lang.String email, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<UserRole> result = repository.findByEmail( email, pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<UserRole> findByLogin( java.lang.String login, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<UserRole> result = repository.findByLogin( login, pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<UserRole> findByRole( java.lang.String roleid, Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<UserRole> result = repository.findByRole( roleid, pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Foreign Key User
   * @generated
   */
  public Page<UserRole> findUserRolesByUser(java.lang.String instanceId, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<UserRole> result = repository.findUserRolesByUser(instanceId, pageable);
    // begin-user-code  
    // end-user-code        
    return result;
  }
  
  /**
   * Foreign Key Role
   * @generated
   */
  public Page<UserRole> findUserRolesByRole(java.lang.String instanceId, Pageable pageable) {
    // begin-user-code
    // end-user-code  
    Page<UserRole> result = repository.findUserRolesByRole(instanceId, pageable);
    // begin-user-code  
    // end-user-code        
    return result;
  }
  
}