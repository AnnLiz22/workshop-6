//package pl.coderslab;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//
//import java.util.Optional;
//
//public class TypeConverter implements Converter<String, Optional<Type>> {
//
//    @Autowired
//    private TypeRepository typeRepository;
//
//    @Override
//    public Optional<Type> convert(String source) {
//        return typeRepository.findById(Long.parseLong(source));
//    }
//}