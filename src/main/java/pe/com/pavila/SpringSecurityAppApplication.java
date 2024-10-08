package pe.com.pavila;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pe.com.pavila.entity.PermissionEntity;
import pe.com.pavila.entity.RoleEntity;
import pe.com.pavila.entity.RoleEnum;
import pe.com.pavila.entity.UserEntity;
import pe.com.pavila.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			/* CREATE PERMISSIONS */
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/* CREATE ROLES */
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissions(Set.of(
							createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissions(Set.of(
							createPermission, readPermission))
					.build();

			RoleEntity roleGuest = RoleEntity.builder()
					.roleEnum(RoleEnum.GUEST)
					.permissions(Set.of(
							readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissions(Set.of(
							createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			/* CREATE USERS */
			UserEntity userPedro = UserEntity.builder()
					.username("Pedro")
					.password("$2a$10$rISDcUwrOKnNkBPTMx4Ti.sgMeR7.JuPrW9xA8B8EFoV12tJjK6nS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("Daniel")
					.password("$2a$10$rISDcUwrOKnNkBPTMx4Ti.sgMeR7.JuPrW9xA8B8EFoV12tJjK6nS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.username("Andrea")
					.password("$2a$10$rISDcUwrOKnNkBPTMx4Ti.sgMeR7.JuPrW9xA8B8EFoV12tJjK6nS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleGuest))
					.build();

			UserEntity userAngy = UserEntity.builder()
					.username("Angy")
					.password("$2a$10$rISDcUwrOKnNkBPTMx4Ti.sgMeR7.JuPrW9xA8B8EFoV12tJjK6nS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userPedro, userDaniel, userAndrea, userAngy));

		};
	}

}
