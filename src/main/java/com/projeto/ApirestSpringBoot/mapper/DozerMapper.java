package com.projeto.ApirestSpringBoot.mapper;

//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//import com.github.dozermapper.core.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

public class DozerMapper {

    
    //private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); //usando o DozerMapper
    private static ModelMapper mapper = new ModelMapper(); //usando o ModelMapper

    
    //Origem , destino
    public static <O, D> D parseObject(O origem, Class<D> destino) {

        return mapper.map(origem, destino);

    }

    
    
    public static <O, D> List<D> parseListObjects(List<O> origem, Class<D> destino) {

        List<D> destinoObjetos = new ArrayList<>();

        for (O o : origem) {
            destinoObjetos.add(mapper.map(o, destino));
        }

        return destinoObjetos;

    }

}
