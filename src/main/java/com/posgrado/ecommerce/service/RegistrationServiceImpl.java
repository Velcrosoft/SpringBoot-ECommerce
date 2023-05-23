package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.RegistrationRequest;
import com.posgrado.ecommerce.entity.ConfirmationToken;
import com.posgrado.ecommerce.entity.User;
import com.posgrado.ecommerce.exception.EmailAlreadyTaken;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

  private UserService userService;
  private RoleService roleService;
  private ConfirmationTokenService confirmationTokenService;

  @Override
  public String register(RegistrationRequest dto) {
    boolean existEmail = userService.existEmail(dto.getEmail());
    if (existEmail) {
      throw new EmailAlreadyTaken(dto.getEmail());
    }
    User user = new User();
    user.setFirstName(dto.getFirstName());
    user.setLastName(dto.getLastName());
    user.setAddress(dto.getAddress());
    user.setEmail(dto.getEmail());
    //TODO: Encrypt password
    user.setPassword(dto.getPassword());
    user.setRole(roleService.getByName("USER"));

    userService.create(user);

    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(
        token,
        LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15),
        user
    );

    confirmationTokenService.create(confirmationToken);

    //TODO: Send confirmation token by email
    return token;
  }
}
