package Demo_API.Demo_API.DTO.Mapper;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class CadastroMapper {

    // Reutiliza uma única instância do ModelMapper
    private static final ModelMapper mapper = new ModelMapper();

    // DTO → Entity
    public static CadastroEntity toUsuario(DtoCadastro createDto) {
        return mapper.map(createDto, CadastroEntity.class);
    }

    public static UsuarioResponseDto toDto(CadastroEntity assistido) {
        final String role = (assistido.getRole() != null)
                ? assistido.getRole().name().substring("ROLE_".length())
                : "USER";

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

    // Lista de Entity → Lista de DTO
    public static List<UsuarioResponseDto> toListDto(List<CadastroEntity> cadastros) {
        return cadastros.stream()
                .map(CadastroMapper::toDto)
                .collect(Collectors.toList());
    }
}
