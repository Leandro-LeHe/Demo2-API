package Demo_API.Demo_API.DTO.Mapper;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class CadastroMapper {
    // DTO para entity
    public static CadastroEntity toUsuario(DtoCadastro createDto) {
        return new ModelMapper().map(createDto, CadastroEntity.class);

    }

    //Entity to DTO
    public static UsuarioResponseDto toDto(CadastroEntity assistido) {
        String role = assistido.getRole().name().substring("ROLE_".length());
        PropertyMap<CadastroEntity, UsuarioResponseDto> props = new PropertyMap<CadastroEntity, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(assistido, UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<CadastroEntity> cadastros) {
        return cadastros.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }


}