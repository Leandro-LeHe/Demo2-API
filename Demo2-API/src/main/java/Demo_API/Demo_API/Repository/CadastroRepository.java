package Demo_API.Demo_API.Repository;

import Demo_API.Demo_API.Model.CadastroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

// JpaRepository tem todos on metodos para trabalhar com banco de dados
public interface CadastroRepository extends JpaRepository<CadastroEntity,Long> {


    // (pode criar métodos personalizados)
   //List<AssistidosEntity> findByCidadeAndIdade(String cidade, int idade);

    Long id(Long id);

    Optional<CadastroEntity> findByUsername(String username);

    // Retorna diretamente o Role de um usuário pelo nome
    @Query("select u.role from CadastroEntity u where u.username = :nome")
    CadastroEntity.Role findRoleByNome(String nome);

        }



