package Demo_API.Demo_API.Repository;

import Demo_API.Demo_API.Model.AssistidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//indica que vamos trabalhar com a classe AssistidosEntity e a chave primaria é um long
// JpaRepository tem todos on metodos para trabalhar com banco de dados
public interface AssistidosRepository extends JpaRepository<AssistidosEntity,Long> {
   // List<AssistidosEntity> BuscarId(Long id);

    Long id(Long id);
}
