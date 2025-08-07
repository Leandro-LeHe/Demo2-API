package Demo_API.Demo_API.DTO.Mapper;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CadastroMapper {
    // DTO para entity
    public static CadastroEntity toUsuario(DtoCadastro dtoCadastro) {
        return new ModelMapper().map(dtoCadastro, CadastroEntity.class);

    }
    //Entity to DTO
    public static UsuarioResponseDto toDto(CadastroEntity assistido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(assistido, UsuarioResponseDto.class);

    }

    public static List<UsuarioResponseDto> toListDto(List<CadastroEntity> cadastros) {
        return cadastros.stream().map(user -> toDto(user)).collect(Collectors.toList());

    }

}