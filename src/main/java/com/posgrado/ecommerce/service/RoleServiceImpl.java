package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.RoleDto;
import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.mapper.RoleMapper;
import com.posgrado.ecommerce.repository.RoleRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;
  private RoleMapper roleMapper;

  @Override
  public Role create(RoleDto dto) {
    Role role = roleMapper.fromDto(dto);
    return roleRepository.save(role);
  }

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }
}
