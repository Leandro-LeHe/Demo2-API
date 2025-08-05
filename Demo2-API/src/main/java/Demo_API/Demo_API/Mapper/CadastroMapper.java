package Demo_API.Demo_API.Mapper;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import org.modelmapper.ModelMapper;

public class CadastroMapper {

    public static CadastroEntity toUsuario(DtoCadastro dtoCadastro) {
        return new ModelMapper().map(dtoCadastro, CadastroEntity.class);

    }

    public static UsuarioResponseDto toDto(CadastroEntity assistido) {
        return new ModelMapper().map(assistido, UsuarioResponseDto.class);
    }

}