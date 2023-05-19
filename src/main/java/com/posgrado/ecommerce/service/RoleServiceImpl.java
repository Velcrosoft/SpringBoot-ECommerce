package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }
}
