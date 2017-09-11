package app.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import app.entity.*;
import app.business.*;

/**
 * Controller para expor serviços REST de Role
 * 
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/security/Role")
public class RoleREST {

  /**
   * Classe de negócio para manipulação de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("RoleBusiness")
  private RoleBusiness roleBusiness;
  
  /**
   * @generated
   */
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;
  /**
   * @generated
   */
  @Autowired
  @Qualifier("UserRoleBusiness")
  private UserRoleBusiness userRoleBusiness;
  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public Role post(@Validated @RequestBody final Role entity) throws Exception {
    return roleBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Role put(@Validated @RequestBody final Role entity) throws Exception {
    return roleBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{roleId}")
  public Role put(@Validated @RequestBody final Role entity, @PathVariable("roleId") java.lang.String roleId) throws Exception {
    return roleBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{roleId}")
  public void delete(@PathVariable("roleId") java.lang.String roleId) throws Exception {
    roleBusiness.delete(roleId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public HttpEntity<PagedResources<Role>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(roleBusiness.list(pageable)), HttpStatus.OK);    
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{roleId}/UserRole")    
  public HttpEntity<PagedResources<UserRole>> findUserRole(@PathVariable("roleId") java.lang.String roleId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(roleBusiness.findUserRole(roleId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE, value="/{roleId}/UserRole/{userRoleId}")    
  public void deleteUserRole(@PathVariable("userRoleId") java.lang.String userRoleId) throws Exception {
    this.userRoleBusiness.delete(userRoleId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT, value="/{roleId}/UserRole")
  public UserRole putUserRole(@Validated @RequestBody final UserRole entity, @PathVariable("roleId") java.lang.String roleId) throws Exception {
    return this.userRoleBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST, value="/{roleId}/UserRole")
  public UserRole postUserRole(@Validated @RequestBody final UserRole entity, @PathVariable("roleId") java.lang.String roleId) throws Exception {
    Role role = this.roleBusiness.get(roleId);
    entity.setRole(role);
    return this.userRoleBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET,value="/{roleId}/User")
  public HttpEntity<PagedResources<User>> listUser(@PathVariable("roleId") java.lang.String roleId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(roleBusiness.listUser(roleId, pageable)), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST,value="/{roleId}/User")
  public Role postUser(@Validated @RequestBody final User entity, @PathVariable("roleId") java.lang.String roleId) throws Exception {
    UserRole newUserRole = new UserRole();

    Role role = this.roleBusiness.get(roleId);

    newUserRole.setUser(entity);
    newUserRole.setRole(role);
    
    this.userRoleBusiness.post(newUserRole);

    return newUserRole.getRole();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE,value="/{roleId}/User/{userId}")
  public void deleteUser(@PathVariable("roleId") java.lang.String roleId, @PathVariable("userId") java.lang.String userId) {
    this.roleBusiness.deleteUser(roleId, userId);
  }  


  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{roleId}")
  public Role get(@PathVariable("roleId") java.lang.String roleId) throws Exception {
    return roleBusiness.get(roleId);
  }

}
